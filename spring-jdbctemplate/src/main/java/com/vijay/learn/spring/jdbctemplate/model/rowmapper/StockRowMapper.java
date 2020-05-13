package com.vijay.learn.spring.jdbctemplate.model.rowmapper;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring.jdbctemplate.model.Stock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

public class StockRowMapper implements RowMapper<Stock> {

    @Override
    public Stock mapRow(ResultSet resultSet, int i) throws SQLException {
        Stock stock = new Stock();
        stock.setStockId(resultSet.getLong("stock_id"));
        stock.setStockName(resultSet.getString("stock_name"));
        stock.setSymbol(resultSet.getString("symbol"));
        stock.setCompany(resultSet.getString("company"));
        stock.setFavorite(resultSet.getString("favorite"));
        stock.setStartYear(resultSet.getTimestamp("start_year").toLocalDateTime());
        stock.setMarketCap(resultSet.getLong("market_cap"));
        return stock;
    }
}
