package org.example.DAOs;

import org.example.DTOs.IncomeDTO;

import java.sql.SQLException;
import java.util.List;

public interface IncomeDaoInterface {

    void add(IncomeDTO income) throws SQLException;

    List<IncomeDTO> getAll() throws SQLException;

    void delete(int id) throws SQLException;
}
