package main;

import java.util.ArrayList;
import java.util.List;

import classes.Aluno;
import persistencia.*;

public class Main {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno n1 = new Aluno("Leonardo", 12786, "111.222.333-12", "30-11-1999", "leofelix@mail.com");
		alunos.add(n1);
		Aluno n2 = new Aluno("José", 12787, "777.123.546-12", "15-01-1987", "jose@mail.com");
		alunos.add(n2);
		Aluno n3 = new Aluno("Fernando", 12788, "999.122.999-12", "12-08-1950", "fernando@mail.com");
		alunos.add(n3);
		
		
		System.out.println("##############################################################################");
		Persistencia PAluno = new PersistenciaXML();
		GeraPersistencia P1 = new GeraPersistencia(PAluno);		
		System.out.println(P1.GPersistencia(alunos));
		System.out.println(P1.RPersistencia());
		
		System.out.println("##############################################################################");
		PAluno = new PersistenciaJSON();
		P1 = new GeraPersistencia(PAluno);		
		System.out.println(P1.GPersistencia(alunos));
		System.out.println(P1.RPersistencia());
		
		System.out.println("##############################################################################");
		PAluno = new PersistenciaCSV();
		P1 = new GeraPersistencia(PAluno);		
		System.out.println(P1.GPersistencia(alunos));
		System.out.println(P1.RPersistencia());
		
		

	}

}
