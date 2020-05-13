package com.vijay.learn.spring.jdbctemplate.client;

import com.vijay.learn.spring.jdbctemplate.config.ApplicationConfig;
import com.vijay.learn.spring.jdbctemplate.dao.PersonDAO;
import com.vijay.learn.spring.jdbctemplate.dao.StockDAO;
import com.vijay.learn.spring.jdbctemplate.dao.impl.JdbcTemplateStockDAOImpl;
import com.vijay.learn.spring.jdbctemplate.model.Person;
import com.vijay.learn.spring.jdbctemplate.model.Stock;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JdbcTemplateStockClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        StockDAO stockDAO = context.getBean(JdbcTemplateStockDAOImpl.class);

        /*System.out.println("\nCreating stock: ");
        Stock stock = new Stock(2L,"ORCL","ORCL","Oracle India Ltd.","true", LocalDateTime.now(),256985632L);
        System.out.println(stock);
        stockDAO.insertStock(stock);*/

        System.out.println("Batch insert of 2000 records.");
        List<Stock> stockList = new ArrayList<>();
        for (int i = 1; i <= 2000; i++) {
            Stock stock = new Stock(Long.valueOf(i),"ABC"+i,"XYZ"+i,"ABC"+i+" Pvt. Ltd.","true", LocalDateTime.now(), Long.valueOf(ThreadLocalRandom.current().nextInt()));
            stockList.add(stock);
        }
        stockDAO.batchInsert(stockList);

        System.out.println("\nTotal Stocks Count :"+stockDAO.countOfStocks());

        /*System.out.println("\nList of stock is:");

        for (Stock s : stockDAO.findAll()) {
            System.out.println(s);
        }*/

        context.close();
    }

}
