package aplicacao_console.copy;



import fachada.Fachada;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Cliente cl;
			Produto pro;
			Funcionario fun;
			
			System.out.println("cadastrando...");
			
			//cl= Fachada.cadastrarCliente(" Barto", "4101001", "ruaendereco", "pl@gmail", "12312231");
			
			//System.out.println(cl);
			
//			pro= Fachada.cadastrarProdutos("22", "Vestido 2 ", 11, "Preto e branco  etc");
//			System.out.println(pro);
			
			 fun= Fachada.cadastrarFuncionario("171115","Maria 1", "mariavendas@gmail.com");
			 System.out.println(fun);
         	
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


