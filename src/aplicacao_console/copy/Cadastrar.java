package aplicacao_console.copy;




import fachada.Fachada;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Cliente cl = null;
			Produto pro;
			Funcionario fun = null;
			Venda v;
			
			
			System.out.println("cadastrando...");
			
			//cl= Fachada.cadastrarCliente(" Barto", "4101001", "ruaendereco", "pl@gmail", "12312231");
			
			//System.out.println(cl);
			
			//dando erro
		v = Fachada.CadastrarVendas("20","17115","Ana","04/09/2020",20.00);
		System.out.println(v);
//			
			
//			pro= Fachada.cadastrarProdutos("202", "Vestido 2 ",20.00, 11, "Preto e branco  etc");
//			System.out.println(pro);
//			
			 //fun= Fachada.cadastrarFuncionario("171145","Maria 2", "mariavendas@gmail.com");
			 //System.out.println(fun);
         	
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("\nfim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


