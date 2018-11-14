
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import javax.sql.DataSource;



public class DAO {

        Hashtable<String, String> ht; 
        List<String> init;
	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
    
	public DAO() {
       
            init = Arrays.asList("H", "L", "M", "N");
            ht = new Hashtable<String, String>();
            /*ht.put("H", "16.00");
            ht.put("L", "07.00");
            ht.put("M", "11.00");
            ht.put("N", "00.00");*/
        }
        
        public String delete(String key){
            if(init.contains(key)){
                return "Impossible de supprimer "+ key + ", ce code est utilisé.";
            }else{
                ht.remove(key);
                return "Code " + key + " Supprimé";
            }
            
        }
        
        public String add(String key, String val){
            if(init.contains(key)){
                return "Code " + key + " deja existant";
            } else {
                ht.put(key, val);
                return "Code " + key + " Ajouté";
            }
            
        }
        
    
}
