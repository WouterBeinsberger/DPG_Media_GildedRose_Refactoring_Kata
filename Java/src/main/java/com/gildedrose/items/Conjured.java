package com.gildedrose.items;

import com.gildedrose.Item;

public class Conjured {

    private final Item item;
    private static final int STANDARD_DECREASING_VALUE_SELL_IN = 1;
    private static final int STANDARD_DECREASING_VALUE_QUALITY = 2;

    public Conjured(Item item) {
        this.item = item;
        updateQualityAndSellIn();
    }

    private void updateQualityAndSellIn() {
        decreaseSellInByOne();
        if (sellInValueIsGreaterThanZero()) {
            decreaseQuality(STANDARD_DECREASING_VALUE_QUALITY);
        } else {
            decreaseQualityTwiceAsFast();
        }
    }

    private void decreaseQuality(int decreasingValueQuality) {
        item.quality -= decreasingValueQuality;
    }

    private void decreaseQualityTwiceAsFast() {
        decreaseQuality(STANDARD_DECREASING_VALUE_QUALITY * 2);
    }

    private boolean sellInValueIsGreaterThanZero(){
        return item.sellIn > 0;
    }

    private void decreaseSellInByOne() {
        item.sellIn -= STANDARD_DECREASING_VALUE_SELL_IN;
    }
}
