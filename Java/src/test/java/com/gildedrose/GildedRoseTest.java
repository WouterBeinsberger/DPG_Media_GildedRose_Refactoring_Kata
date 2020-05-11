package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void standardItemDecreaseSellInAndQualityByOne() {
        GildedRose app = gildedRoseItem("Standard item", 10,10);
        app.updateQuality();
        assertEquals(9, getQuality(app));
        assertEquals(9, getSellIn(app));
    }

    @Test
    void standardItemSellInNegativeDecreaseQualityByTwo() {
        GildedRose app = gildedRoseItem("Standard item", 0,10);
        app.updateQuality();
        assertEquals(8, getQuality(app));
        assertEquals(-1, getSellIn(app));
    }

    @Test
    void standardItemQualityIsNeverNegative() {
        GildedRose app = gildedRoseItem("Standard item", 0,0);
        app.updateQuality();
        assertEquals(0, getQuality(app));
    }

    @Test
    void agedBrieQualityIncreaseByOneSellInDecreaseByOne() {
        GildedRose app = gildedRoseItem("Aged Brie", 10,10);
        app.updateQuality();
        assertEquals(11, getQuality(app));
        assertEquals(9, getSellIn(app));
    }

    @Test
    void agedBrieSellInNegativeIncreaseQualityByTwo() {
        GildedRose app = gildedRoseItem("Aged Brie", 0,10);
        app.updateQuality();
        assertEquals(12, getQuality(app));
        assertEquals(-1, getSellIn(app));
    }

    @Test
    void agedBrieQualityIsNeverMoreThanFifty() {
        GildedRose app = gildedRoseItem("Aged Brie", 0,50);
        app.updateQuality();
        assertEquals(50, getQuality(app));
        assertEquals(-1, getSellIn(app));
    }

    @Test
    void sulfurasQualityIsAlwaysEighty() {
        GildedRose app = gildedRoseItem("Sulfuras, Hand of Ragnaros", 0,50);
        app.updateQuality();
        assertEquals(80, getQuality(app));
        assertEquals(0, getSellIn(app));
    }

    @Test
    void sulfurasNeverChangesValues() {
        GildedRose app = gildedRoseItem("Sulfuras, Hand of Ragnaros", 0,80);
        app.updateQuality();
        assertEquals(80, getQuality(app));
        assertEquals(0, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIncreaseByOneSellInLargerThanTen() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 12,10);
        app.updateQuality();
        assertEquals(11, getQuality(app));
        assertEquals(11, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIncreaseByTwoSellInEqualsTen() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 11,10);
        app.updateQuality();
        assertEquals(12, getQuality(app));
        assertEquals(10, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIncreaseByTwoSellInLargerThanFive() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 7,10);
        app.updateQuality();
        assertEquals(12, getQuality(app));
        assertEquals(6, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIncreaseByThreeSellInEqualsFive() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 6,10);
        app.updateQuality();
        assertEquals(13, getQuality(app));
        assertEquals(5, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIncreaseByThreeSellInLargerThanZero() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 2,10);
        app.updateQuality();
        assertEquals(13, getQuality(app));
        assertEquals(1, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIsZeroSellInEqualsZero() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 1,10);
        app.updateQuality();
        assertEquals(0, getQuality(app));
        assertEquals(0, getSellIn(app));
    }

    @Test
    void backstagePassesQualityIsZeroSellInLessThanZero() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", -1,10);
        app.updateQuality();
        assertEquals(0, getQuality(app));
    }

    @Test
    void backstagePassesQualityMaximumIsFifty() {
        GildedRose app = gildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 5,50);
        app.updateQuality();
        assertEquals(50, getQuality(app));
    }

    @Test
    void conjuredItemQualityDecreaseByTwo() {
        GildedRose app = gildedRoseItem("Conjured item", 10,10);
        app.updateQuality();
        assertEquals(8, getQuality(app));
        assertEquals(9, getSellIn(app));
    }

    @Test
    void conjuredItemQualityDecreaseByFourSellInNegative() {
        GildedRose app = gildedRoseItem("Conjured item", 0,10);
        app.updateQuality();
        assertEquals(6, getQuality(app));
        assertEquals(-1, getSellIn(app));
    }

    @Test
    void conjuredItemQualityIsNeverNegative() {
        GildedRose app = gildedRoseItem("Conjured item", 0,0);
        app.updateQuality();
        assertEquals(0, getQuality(app));
    }

    private int getQuality(GildedRose app) {
        return app.items[0].quality;
    }

    private int getSellIn(GildedRose app) {
        return app.items[0].sellIn;
    }

    private GildedRose gildedRoseItem(String name, int sellIn, int quality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        return new GildedRose(items);
    }



}
