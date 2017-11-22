
package classDAO;

import classVO.Endereco;
import classVO.Usuario;
import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProDaox {
   
    public static String registrar(Endereco end) throws SQLException, ClassNotFoundException{
      String resul = null, last = null;
      ConexaoBD cc = new ConexaoBD(); 
      Connection cn = cc.getConnection();
      PreparedStatement pst = null;
      String sql;
      sql = ("INSERT INTO endereco values(null, ?,?,?,?,?");

    try{
    
        pst = cn.prepareStatement(sql);
        pst.setString(1, end.getComplemento());
        pst.setString(2, end.getLogradouro());
        pst.setString(3, end.getBairro());
        pst.setString(4, end.getCep());
        pst.setString(5, end.getNumero());
        pst.execute();
        pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
    if(rs.next()){
        last = rs.getString(1);
    }
    resul = "Registrado!";
    
    }

    catch(SQLException e){
    resul = "Erro";
    
    }finally{
        try{
        if(cn != null){
            cn.close();
            pst.close();
        }
        }
    
    catch(Exception e){
       resul = "Erro";     
            }
    return resul;
    
    }
   
    
    }


   
    public static String atualizar(Endereco end) throws SQLException, ClassNotFoundException{
      String resul = null, last = null;
      ConexaoBD cc = new ConexaoBD(); 
      Connection cn = cc.getConnection();
      PreparedStatement pst = null;
      String sql;
      sql = "UPDATE endereco SET complemento=?, logradouro=?, bairro=?, cep=?, numero=?";

    try{
    
        pst = cn.prepareStatement(sql);
        pst.setString(1, end.getComplemento());
        pst.setString(2, end.getLogradouro());
        pst.setString(3, end.getBairro());
        pst.setString(4, end.getCep());
        pst.setString(5, end.getNumero());
        pst.execute();
       
    resul = "Atualizado!";
    
    }

    catch(SQLException e){
    resul = "Erro";
    
    }finally{
        try{
        if(cn != null){
            cn.close();
            pst.close();
        }
        }
    
    catch(Exception e){
       resul = "Erro";     
            }
    }
        return resul;
    
    }
    

   
    public static Usuario buscar(String chave) throws SQLException, ClassNotFoundException{
      Usuario uso = new Usuario();
      String resul = null;
      ConexaoBD cc = new ConexaoBD(); 
      Connection cn = cc.getConnection();
      PreparedStatement pst = null;
      String sql;
      sql = "SELECT* FROM endereco";

    try{
    
        pst = cn.prepareStatement(sql);
        pst.setString(1, chave);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
        uso.setComplemento(rs.getString(1));
        uso.setBairro(rs.getString(1));
        uso.setNumero(rs.getString(1));
        uso.setCep(rs.getString(1));
        uso.setLogradouro(rs.getString(1));
        }
       
    uso.setResultado( "Busca com exito!");
    
    }

    catch(SQLException e){
    resul = "Erro";
    
    }finally{
        try{
        if(cn != null){
            cn.close();
            pst.close();
        }
        }
    
    catch(Exception e){
       resul = "Erro";     
            }
    return uso;
    
    }
    }

   
    public static String eliminarEndereco(String chave) throws SQLException, ClassNotFoundException{
      Usuario uso = new Usuario();
      String resul = null;
      ConexaoBD cc = new ConexaoBD(); 
      Connection cn = cc.getConnection();
      PreparedStatement pst = null;
      String sql;
      sql = "DELETE* FROM endereco";

    try{
        ResultSet rs = pst.executeQuery();
        pst = cn.prepareStatement(sql);
        pst.setString(1, chave);
        pst.executeUpdate();
        resul ="Endereco apagado";
        
        if(rs.next()){
        uso.setComplemento(rs.getString(1));
        uso.setBairro(rs.getString(2));
        uso.setNumero(rs.getString(3));
        uso.setCep(rs.getString(4));
        uso.setLogradouro(rs.getString(5));
        }
       
    uso.setResultado( "Busca com exito!");
    
    }

    catch(SQLException e){
    resul = "Erro ";
    
    }finally{
        try{
        if(cn != null){
            cn.close();
            pst.close();
        }
        }
    
    catch(Exception e){
       resul = "Erro";     
            }
    return resul;
    
    }
    }

public static ArrayList<Endereco> getListEndereco() throws SQLException, ClassNotFoundException{
    
    ArrayList<Endereco> arrEnd =  new ArrayList<Endereco>();
      ConexaoBD cc = new ConexaoBD(); 
      Connection cn = cc.getConnection();
      PreparedStatement pst = null;
      Endereco uso = null;
      String sql;
      sql = "SELECT* FROM endereco";

    try{
    
        pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
        uso.setComplemento(rs.getString(1));
        uso.setBairro(rs.getString(1));
        uso.setNumero(rs.getString(1));
        uso.setCep(rs.getString(1));
        uso.setLogradouro(rs.getString(1));
        if(arrEnd.isEmpty()){
            arrEnd.add(0, uso);
        }
        
        else{
           arrEnd.add(uso); 
        }
        }
       
    uso.setResultado( "Busca com exito!");
    
    }

    catch(SQLException e){
        System.out.println("Erro na consulta");;
    
    }finally{
        try{
        if(cn != null){
            cn.close();
            pst.close();
        }
        }
    
    catch(Exception e){
        System.out.println("Erro");     
            }
    return arrEnd;
    
    }
    
}

}

