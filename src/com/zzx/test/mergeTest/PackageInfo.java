package com.zzx.test.mergeTest;

public class PackageInfo {
    private int id;
    private int goodsId;
    private int goodsNumber;
    private int goodsSurplus;
    private int goodsIndex;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public int getGoodsSurplus() {
        return goodsSurplus;
    }

    public void setGoodsSurplus(int goodsSurplus) {
        this.goodsSurplus = goodsSurplus;
    }

    public int getGoodsIndex() {
        return goodsIndex;
    }

    public void setGoodsIndex(int goodsIndex) {
        this.goodsIndex = goodsIndex;
    }

    @Override
    public String toString() {
        return "PackageInfo{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsNumber=" + goodsNumber +
                ", goodsSurplus=" + goodsSurplus +
                ", goodsIndex=" + goodsIndex +
                ", type=" + type +
                '}';
    }
}
