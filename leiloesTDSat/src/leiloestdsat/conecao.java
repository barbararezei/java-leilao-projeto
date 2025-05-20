
package leiloestdsat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conecao {
     private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }
    
    public void conectar()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11","root","Gideon69*");
            System.out.println("SUCESSO DE CONEXÃO!");
        }catch (ClassNotFoundException cn) {
            System.out.println("Falha ao conectar com o banco " + cn);
        }catch (SQLException sql) {
            System.out.println("Erro de SQL: " + sql);
        }
    }
    
    public void desconectar(){
        try {
            if(conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("DESCONECTADO!");
            }
        }catch(SQLException se) {
            System.out.println("Problema ao desconectar do banco: " + se);
        }
    }
    
}
