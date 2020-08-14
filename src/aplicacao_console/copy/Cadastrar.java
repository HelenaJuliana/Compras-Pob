package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Cliente;
import modelo.Produto;
//import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Cliente cl;
			Produto pro;
			Produto pro1;
			
//			Telefone t;
			System.out.println("cadastrando...");
			cl=Fachada.cadastrarCliente("Pedro", "1232646", "ruaendereco", "Pedro@gmail", "12312231");
			
//			t=Fachada.adicionarTelefonePessoa("joao","88880000");
//			t=Fachada.adicionarTelefonePessoa("joao","88881111");
			System.out.println(cl);
			
			cl=Fachada.cadastrarCliente("Maria", "1232646", "ruaendereco", "maria@gmail", "12312231");
			System.out.println(cl);
			pro=Fachada.cadastrarProduto("1", "Calça", 2, "Camiseta Preta etc");
			pro1=Fachada.cadastrarProduto("2", "Vestido", 4, "Vestido Vermelho etc");
			System.out.println(pro);
         	System.out.println(pro1);

	

		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}


//	public void cadastrar(){
//	
//
//	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


