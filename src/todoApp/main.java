package todoApp;
 import controller.TaskController;
 import controller.ProjectController;
 import java.sql.Connection;
 import model.Project;
import java.util.Date;

import util.ConnectionFactory;
 import model.Task;
public class main {

	public static void main(String[] args) {
	TaskController taskCo = new TaskController();

        Connection c = ConnectionFactory.getConnection();
        
       /* ProjectController  projectController = new ProjectController();
        
        Project project = new Project();
        project.setNome("Projeto test");
        project.setDescricao("testando");
        projectController.save(project);
		*/
	Task tarefa = new Task();
		tarefa.setId_projects(1);
		tarefa.setNome("TASK TEST");
		tarefa.setDescricao("TESTANDO");
		tarefa.setCompletado(true);
		tarefa.setNotas("hoje é test");
		tarefa.setPrazo(new Date());
		taskCo.save(tarefa);

	}

}
