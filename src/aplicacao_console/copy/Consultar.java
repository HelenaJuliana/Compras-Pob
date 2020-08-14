package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;



public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.consultarClientePorParteNome("Pe") );
			//System.out.print(Fachada.consultartotalDeClientes());
//			System.out.println(Fachada.consultarClientesNPedidos(5) );
     		System.out.println(Fachada.consultarPorProduto1("Calça"));
			System.out.println(Fachada.consultartotalDeProdutos1());
//			System.out.println(Fachada.consultartotalDeItens());
			 
		

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

