package todoApp;
 import controller.TaskController;
 import java.sql.Connection;
import java.util.Date;

import util.ConnectionFactory;
 import model.Task;
public class main {

	public static void main(String[] args) {
		TaskController taskCo = new TaskController();

        Connection c = ConnectionFactory.getConnection();
        

		
		Task tarefa = new Task();
		tarefa.setNome("TASK TEST");
		tarefa.setDescricao("TESTANDO");
		tarefa.setCompletado(true);
		tarefa.setNotas("hoje é test");
		tarefa.setPrazo(new Date());
		tarefa.setData_criacao(null);
		tarefa.setData_atualizacao(null);
		taskCo.save(tarefa);

	}

}
