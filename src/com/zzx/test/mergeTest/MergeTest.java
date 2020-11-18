package com.zzx.test.mergeTest;

import java.util.*;

public class MergeTest {
    @org.junit.Test
    public void mergeTest() {
        long time = new Date().getTime();
        LinkedList<PackageInfo> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.setGoodsId(r.nextInt(500));
            packageInfo.setGoodsNumber(r.nextInt(100));
            list.add(packageInfo);
        }
//        System.out.println(list);
        list.sort(Comparator.comparing(PackageInfo::getGoodsId));
//        System.out.println(list);
        List<Integer> removeIndexs = new LinkedList<>(); // 需要移除的格子

        for (int i = 0; i < list.size(); i++) {
            PackageInfo currentPackageInfo = list.get(i);
            if (i == list.size() - 1)
                break;

            PackageInfo nextPackageInfo = list.get(i + 1);
            int currentGoodsId = currentPackageInfo.getGoodsId();
            if (currentGoodsId != nextPackageInfo.getGoodsId())
                continue;

            if (currentPackageInfo.getGoodsNumber() == 0) {
                continue;
            }
            int shangxian = 100;// 暂定加入背包的这个物品读取的上限是100（待读配置）
            mergeAlgorithm(currentPackageInfo, nextPackageInfo, shangxian, i, removeIndexs, list);
        }
        System.out.println(list);
        System.out.println(new Date().getTime() - time);
        System.out.println(removeIndexs);
    }
    /**
     * 如果相同的物品id,则找到该物品的最后一个,
     * 从最后面的两个物品向前累加
     * @param currentPackageInfo 当前的物品对象
     * @param nextPackageInfo 下一个的物品对象
     * @param shangxian 物品格子上限
     * @param index 当前物品对象的索引位置
     * @param removeIndexs 要移除的list
     * @param list 要整理的物品对象(背包或仓库)列表
     */
    private void mergeAlgorithm(PackageInfo currentPackageInfo, PackageInfo nextPackageInfo, int shangxian, int index,  List<Integer> removeIndexs, List<PackageInfo> list) {
        if (index + 2 < list.size() - 1) {
            if (nextPackageInfo.getGoodsId() == list.get(index + 2).getGoodsId()) {
                mergeAlgorithm(nextPackageInfo,list.get(index + 2), shangxian, index + 1, removeIndexs, list);
            }
        }
        int currentGoodsNumber = currentPackageInfo.getGoodsNumber();
        int nextGoodsNumber = nextPackageInfo.getGoodsNumber();

        if (currentGoodsNumber + nextGoodsNumber > shangxian) {
            currentPackageInfo.setGoodsNumber(shangxian);
            nextPackageInfo.setGoodsNumber(currentGoodsNumber + nextGoodsNumber - shangxian);
        } else {
            currentPackageInfo.setGoodsNumber(currentGoodsNumber + nextGoodsNumber);
            nextPackageInfo.setGoodsNumber(0);
            removeIndexs.add(index + 1);
        }
    }
}
