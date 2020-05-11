package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie {

    private final Item item;
    private static final int STANDARD_DECREASING_VALUE_SELL_IN = 1;
    private static final int STANDARD_INCREASING_VALUE_QUALITY = 1;

    public AgedBrie(Item item){
        this.item = item;
        updateQualityAndSellIn();
    }

    private void updateQualityAndSellIn() {
        decreaseSellInByOne();
        if (sellInValueIsGreaterThanZero()){
            increaseQuality(STANDARD_INCREASING_VALUE_QUALITY);
        }else {
            increaseQualityTwiceAsFast();
        }
    }

    private void increaseQualityTwiceAsFast() {
        increaseQuality(STANDARD_INCREASING_VALUE_QUALITY * 2);
    }

    private boolean sellInValueIsGreaterThanZero(){
        return item.sellIn > 0;
    }

    private void increaseQuality(int increasingValueQuality) {
        item.quality += increasingValueQuality;
    }

    private void decreaseSellInByOne() {
        item.sellIn -= STANDARD_DECREASING_VALUE_SELL_IN;
    }

}
