package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import aplicacao_console.copy.Listar;
import fachada.Fachada;



public class Listar {

	public Listar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.listarCliente());
			System.out.println(Fachada.listarFuncionario());
			System.out.print(Fachada.listarProdutos());
//			System.out.println(Fachada.listarItem());
//			System.out.println(Fachada.listarProduto());
//			System.out.println(Fachada.listarTelefones());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
	

}

