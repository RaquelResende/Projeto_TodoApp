package model;

import java.util.Date;

public class Project {
	
	private int id;
	private String nome;
	private String descricao;
	private Date data_criacao;
	private Date data_atualizacao;
	
	public Project(int id, String nome, String descricao, Date data_criacao, Date data_atualizacao) {
	 this.id=id;
	 this.nome = nome;
	 this.descricao = descricao;
	 this.data_criacao = data_criacao;
	 this.data_atualizacao = data_atualizacao;
			 
	}
	public Project() {
		this.data_criacao = new Date();
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setDescricao(String descricao) {
		this.descricao= descricao;
	}
	public String getDescricao() {
		return descricao;
		
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
		
	}
	public Date getData_atualizacao() {
		return data_atualizacao;
	}
	
	@Override
	public String toString() {
		return "Project{" + ",id="+id+ ", nome="+ nome+ ",descricao="+descricao+ ",data_criacao="+data_criacao+",data_atualizacao="+data_atualizacao+")";
	}
	
}
