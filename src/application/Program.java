
package application;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;
/**
 *
 * @author Roberto
 */
public class Program {
    
    public static void main(String[] args){
        
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            
            st = conn.prepareStatement(
                "delete from seller "
                + "where "
                + "Id = ?");
            
            st.setInt(1, 6);
            
            int rowsAffected = st.executeUpdate();
            
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }    
}
