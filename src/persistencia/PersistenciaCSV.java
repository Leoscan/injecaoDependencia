package persistencia;

import java.util.List;

import classes.Aluno;

public class PersistenciaCSV extends Persistencia {
	public String CriaPersistencia(List<Aluno> ListAluno) {
		return "Criado Com sucesso o CSV";
	}
}
