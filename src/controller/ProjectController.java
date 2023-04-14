package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.Project;
import util.ConnectionFactory;

public class ProjectController  {
		
	
	public void save(Project project) {
			
		String sql = "INSERT INTO projects (nome, descricao, data_criacao) VALUES "
				+ "(?,?,?)";
		
		Connection conexao = null ;
		PreparedStatement statement = null;
		
		try {
			
			conexao = ConnectionFactory.getConnection();
			statement= conexao.prepareStatement(sql);
			statement.setString(1,project.getNome());
			statement.setString(2,project.getDescricao());
			statement.setDate(3,new Date(project.getData_criacao().getTime()));
			statement.execute();
		}catch(Exception ex) {
			throw new RuntimeException("Erro ao salvar o project");
		}finally {
			ConnectionFactory.closeConnection(conexao, statement);
			
		}
			
		}
		

}
