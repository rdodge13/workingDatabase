/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatingsqlitedatabase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CreatingSQLiteDatabase {

   /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:test.db" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
 
    public static void main(String[] args) {
        createNewDatabase("test.db");
         // SQLite connection string
        String url = "jdbc:sqlite:test.db";
        
 
        CreateTable class1= new CreateTable();
        class1.getClass();
   CreateTable.createNewTable();
   CreateTable.main(args);
   
 // String url = "jdbc:sqlite:C:\\Users\\rdodg\\Desktop\\Ryan's School\\Sophmore Project\\SQLite\\test.db";
       
InsertData class2= new InsertData();
      class2.getClass();
           InsertData.main(args);
        
        GetData class3=new GetData();
        class3.getClass();
        GetData.main(args);
        
       
    }
}