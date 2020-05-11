package com.gildedrose;

import com.gildedrose.items.*;

public class UpdateItem {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";
    private static final int LOWEST_STANDARD_QUALITY = 0;
    private static final int HIGHEST_STANDARD_QUALITY = 50;


    public UpdateItem(Item item){
        sortItem(item);
        qualityCheck(item);
    }

    private void sortItem(Item item) {
        switch(item.name) {
            case AGED_BRIE:
                new AgedBrie(item);
                break;
            case BACKSTAGE_PASS:
                new BackstagePass(item);
                break;
            case SULFURAS:
                new Sulfuras(item);
                break;
            default:
                standardOrConjured(item);
        }
    }

    private void qualityCheck(Item item) {
        lowestQualityCheck(item);
        highestQualityCheck(item);
    }

    private void lowestQualityCheck(Item item) {
        if(item.quality < LOWEST_STANDARD_QUALITY){
            item.quality = LOWEST_STANDARD_QUALITY;
        }
    }

    private void highestQualityCheck(Item item) {
        if(!item.name.equals(SULFURAS) && item.quality > HIGHEST_STANDARD_QUALITY){
            item.quality = HIGHEST_STANDARD_QUALITY;
        }
    }

    private void standardOrConjured(Item item) {
        if(item.name.contains(CONJURED)){
            new Conjured(item);
        } else {
            new StandardItem(item);
        }
    }

}
