## 背景
项目中需要对背包中的物品进行一个整理的操作.
对相同的物品id进行排序并将多余的物品合并到一个格子中（不会留空格子）,不同的物品有不同的物品上限,
合并后数量为0的格子则需要删除掉.
因此写了一个整理合并的算法.

## 步骤

```
1.随机生成一定数量的随机id的PackageInfo对象
2.按物品id顺序对list进行排序（根据公司物品排序规则顺序来）
3.如果是最后一个元素则直接中断循环
4.如果当前数量为 0 则跳过当前循环
5.如果与下一个元素的id不相同,则直接跳过当前循环
6.根据物品id读取配置表中的物品上限（测试代码固定一个上限）
7.开始递归合并
    查找是否有多个相同物品id的格子,一直找到最后一个
    从最后面的两个物品向前累加,并将数量为 0的对象记录下来
```
## 测试
当要参与运算的PackageInfo对象在1500个内的时候,总体运算时间大致在60~70ms之间,2000个大致在100ms,3000个大致是150ms,10000个大致在550ms,对于正常的游戏玩家来说,有几百个物品都算多的了,运算时间还算可以.

## 问题
1.在循环过程中,有些数量为 0 的下标，会被重复放进到removeList里面,虽然对后续删除的元素无影响,如果能进一步优化,那自然是好的了.