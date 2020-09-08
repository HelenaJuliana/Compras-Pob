package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda {
	private String codV;
	private Funcionario cpf;
	private Cliente nome;
	private LocalDate data;
	private double valor2;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

//	public Venda(
//			String codV,
//			Funcionario cpf,
//			Cliente nome,
//			LocalDate data,
//			double valor2
//			) {
//		super();
//		this.codV = codV;
//		this.cpf = cpf;
//		this.nome = nome;
//		this.data = data;
//		this.valor2 = valor2;
//		 
//		
//	}
//
//	public Venda(
//			String codV2,
//			String cpf2, 
//			String nome2, 
//			LocalDate data, 
//			double valor) {
//		this.codV2 = codV2;
//		this.cpf = cpf;
//		this.nome = nome;
//		this.data = data;
//		this.valor2 = valor2;
//	}

	public Venda(
			String codV, 
			Funcionario cpf, 
			Cliente nome, 
			LocalDate data, 
			double valor2) {
		super();
		this.codV = codV;
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor2 = valor2;
//		this.produtos = produtos;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
		return valor2;
	}

	public void setValor(float valor) {
		this.valor2 = valor;
	}

	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + ":";
		String texto = String.format("%5s", classe) + " Cod = " + String.format("%5s", codV) + " Funcionario = "
				+ String.format("%5s", cpf.getCpf()) + ", Cliente = " + String.format("%5s", nome.getNome()) + ", Data = "
				+ data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", Pre�o = " + String.format("%5s", valor2);

		texto += ", produtos:";
		for (Produto p : produtos)
			texto += p.getCod() + ", ";

		return texto;
	}

}