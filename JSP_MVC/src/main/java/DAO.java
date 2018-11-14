
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class DAO {

        protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;  
	}
       
        public Hashtable<String, Float> getElements(){
            Hashtable<String,Float> result = new Hashtable<String,Float>();
            
            String sql = "SELECT * FROM DISCOUNT_CODE";
            try(Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)){
                
                try (ResultSet rs = stmt.executeQuery()){
                    while(rs.next()){
                        String key = rs.getString("DISCOUNT_CODE");
                        Float val = rs.getFloat("RATE");
                        result.put(key, val);
                    }
                }
                
            }  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                        
            }
            return result;
        }
        
        public String add(String key, Float val) throws SQLException{
           
            String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";
            try (Connection connection = myDataSource.getConnection(); 
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, key);
                    stmt.setFloat(2, val);
                    stmt.executeUpdate();
            } catch (SQLException ex){
                return "Les valeurs " + key + " : " + val.toString() + "  n'ont pas été insérées ";
            }
            return "Les valeurs " + key + " a bien été ajouté";
        }
        
        public String delete(String key) throws SQLException{
            
            String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
            try (Connection connection = myDataSource.getConnection(); 
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, key);
                    stmt.executeUpdate();
            } catch (SQLException ex){
                return "La ligne associée au code " + key + " n'a pas été modifiée";
            }
            return "Le code "+key+" a été supprimé";
        }
        
        
        
       
        
    
}
