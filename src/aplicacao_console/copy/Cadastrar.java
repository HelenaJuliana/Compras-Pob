package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
//import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Cliente cl;
			Produto pro;
			Produto pro1;
			Funcionario fun;
			
//			Telefone t;
			System.out.println("cadastrando...");
			//cl=Fachada.cadastrarCliente("Maria Clara", "452689", "ruaendereco", "maria@gmail", "12312231");
			
//			t=Fachada.adicionarTelefonePessoa("joao","88880000");
//			t=Fachada.adicionarTelefonePessoa("joao","88881111");
			//System.out.println(cl);
			
			//cl=Fachada.cadastrarCliente("Joana", "10000", "ruaendereco", "joana@gmail", "12312231");
			//cl=Fachada.cadastrarCliente("Joana1", "11111", "ruaendereco", "joana@gmail", "12312231");
			//System.out.println(cl);
			//System.out.println(cl);
			pro=Fachada.cadastrarProdutos("98", "Tênis 2", 1, "Preto e branco  etc");
			//pro1=Fachada.cadastrarProduto("2", "Vestido", 4, "Vestido Vermelho etc");
			fun = Fachada.cadastrarFuncionario("1234","Laura", "lauravendas@gmail.com");
			System.out.println(pro);
         	//System.out.println(pro1);
         	System.out.print(fun);

	

		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


