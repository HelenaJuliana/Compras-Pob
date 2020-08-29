package modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Venda {
	private String codV;
	private Funcionario cpf;
	private Cliente nome;
	private Date data;
	private float valor;
	private ArrayList<Item> itens= new ArrayList<Item>();
	

	public Venda(
			String codV,
			Funcionario fun,
			Cliente cl,
			Date data,
			float valor
			) {
		super();
		this.setCodV(codV);
		this.setFuncionario(fun);
		this.setCliente(cl);
		this.setData(data);
		this.setValor(valor); 
		
	}

	public String getCodV() {
		return codV;
	}

	public void setCodV(String codV) {
		this.codV = codV;
	}

	public Venda(String codV2, String fun, String cl, String date, double valor2) {
		// TODO Auto-generated constructor stub
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
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Venda [codV=" + codV + ", cpf=" + cpf + ", nome=" + nome + ", data=" + data + ", valor=" + valor
				+ ", itens=" + itens + "]";
	}

	
	


	
}
