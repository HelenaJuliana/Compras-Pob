package modelo;


public class Cliente {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
    private String email;
	
	public Cliente(String nome, String cpf, String endereco,String email,String telefone ) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPF() {
		return nome;
	}
	public void setCPF(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
		
//	public void adicionar(telefone t){
//		t.setPessoa(this);
//		this.telefones.add(t);
//	}
//
//	public void remover(telefone t){
//		t.setPessoa(null);
//		this.telefones.remove(t);
//	}

	
}
