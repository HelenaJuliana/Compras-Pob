package aplicacao_console.copy;


import fachada.Fachada;


public class Deletar {

	public Deletar(){
		Fachada.inicializar();
	
		
		try {
			System.out.println("deletando...");
			Fachada.excluirCliente("8989");
			//Fachada.excluirProduto("280");
			
			//Fachada.excluirFuncionario("175");
			
			System.out.println("");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

