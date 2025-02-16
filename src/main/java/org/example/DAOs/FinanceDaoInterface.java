package org.example.DAOs;

import java.util.List;

public interface FinanceDaoInterface {

//    void add(T finance) throws SQLException;
//
//    List<T> getAll() throws SQLException;
//
//    void delete(int id) throws SQLException;

    List<Object> getTransactionsForMonth(int month, int year);

    void getTotalSummary(int month, int year);

}
