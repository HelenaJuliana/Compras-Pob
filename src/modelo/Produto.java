package modelo;

public class Produto{

	
	private String cod;
	private String nome_produto;
	private int quant_estoq;
	private String  descricao;
	
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

	public void setCod(Cliente cliente) {
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

	@Override
	public String toString() {
		return "Produto [cod=" + cod + ", nome_produto=" + nome_produto + ", quant_estoq=" + quant_estoq
				+ ", descricao=" + descricao + "]";
	}

}
