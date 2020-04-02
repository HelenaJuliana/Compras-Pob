package modelo;




public class Item {
	
	private int cod;
	private String nome_produto;
	private int quant;
	private double valor;
	
	
	public Item ( int cod ,String nome, int quant,double valor) {
		this.setCod(cod);
		this.setNome_produto(nome);
		this.setQuant(quant);
		this.setValor(valor); 
		
		
	}

	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getNome_produto() {
		return nome_produto;
	}


	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}


	public int getQuant() {
		return quant;
	}


	public void setQuant(int quant) {
		this.quant = quant;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	

}


