
package creatingsqlitedatabase;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class GetData {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    public Connection connect() {
        // SQLite connection string
        //Class.forName("org.sqlight.JDBC");
        String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            
        return conn;
    
        
    }
 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT id, name, capacity FROM warehouses";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String url = "jdbc:sqlite:C:\\Users\\rdodg\\Desktop\\Ryan's School\\Sophmore Project\\SQLite\\test.db";
        GetData app = new GetData();
        app.selectAll();
      
        
    }
 
}