package aplicacao_console.copy;

import aplicacao_console.copy.Listar;
import fachada.Fachada;

public class Listar {

	public Listar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.listarCliente());
			System.out.println(Fachada.listarFuncionario());
			System.out.print(Fachada.listarProdutos());
			//System.out.print(Fachada.listarVendas("01"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("\nfim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
	

}

