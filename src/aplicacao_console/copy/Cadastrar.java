package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Cliente;
//import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Cliente cl;
			
//			Telefone t;
			System.out.println("cadastrando...");
			cl=Fachada.cadastrarCliente("joao", "1232646", "ruaendereco", "joao@gmail", "12312231");
//			t=Fachada.adicionarTelefonePessoa("joao","88880000");
//			t=Fachada.adicionarTelefonePessoa("joao","88881111");	
			System.out.println(cl);
			
			cl=Fachada.cadastrarCliente("Maria", "1232646", "ruaendereco", "maria@gmail", "12312231");
//			t=Fachada.adicionarTelefonePessoa("maria","87882222");
//			t=Fachada.adicionarTelefonePessoa("maria","88883333");
			System.out.println(cl);

			//cl=Fachada.cadastrarCliente("jose", "null", "null", "null", "null");
//			t=Fachada.adicionarTelefonePessoa("jose","87884444");
			//System.out.println(cl);

//			p=Fachada.cadastrarAluno("paulo", 9);
			//System.out.println(cl);

//			p=Fachada.cadastrarProfessor("fausto", 1000.0);
			//System.out.println(cl);

		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}


	public void cadastrar(){
	

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


