package classes;

public class Aluno extends Pessoa {
	private int matricula;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	
	
	public Aluno(String nome, int matricula, String cpf, String dataNascimento, String email) {
		super(nome);
		setMatricula(matricula);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEmail(email);
	}
	public Aluno() {
		
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\nMatricula: ");
		builder.append(matricula);
		builder.append("\nCpf: ");
		builder.append(cpf);
		builder.append("\nData de Nascimento: ");
		builder.append(dataNascimento);
		builder.append("\nEmail: ");
		builder.append(email);
		builder.append("\n------------");
		return builder.toString();
	}
	
	
	
}
