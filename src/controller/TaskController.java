package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Task;
import util.ConnectionFactory;

public class TaskController {


		
	public void save(Task task) {
		
		String sql = "INSERT INTO tasks (id_projects, nome, descricao,"
                + "completado, notas,prazo,data_criacao"
                + " ) VALUES (?,?,?,?,?,?,?) ";
			
		Connection conexao = null;  
		PreparedStatement statement = null;
		
		try {
			conexao = ConnectionFactory.getConnection();
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, task.getId_projects());
			statement.setString(2, task.getNome());
			statement.setString(3, task.getDescricao());
			statement.setBoolean(4, task.isCompletado());
			statement.setString(5, task.getNotas());
			statement.setDate(6, new Date(task.getPrazo().getTime()));
			statement.setDate(7, new Date(task.getData_criacao().getTime()));
			
			statement.execute();
			
		}catch(SQLException ex) {
			throw new RuntimeException("Erro ao salvar a tarefa", ex);
			 
			
		}finally {
			ConnectionFactory.closeConnection(conexao, statement);
		        }
	}
		
	public void update(Task task) {
		
		String sql =" UPDATE tasks SET id_projects = ?,"
				+ "nome = ?,"
				+ "descricao = ?,"
				+ "notas = ?,"
				+ "prazo = ?,"
				+ "completado = ?,"
				+ "data_criacao = ?,"
				+ "data_atualizacao = ?,"
				+ "WHERE id = ? ";
		
		Connection conexao = null;
		PreparedStatement statement =null;
		
		try {
			conexao = ConnectionFactory.getConnection();
			statement = conexao.prepareStatement(sql);
			
			statement.setInt(1, task.getId_projects());
			statement.setString(2, task.getNome());
			statement.setString(3, task.getDescricao());
            statement.setString(4, task.getNotas());
            statement.setDate(5, new Date(task.getPrazo().getTime()));
            statement.setBoolean(6, task.isCompletado());
            statement.setDate(7, new Date(task.getData_criacao().getTime()));
            statement.setDate(8,new Date(task.getData_atualizacao().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
			
		}catch(Exception ex) {
			throw new RuntimeException("Erro ao atualizar a tarefa");
			
		}finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}
		
		
		
			
		}
	public void removeById(int TaskId) {
			String sql = "DELETE FROM tasks WHERE id = ?";
			
			
			Connection conexao = null;
			PreparedStatement statement = null;
			 
			try {
				conexao = ConnectionFactory.getConnection();
				statement = conexao.prepareStatement(sql);
				statement.setInt(1, TaskId);
				statement.execute();
				
				
			}catch(Exception ex) {
				throw new RuntimeException("Erro ao deletar a tarefa");
				
				
			}finally {
				ConnectionFactory.closeConnection(conexao, statement);
			}
			
			
		}
		public List<Task> getAll(int id_projects){
			
			String sql =" SELECT * FROM tasks WHERE id_projects =?";
			
			Connection conexao = null;
			PreparedStatement statement = null;
			ResultSet resultadoBanco = null;
			
			
			List<Task> tarefas = new ArrayList<Task>(); 
			
			
			try {
			
				conexao = ConnectionFactory.getConnection();
				statement = conexao.prepareStatement(sql);
				
				//setando um valor que corresponde ao filtro de busca
				statement.setInt(1, id_projects);
            // resposta que o banco nos dar
				resultadoBanco = statement.executeQuery();
						
						while(resultadoBanco.next()) {
							//um novo objeto tarefa para por dentro o que 
							//capitei lá no banco de dados 
							Task tarefa = new Task();
							tarefa.setId(resultadoBanco.getInt("id"));
							tarefa.setId_projects(resultadoBanco.getInt("id_projects"));
							tarefa.setNome(resultadoBanco.getString("nome"));
							tarefa.setDescricao(resultadoBanco.getString("descricao"));
							tarefa.setCompletado(resultadoBanco.getBoolean("completado"));
							tarefa.setNotas(resultadoBanco.getString("notas"));
							tarefa.setPrazo(resultadoBanco.getDate("prazo"));
							tarefa.setData_criacao(resultadoBanco.getDate("data_criacao"));
			                tarefa.setData_atualizacao(resultadoBanco.getDate("data_atualizacao"));	
			                
			                //pegando a lista q populei e colocando no lista primária "tarefas"
						    tarefas.add(tarefa);
						}
				
		           	}catch(Exception ex) {
	           		throw new RuntimeException("Erro ao inserir a tarefa na lista");
				
			}finally {
				ConnectionFactory.closeConnection(conexao, statement, resultadoBanco);
			}
			
			//lista de tarefas que foi criada e carregada do no banco de dados
			return tarefas;
		}
		
	}


