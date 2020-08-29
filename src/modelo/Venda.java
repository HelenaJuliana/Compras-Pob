package modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Venda {
	private String codV;
	private Funcionario funcionario;
	private Cliente cliente;
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
		this.funcionario= fun;
		this.cliente = cl;
		this.data = data;
		this.valor = valor;
		
	}

	public Venda(String codV2, String fun, String cl, String date, double valor2) {
		// TODO Auto-generated constructor stub
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "Venda [funcionario=" + funcionario + ", cliente=" + cliente + ", data=" + data + ", valor=" + valor
				+ ", itens=" + itens + "]";
	}

	


	
}
