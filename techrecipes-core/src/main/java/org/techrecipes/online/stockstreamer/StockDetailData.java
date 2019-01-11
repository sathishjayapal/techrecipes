package org.techrecipes.online.stockstreamer;
/**
 * Created by sjayapal on 12/22/2016.
 */
public class StockDetailData {
    /**
     * id : 304466804484872
     * t : GOOG
     * e : NASDAQ
     * l : 790.19
     * l_fix : 790.19
     * l_cur : 790.19
     * s : 0
     * ltt : 11:56AM EST
     * lt : Dec 22, 11:56AM EST
     * lt_dts : 2016-12-22T11:56:58Z
     * c : -4.37
     * c_fix : -4.37
     * cp : -0.55
     * cp_fix : -0.55
     * ccol : chr
     * pcls_fix : 794.56
     *
     */
    @com.google.gson.annotations.SerializedName("id")
    private String stockid;
    @com.google.gson.annotations.SerializedName("t")
    private String stockTickr;
    @com.google.gson.annotations.SerializedName("e")
    private String stockExchange;
    @com.google.gson.annotations.SerializedName("l")
    private String currentdaylow;
    @com.google.gson.annotations.SerializedName("l_fix")
    private String todayFixed;
    @com.google.gson.annotations.SerializedName("lt_dts")
    private String stockPriceDateTime;
    @com.google.gson.annotations.SerializedName("c")
    private String todayChange;
    private String businessName;
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getStockid() {
        return stockid;
    }
    public void setStockid(String stockid) {
        this.stockid = stockid;
    }
    public String getStockTickr() {
        return stockTickr;
    }
    public void setStockTickr(String stockTickr) {
        this.stockTickr = stockTickr;
    }
    public String getStockExchange() {
        return stockExchange;
    }
    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }
    public String getCurrentdaylow() {
        return currentdaylow;
    }
    public void setCurrentdaylow(String currentdaylow) {
        this.currentdaylow = currentdaylow;
    }
    public String getTodayFixed() {
        return todayFixed;
    }
    public void setTodayFixed(String todayFixed) {
        this.todayFixed = todayFixed;
    }
    public String getStockPriceDateTime() {
        return stockPriceDateTime;
    }
    public void setStockPriceDateTime(String stockPriceDateTime) {
        this.stockPriceDateTime = stockPriceDateTime;
    }
    public String getTodayChange() {
        return todayChange;
    }
    public void setTodayChange(String todayChange) {
        this.todayChange = todayChange;
    }
}
