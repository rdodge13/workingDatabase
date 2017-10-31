
package creatingsqlitedatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class InsertData {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
   
    public Connection connect() {
        // SQLite connection string
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
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
 

        InsertData app = new InsertData();
        app.getClass();
        
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
        GetData get=new GetData();
         get.getClass();
        GetData.main(args);
        
    }
 
}
