package com.vijay.learn.spring.jdbctemplate.dao.impl;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring.jdbctemplate.dao.StockDAO;
import com.vijay.learn.spring.jdbctemplate.model.Stock;
import com.vijay.learn.spring.jdbctemplate.model.rowmapper.StockRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NamedParamJdbcTemplateStockDAOImpl implements StockDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SQL_FIND_STOCK = "select * from stock where stock_id = :stockId";
    private final String SQL_FIND_STOCK_NAME = "select stock_name from stock where stock_id = :stockId";
    private final String SQL_COUNT_OF_STOCK = "select count(*) from stock";
    private final String SQL_DELETE_STOCK = "delete from stock where id = :stockId";
    private final String SQL_UPDATE_STOCK = "update stock set favorite = :favorite, market_cap = :marketCap where id = :stockId";
    private final String SQL_GET_ALL_STOCK = "select * from stock";
    private final String SQL_INSERT_STOCK = "insert into stock(stock_id, stock_name, symbol, company,favorite,start_year,market_cap) values(:stockId,:stockName,:symbol,:company,:favorite,:startYear,:marketCap)";

    public NamedParamJdbcTemplateStockDAOImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);;
    }

    @Override
    public boolean insertStock(Stock stock) {
        Map namedParameters = new HashMap();
        namedParameters.put("stockId", stock.getStockId());
        namedParameters.put("stockName", stock.getStockName());
        namedParameters.put("symbol", stock.getSymbol());
        namedParameters.put("company", stock.getCompany());
        namedParameters.put("favorite", stock.getFavorite());
        namedParameters.put("startYear", stock.getStartYear());
        namedParameters.put("marketCap", stock.getMarketCap());
        return namedParameterJdbcTemplate.update(SQL_INSERT_STOCK,namedParameters) > 0;
    }

    @Override
    public List<Stock> findAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_STOCK, new StockRowMapper());
    }

    @Override
    public int[] batchInsert(List<Stock> stocks)
    {
        int[] count = {0};
        List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
        for (Stock stock : stocks) {
            parameters.add(new BeanPropertySqlParameterSource(stock));
        }

        count = namedParameterJdbcTemplate.batchUpdate(SQL_INSERT_STOCK,parameters.toArray(new SqlParameterSource[0]));
        return count;
    }

    @Override
    public int countOfStocks() {
        SqlParameterSource namedParameters = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.queryForObject(SQL_COUNT_OF_STOCK,namedParameters,Integer.class);
    }
}
