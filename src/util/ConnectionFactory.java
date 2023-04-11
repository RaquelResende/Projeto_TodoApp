package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {


		 public static Connection getConnection(){
		        
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return  DriverManager.getConnection("jdbc:mysql://localhost:3306/db_todoapp","root","root");
					
		}catch(ClassNotFoundException ex) {
			System.out.println("Driver de banco nAo localizado");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex.getMessage());
					
			
			
		}
		return null;
		
	}
		 
		 public static void closeConnection (Connection conexao, PreparedStatement statement) {
			
				 try {
					 if(conexao != null) {
						 conexao.close();
						 
					 }
					 if (statement != null) {
						 statement.close();
					 }
				
						 
					 }catch(Exception ex){
						 throw new RuntimeException("Erro ao conectar com o banco de dados");
				 }
			 
		 }
		 
		 public static void closeConnection (Connection conexao, PreparedStatement statement, ResultSet resultadoBanco) {
				
			 try {
				 if(conexao != null) {
					 conexao.close();
					 
				 }
				 if (statement != null) {
					 statement.close();
				 }
				 if(resultadoBanco != null) {
					 resultadoBanco.close();
				 }
			
					 
				 }catch(Exception ex){
					 throw new RuntimeException("Erro ao conectar com o banco de dados");
			 }
		 
	 }
		 
		 

}
