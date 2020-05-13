package com.vijay.learn.spring.jdbctemplate.dao;

import com.vijay.learn.spring.jdbctemplate.model.Stock;

import java.awt.print.Book;
import java.util.List;

public interface StockDAO {
    boolean insertStock(Stock stock);
    public List<Stock> findAll();
    public int[] batchInsert(List<Stock> stocks);
    public int countOfStocks();
}
