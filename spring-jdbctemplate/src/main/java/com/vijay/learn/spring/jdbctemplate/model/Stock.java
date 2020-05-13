package com.vijay.learn.spring.jdbctemplate.model;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import java.time.LocalDateTime;

/*
    create table stock (
        stock_id serial not null primary key,
        stock_name varchar(20) DEFAULT NULL,
        symbol varchar(20) DEFAULT NULL,
        company varchar(20) DEFAULT NULL,
        favorite varchar(20) DEFAULT NULL,
        start_year date DEFAULT NULL,
        market_cap integer DEFAULT NULL
    );
*/

public class Stock {

    private Long stockId;
    private String stockName;
    private String symbol;
    private String company;
    private String favorite;
    private LocalDateTime startYear;
    private Long marketCap;

    public Stock() {
    }

    public Stock(Long stockId, String stockName, String symbol, String company, String favorite, LocalDateTime startYear, Long marketCap) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.symbol = symbol;
        this.company = company;
        this.favorite = favorite;
        this.startYear = startYear;
        this.marketCap = marketCap;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public LocalDateTime getStartYear() {
        return startYear;
    }

    public void setStartYear(LocalDateTime startYear) {
        this.startYear = startYear;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", company='" + company + '\'' +
                ", favorite='" + favorite + '\'' +
                ", startYear=" + startYear +
                ", marketCap=" + marketCap +
                '}';
    }
}
