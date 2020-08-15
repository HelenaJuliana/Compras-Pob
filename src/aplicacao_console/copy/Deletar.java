package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Cliente;


public class Deletar {

	public Deletar(){
		Fachada.inicializar();
		Cliente cl = null;
		try {
			System.out.println("deletando...");
			Fachada.excluirCliente("123264");
			System.out.println("");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

