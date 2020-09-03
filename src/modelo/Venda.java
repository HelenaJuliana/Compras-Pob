package modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Venda {
	private String codV;
	private Funcionario cpf;
	private Cliente nome;
	private Date data;
	private double valor;
	private ArrayList<Item> itens= new ArrayList<Item>();
	

	public Venda(
			String codV,
			Funcionario cpf,
			 Cliente nome,
			Date data,
			 double valor
			) {
		super();
		this.codV = codV;
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor= valor; 
		
	}





	










	public String getCodV() {
		return codV;
	}

	public void setCodV(String codV) {
		this.codV = codV;
	}

	
	public Funcionario getFuncionario() {
		return cpf;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.cpf = funcionario;
	}
	
	public Cliente getCliente() {
		return nome;
	}
	
	public void setCliente(Cliente cliente) {
		this.nome = cliente;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

//	public void adicionar(Item it){
//		it.setVenda(this);
//		this.itens.add(it);
//	}

//	public void remover(PedidoItem p){
//		p.setPedido(null);
//		this.itens.remove(p);
//	}
	
	
	@Override
	public String toString() {
		return "Venda [codV=" + codV + ", cpf=" + cpf + ", nome=" + nome + ", data=" + data + ", valor=" + valor
				+ ", itens=" + itens + "]";
	}

	
	


	
}
