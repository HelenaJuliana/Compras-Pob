package aplicacao_console.copy;


import fachada.Fachada;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
		
			
			System.out.println("cadastrando...");
			
			//Fachada.cadastrarCliente(" Barto 2", "40001", "ruaendereco", "pl@gmail", "12312231");
			
			
			
			//Fachada.cadastrarProdutos("2", "Calça 2 ", 11, "Preto e branco  etc");
			
			
			 //Fachada.cadastrarFuncionario("17115","Maria 1", "mariavendas@gmail.com");
			
         	
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


