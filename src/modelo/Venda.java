package modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	
	private String nome;
	private String email;
	private ArrayList<Item> itens1;
	private Date data;
	private float valor;
	private String venda;

	Funcionario funcionario = new Funcionario("marcia", "marcia@gmail");
	Cliente cliente = new Cliente("Pedro","123.456.789-78","Rua blabla","pedro@gmail.com","124644");
    Item itens2 = new Item(1 ,"Vestido", 1, 50.0);

	List<Item> itens = new ArrayList<Item>();
	
	public Venda(String venda ,String email) {
		this.setVenda(venda);
		this.setEmail(email);
                setItens1(new ArrayList<Item>());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Item> getItens1() {
		return itens1;
	}

	public void setItens1(ArrayList<Item> itens1) {
		this.itens1 = itens1;
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

	public String getVenda() {
		return venda;
	}

	public void setVenda(String venda) {
		this.venda = venda;
	}

}
