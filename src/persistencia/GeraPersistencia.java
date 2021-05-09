package persistencia;

import java.util.List;

import classes.Aluno;

public class GeraPersistencia {
	protected Persistencia persistencia;
	
	public GeraPersistencia(Persistencia persistencia) {
		this.persistencia = persistencia;
	}
	
	public String GPersistencia(List<Aluno> ListAluno) {
		return persistencia.CriaPersistencia(ListAluno);
	}
}
