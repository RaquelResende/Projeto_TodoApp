
package model;

import java.util.Date;


public class Task {

	private int id;
	private int id_projects;
	private String nome;
	private String descricao;
	private Boolean completado;
	private String notas;
	private Date prazo;
	private Date data_criacao;
	private Date data_atualizacao;
	
	public Task(int id,int id_projects,String nome,String descricao,Boolean completado,String notas,Date prazo,Date data_criacao,Date data_atualizacao) {
		this.id = id;
		this.id_projects = id_projects;
        this.nome = nome;
        this.descricao = descricao;
        this.completado = completado;
        this.notas = notas;
        this.prazo = prazo;
        this.data_criacao = data_criacao;
        this.data_atualizacao = data_atualizacao;
    
	     
	}
	public Task(){
        this.data_criacao= new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_projects() {
        return id_projects;
    }

    public void setId_projects(int id_projects) {
        this.id_projects = id_projects;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Date data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", id_projects=" + id_projects + ", nome=" + nome + ", descricao=" + descricao + ", completado=" + completado + ", notas=" + notas + ", prazo=" + prazo + ", data_criacao=" + data_criacao + ", data_atualizacao=" + data_atualizacao + '}';
    }

   

}
