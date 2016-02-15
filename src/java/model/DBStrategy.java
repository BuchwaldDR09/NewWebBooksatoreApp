/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dan
 */

public interface DBStrategy {
    
    public abstract void openConnection(String driverClass, String url, 
            String userName, String password) 
            throws ClassNotFoundException, SQLException;
    
    public abstract void closeConnection() throws SQLException;

    public List<Map<String, Object>> findAllRecords(String author, int i) throws SQLException;
    
    public abstract void deleteRecordInTable(String tableName, String columnName, Object primaryKey) throws SQLException;
}
