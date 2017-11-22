
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
 Connection conectar =null;   

 
 public ConexaoBD() throws SQLException, ClassNotFoundException{
     try{
         
         Class.forName("org.postgresql.Driver"); 
         conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trab_prog_ii", "postgres", "pracaba");
     } 

catch(Exception e){
    System.out.println(e.getMessage());
 }

 }
    public  Connection getConnection(){
    return conectar;  
}

    public void desconectar(){
    conectar = null;
    
    }

}
