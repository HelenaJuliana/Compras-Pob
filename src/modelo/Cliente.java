package modelo;

import java.util.ArrayList;

import modelo.Produto;



public class Cliente {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
    private String email;
    private ArrayList<Produto> produtos= new ArrayList<Produto>();
    private ArrayList<Item> itens= new ArrayList<Item>();
	
	public Cliente(
			String nome, 
			String cpf, 
			String endereco, 
			String email, 
			String telefone ) {
		super();
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
	public void setCPF(String cpf) {
		this.cpf = cpf;
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
	
	////////////////////////////////////////////////////////
	
	public void adicionar(Produto p){
		p.setCod(this);
		this.produtos.add(p);
//		this.pedidos.add(p);
	}

	public void remover(Produto p){
		p.setNome_produto(null);
		this.produtos.remove(p);
	}
	
	
	public Produto localizar(Integer num){
		for(Produto p : produtos) {
			if (p.getNome_produto().equals(num))
				return p;
		}
		return null;
	}
	
	public ArrayList<Produto> getPedidos() {
		return produtos;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", email=" + email + "]";
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
