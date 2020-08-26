package modelo;

import java.util.ArrayList;

public class Item {
	

	private int cod_Iten;
	private Produto nome_produto;
	private int quant;
	private Produto valor;
	 private ArrayList<Item> itens= new ArrayList<Item>();
	
	public Item ( 
			int cod_Iten ,
			Produto pr, 
			int quant,
			Produto pro) {
		
		this.setCod(cod_Iten);
		this.setNome_produto(pr);
		this.setQuant(quant);
		this.setValor(pro); 
		
		
	}
	
public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	//construtor do modelo venda no novo objeto em itens 
	public Item(int cod2, String string, int quant2, double d) {
		this.setCod(cod_Iten);
		Produto pe = null;
		Produto pro = null;
		this.setNome_produto(pe);
		this.setQuant(quant);
		
		this.setValor(pro); 
	}

	public int getCod() {
		return cod_Iten;
	}

	public void setCod(int cod) {
		this.cod_Iten = cod;
	}

	public Produto getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(Produto pe) {
		this.nome_produto = pe;
	}


	public int getQuant() {
		return quant;
	}


	public void setQuant(int quant) {
		this.quant = quant;
	}


	public Produto getValor() {
		return valor;
	}


	public void setValor(Produto pro) {
		this.valor = pro;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Item [cod=" + cod_Iten + ", nome_produto=" + nome_produto + ", quant=" + quant + ", valor=" + valor + "]";
	}

	public void setCod(Produto produto, String cod) {
		// TODO Auto-generated method stub
		
	}

	



}


