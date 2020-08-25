package modelo;

import java.util.ArrayList;

public class Produto{

	
	private String cod;
	private String nome_produto;
	private int quant_estoq;
	private String  descricao;
    private ArrayList<Produto> produtos= new ArrayList<Produto>();

	
	public Produto(
			String cod, 
			String nome_produto, 
			int quant_estoq, 
			String descricao) {
		
       this.cod = cod;
       this.nome_produto = nome_produto;
       this.quant_estoq = quant_estoq;
       this.descricao = descricao;
	
	}


	public Produto(Object nomeProd) {
		// TODO Auto-generated constructor stub
	}


	public String getCod() {
		return cod;
	}

	public void setCod(Produto produto, String cod) {
		this.cod = cod;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public int getQuant_estoq() {
		return quant_estoq;
	}

	public void setQuant_estoq(int quant_estoq) {
		this.quant_estoq = quant_estoq;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void adicionar(Item i) {
		// TODO Auto-generated method stub
		
	}

	
	public void adicionar(Produto p){
		p.setCod(this,cod);
		this.produtos.add(p);

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
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}


	@Override
	public String toString() {
		return "Produto [cod= " + cod + ", nome= " + nome_produto + ", Quantidade= " + quant_estoq
				+ ", descricao= " + descricao + "]";
	}

}
