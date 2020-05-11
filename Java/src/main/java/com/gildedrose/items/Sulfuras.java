package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras {

    private final Item item;
    private static final int QUALITY = 80;


    public Sulfuras(Item item){
        this.item = item;
        maintainQualityAndSellIn();
    }

    private void maintainQualityAndSellIn() {
        setQuality();
    }

    private void setQuality() {
        item.quality = QUALITY;
    }



}
