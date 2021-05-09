package persistencia;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import classes.Aluno;

public class PersistenciaJSON extends Persistencia{
	public String CriaPersistencia(List<Aluno> ListAluno) {		
		Gson gson = new Gson();
		String json = gson.toJson(ListAluno);
		FileWriter writer;
		try {
			writer = new FileWriter("src/arquivosGerados/alunos.json");		
			writer.write(json);
			writer.close();
			return "Criado Com sucesso O JSON";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Erro ao criar o JSON";
		}
	}
	
	
	public List<Aluno> RecuperaPersistencia() {
		List<Aluno >listaAluno = new ArrayList<Aluno>();
		try(Reader reader = new FileReader("src/arquivosGerados/alunos.json")) {		
			Type listType = new TypeToken<ArrayList<Aluno>>(){}.getType();
			listaAluno = new Gson().fromJson(reader, listType);
		} catch (IOException i) {
			i.printStackTrace();
		}
		return listaAluno;
	}
}
