
package leiloestdsat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produtosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11","root","Gideon69*");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
     public int salvar(produtos pod){
        int status;
        
        try {
            st = conn.prepareStatement("INSERT INTO produtos VALUES(?,?,?,?)");
           st.setInt(1, pod.getId());
           st.setString(2, pod.getNome());
           st.setInt(3, pod.getValor());
           st.setString(4, pod.getStatus());
            
            
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            return ex.getErrorCode();
        }
        }
     
       public void desconectar() 
        {
            try{
                conn.close();
            }
            catch(SQLException ex)
            {
                
            }
        }
       
          public static List<produtos> listartodo () 
    {
        List<produtos> pro= new ArrayList();
        try
        {
            conecao con = new conecao();
            con.conectar();
            
            String sql ="SELECT id,nome, valor,status FROM  produtos ";
            
            PreparedStatement ps = con.getConexao().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
                    {
                        produtos po = new produtos();
                       po.setId(rs.getInt("id"));
                        po.setNome(rs.getString("nome"));
                        po.setValor(rs.getInt("valor"));
                        po.setStatus(rs.getString("status"));
                        
                        pro.add(po);
                    }
            
        }
        catch(SQLException se)
        {
            System.err.println("Erro ao listar filmes: " + se.getMessage());
        }
        return pro;
    }

}
