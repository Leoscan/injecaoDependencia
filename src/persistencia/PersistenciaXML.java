package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import classes.Aluno;


public class PersistenciaXML extends Persistencia {
	
	public String CriaPersistencia(List<Aluno> ListAluno) {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(ListAluno);
		FileWriter writerXML;
		try {
			writerXML = new FileWriter("src/arquivosGerados/alunos.xml");		
			writerXML.write(xml);
			writerXML.close();
			return "Criado Com sucesso o XML";
		} catch (IOException e) {			
			e.printStackTrace();
			return "Falha ao Criar o XML";
		}
	}
	
	public List<Aluno> RecuperaPersistencia() {
		List<Aluno> listaAluno = new ArrayList<Aluno>();
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try { 
            doc = builder.build("src/arquivosGerados/alunos.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element config = doc.getRootElement();
        List lista = config.getChildren("classes.Aluno");

        for (Iterator iter = lista.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            Aluno aluno = new Aluno();
            aluno.setNome(element.getChildText("nome"));
            aluno.setMatricula(Integer.parseInt(element.getChildText("matricula")));
            aluno.setCpf(element.getChildText("cpf"));
            aluno.setDataNascimento(element.getChildText("dataNascimento"));
            aluno.setEmail(element.getChildText("email"));
            listaAluno.add(aluno);
        }
        return listaAluno;
	}
	
}


 