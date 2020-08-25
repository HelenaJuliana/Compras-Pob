package aplicacao_console.copy;


import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		
		
		try {
			System.out.println("alterando...");
			//Fachada.AtualizarCliente("Helenn J","880020","rua tal 1","helen@gmail.com");
			
			//Fachada.AtualizarFuncionario("Helen jk ","17115","helenjk@gmail.com");
			
			//Fachada.AtualizarProduto("Jaqueta","1234",20,"de coro");      	
         
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		Fachada.finalizar();
		
		System.out.println("fim do programa");
	}

	


	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

