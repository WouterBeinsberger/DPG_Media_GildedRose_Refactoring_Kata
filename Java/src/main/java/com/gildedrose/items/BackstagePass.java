package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass {

    private final Item item;
    private static final int STANDARD_DECREASING_VALUE_SELL_IN = 1;
    private static final int STANDARD_INCREASING_VALUE_QUALITY = 1;

    public BackstagePass(Item item){
        this.item = item;
        updateQualityAndSellIn();
    }

    private void updateQualityAndSellIn() {
        decreaseSellInByOne();
        if (sellInValueIsGreaterThan(10)){
            increaseQuality(STANDARD_INCREASING_VALUE_QUALITY);
        } else if(sellInValueIsGreaterThan(5)){
            increaseQuality(STANDARD_INCREASING_VALUE_QUALITY * 2);
        } else if(sellInValueIsGreaterThan(0)){
            increaseQuality(STANDARD_INCREASING_VALUE_QUALITY * 3);
        } else {
            item.quality = 0;
        }

    }

    private void increaseQuality(int increaseValueQuality) {
        item.quality += increaseValueQuality;
    }

    private boolean sellInValueIsGreaterThan(int sellInValue) {
        return item.sellIn > sellInValue;
    }

    private void decreaseSellInByOne() {
        item.sellIn -= STANDARD_DECREASING_VALUE_SELL_IN;
    }


}
