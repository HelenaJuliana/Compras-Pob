package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */


import fachada.Fachada;
import modelo.Cliente;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		Cliente Cl;
		try {
			System.out.println("alterando...");
			Cl = Fachada.cadastrarCliente("joao", "ruatal","222222","lll","hksahfk");
		
//			Fachada.excluirTelefonePessoa("joana", "88881111");
//			Fachada.alterarTelefone("88880000", "88889999");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//erros
		System.out.println("\ntestando erros...");
//		try {
//			Fachada.excluirTelefoneCliente("ana", "88883333"); 
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());}
//		try {
//			Fachada.alterarTelefone("88889999", "88883333"); 
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());}
//
		Fachada.finalizar();
		
		System.out.println("fim do programa");
	}

	


	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

