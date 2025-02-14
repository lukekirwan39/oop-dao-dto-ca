package org.example.DAOs;

import org.example.DTOs.ExpenseDTO;
import org.example.DTOs.IncomeDTO;

import java.sql.SQLException;
import java.util.List;

public interface FinanceDaoInterface<T> {

    void add(T finance) throws SQLException;

    List<T> getAll() throws SQLException;

    void delete(int id) throws SQLException;

}
