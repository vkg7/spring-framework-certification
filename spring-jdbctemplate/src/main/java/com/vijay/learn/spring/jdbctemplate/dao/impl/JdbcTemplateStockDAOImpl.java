package com.vijay.learn.spring.jdbctemplate.dao.impl;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring.jdbctemplate.dao.StockDAO;
import com.vijay.learn.spring.jdbctemplate.model.Stock;
import com.vijay.learn.spring.jdbctemplate.model.rowmapper.StockRowMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Component
public class JdbcTemplateStockDAOImpl implements StockDAO {

    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_STOCK = "select * from stock where stock_id = ?";
    private final String SQL_FIND_STOCK_NAME = "select stock_name from stock where stock_id = ?";
    private final String SQL_COUNT_OF_STOCK = "select count(*) from stock";
    private final String SQL_DELETE_STOCK = "delete from stock where id = ?";
    private final String SQL_UPDATE_STOCK = "update stock set favorite = ?, market_cap = ? where id = ?";
    private final String SQL_GET_ALL_STOCK = "select * from stock";
    private final String SQL_INSERT_STOCK = "insert into stock(stock_id, stock_name, symbol, company,favorite,start_year,market_cap) values(?,?,?,?,?,?,?)";

    public JdbcTemplateStockDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);;
    }

    @Override
    public boolean insertStock(Stock stock) {
        return jdbcTemplate.update(SQL_INSERT_STOCK, stock.getStockId(), stock.getStockName(),stock.getSymbol(),stock.getCompany(),stock.getFavorite(),stock.getStartYear(),stock.getMarketCap()) > 0;
    }

    @Override
    public List<Stock> findAll() {
        return jdbcTemplate.query(SQL_GET_ALL_STOCK, new StockRowMapper());
    }

    @Override
    public int[] batchInsert(List<Stock> stocks) {
        int[] updateCounts = jdbcTemplate.batchUpdate(SQL_INSERT_STOCK, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, stocks.get(i).getStockId());
                ps.setString(2, stocks.get(i).getStockName());
                ps.setString(3, stocks.get(i).getSymbol());
                ps.setString(4, stocks.get(i).getCompany());
                ps.setString(5, stocks.get(i).getFavorite());
                ps.setTimestamp(6, Timestamp.valueOf(stocks.get(i).getStartYear()));
                ps.setLong(7, stocks.get(i).getMarketCap());
            }

            @Override
            public int getBatchSize() {
                return stocks.size();
            }
        });
        return updateCounts;
    }

    @Override
    public int countOfStocks() {
        return jdbcTemplate.queryForObject(SQL_COUNT_OF_STOCK,Integer.class);
    }
}
