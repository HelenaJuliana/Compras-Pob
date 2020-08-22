package aplicacao_console.copy;



//import com.sun.tools.javac.util.List;

import fachada.Fachada;
//import modelo.Cliente;
//import modelo.Produto;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		
		//Cliente cl;
		//Produto pro;
		
		try {
			System.out.println("alterando...");
			Fachada.AtualizarCliente("880020", "Helena");
			
            //cl = Fachada.AtualizarCliente("Clara", "ruatal","222222","lll","hksahfk@j");
//
       //  	 String nnome = "Joana"; 
//			 String ncpf = "12354";
//			 String nendereco = "ruamaria";
//			 String nemail = "joana@gmail";
//			 String ntelefone = "1458";
//          	
          	
          	
          	
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

