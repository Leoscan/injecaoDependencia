package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.opencsv.CSVWriter;
import classes.Aluno;
import formatador.formatador;


public class PersistenciaCSV extends Persistencia {
	
	public String CriaPersistencia(List<Aluno> ListAluno)  {
		
			try {									
					CSVWriter csvWriter = new CSVWriter(new FileWriter("src/arquivosGerados/alunos.csv"));
					
					String[] titulos = {"Nome" , "Matricula", "CPF", "dataNascimento", "Email"};
					csvWriter.writeNext(titulos);
									
					
					for (Aluno aluno : ListAluno) {						
						String[] valores = {   aluno.getNome(), 
												Integer.toString(aluno.getMatricula()), 
												aluno.getCpf(), 
												aluno.getDataNascimento(), 
												aluno.getEmail()
											}; 
						csvWriter.writeNext(valores);
						
	                 }
					
					
					csvWriter.flush();
					csvWriter.close();
				
		            
		        return "Criado com sucesso o CSV";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Erro ao criar o CSV";
			}
	
		
	}
	
	public List<Aluno> RecuperaPersistencia() {
		try (BufferedReader br = new BufferedReader(new FileReader("src/arquivosGerados/alunos.csv"))) {
			List<Aluno> alunos = new ArrayList<Aluno>();
	        String line = br.readLine();
	        line = br.readLine();
	        while (line != null) {
	            String[] vect = line.split(",");
	            String nome = vect[0];
	            int matricula = Integer.parseInt(formatador.removeimpurezas(vect[1]));
	            String cpf = vect[2];	            
	            String DataNascimento = vect[3];
	            String email = vect[4];
	            
	            Aluno a = new Aluno(nome, matricula, cpf, DataNascimento, email);	            
	            alunos.add(a);
	
	            line = br.readLine();
	        }
	        return alunos;
	    }
	    catch (IOException e) {
	        System.out.println("Error: " + e.getMessage());
	        return null;
	    }	
	}
}

