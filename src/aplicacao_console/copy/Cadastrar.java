package aplicacao_console.copy;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Cliente;
//import modelo.Funcionario;
//import modelo.Produto;
//import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Cliente cl;
			//Produto pro;
			//Funcionario fun;
			
			System.out.println("cadastrando...");
			
			cl=Fachada.cadastrarCliente("Juliana", "1110", "ruaendereco", "juliana@gmail", "12312231");
			System.out.println(cl);
			
			//cl=Fachada.cadastrarCliente("Joana", "1", "ruaendereco", "joana@gmail", "12312231");
			//cl=Fachada.cadastrarCliente("Joana1", "11111", "ruaendereco", "joana@gmail", "12312231");
			
			//System.out.println(cl);
			//pro=Fachada.cadastrarProdutos("1234", "Vestido 7", 100, "Preto e branco  etc");
			//pro1=Fachada.cadastrarProduto("2", "Vestido", 4, "Vestido Vermelho etc");
			//fun = Fachada.cadastrarFuncionario("175","Luana 5", "luanavendas@gmail.com");
			//System.out.println(pro);
         	//System.out.println(pro1);
         	//System.out.print(fun);

			
//			t=Fachada.adicionarTelefonePessoa("joao","88880000");
//			t=Fachada.adicionarTelefonePessoa("joao","88881111");
			//System.out.println(cl);

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


