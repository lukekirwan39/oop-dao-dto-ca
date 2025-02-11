package org.example.DAOs;

import java.sql.Connection;

public class IncomeDAO {
    private Connection conn;

    public IncomeDAO(Connection conn){
        this.conn = conn;
    }
}
