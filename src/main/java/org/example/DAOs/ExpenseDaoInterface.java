package org.example.DAOs;

import org.example.DTOs.ExpenseDTO;

import java.sql.SQLException;
import java.util.List;

public interface ExpenseDaoInterface {

    void add(ExpenseDTO expense) throws SQLException;

    List<ExpenseDTO> getAll() throws SQLException;

    void delete(int id) throws SQLException;
}
