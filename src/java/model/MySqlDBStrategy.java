/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dan
 */
public class MySqlDBStrategy implements DBStrategy {
    private Connection conn;
    
    
    @Override
    public void openConnection(String driverClass, String url, 
            String userName, String password) throws ClassNotFoundException, SQLException {
        
        Class.forName (driverClass);
        conn = DriverManager.getConnection(url,userName, password);
        
    }
    
    /**
     *
     * @throws SQLException
     */
    @Override
    public void closeConnection() throws SQLException {
        conn.close();
    }
    
    /**
     * Make sure you open and close connection when using this method
     * @param tableName
     * 
     * @param maxRecords - limits records found to first maxRecords or if first maxRecords
     * is zero, then no limit
     * 
     * Future optimization may include changing return type from list to array to save memory
     * 
     * @return 
     */
    
    @Override
    public List<Map<String, Object>> findAllRecords(String tableName, int maxRecords) 
            throws SQLException{
   
        String sql;
        if(maxRecords < 1){
            sql="select * from " + tableName;
        } else {
            sql = "select * from " + tableName + " limit " + maxRecords;
        }
        Statement stmt = conn.createStatement();     
        ResultSet rs = stmt.executeQuery(sql);   
        ResultSetMetaData rsmd = rs.getMetaData();
    
        //get number of columns
        int columnCount = rsmd.getColumnCount();
        List<Map<String, Object>> records = new ArrayList<>();
        while(rs.next()){
            Map<String, Object> record = new HashMap<>();
            for(int colNo = 1; colNo <= columnCount; colNo ++){
                Object colData = rs.getObject(colNo);
                String colName = rsmd.getColumnName(colNo);
                record.put(colName, colData);
            }
            records.add(record);
        } 
        return records;
    }
    
    
    
    /**
     * WRITE METHOD TO DELETE A RECORD BY ID
     */
    
    @Override
    public void deleteRecordInTable(String tableName, String columnName, Object primaryKey) throws SQLException {
        if (tableName.isEmpty() || columnName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        PreparedStatement deleteRecord = null;
        String deleteQryString = null;

        deleteQryString = "DELETE FROM " + tableName + " WHERE " + columnName + "=?";

        deleteRecord = conn.prepareStatement(deleteQryString);
        if (primaryKey instanceof String) {
            deleteRecord.setString(1, primaryKey.toString());
        }else{
            deleteRecord.setInt(1, Integer.parseInt(primaryKey.toString()));
        }
        System.out.println(deleteRecord);
        deleteRecord.executeUpdate();
        System.out.println("Record has been deleted");

    }
    
    
    
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBStrategy db = new MySqlDBStrategy();
        db.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/book", "root", "admin");
        
        List<Map<String, Object>> rawData = db.findAllRecords("author",0);
        
        db.closeConnection();
        
        System.out.println(rawData);
    }
    
    
    
    
    
    
}

