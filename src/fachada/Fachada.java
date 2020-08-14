
package fachada;

import java.util.List;


import dao.DAO;
import dao.DAOCliente;
import dao.DAOFuncionario;
import dao.DAOItens;
import dao.DAOProduto;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Item;
import modelo.Produto;
import modelo.Venda;

public class Fachada {
	
	private static DAOCliente daocliente = new DAOCliente();  
	private static DAOFuncionario daofuncionario = new DAOFuncionario();  
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOProduto daoitens = new DAOItens();
	private static Object codigoProduto; 
	


	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Cliente cadastrarCliente(
			String nome, 
			String cpf,
			String endereco,
			String telefone, 
			String email) 
					throws  Exception{
		DAO.begin();	
		//Object daocliente = null;
		Cliente cl = daocliente.read(cpf);
		Funcionario fun = daofuncionario.read(nome);
		//Cliente cl = ((DAOCliente) daocliente).read(cpf);
		if(cl != null) {
			DAO.rollback();
			throw new Exception("cadastrar cliente - cliente ja cadastrado:" + nome);
		}

		Cliente cl1 = new Cliente(
					nome, 
					cpf, 
					endereco,
					telefone,
					email);
		return cl1;	
		
	}
	
	
	/**********************************************************
	 *  CONSULTAS 
	 **********************************************************/

public static String consultarClientePorParteNome(String n) {
	List<Cliente> result = daocliente.consultarClientePorParteNome(n);
	String texto = "\nCONSULTAR CLIENTE DE " + n.toUpperCase() + ":";
	if (result.isEmpty())  
		texto += "consulta vazia";
	else 
		for(Cliente t: result)texto += "\n" + t;
	return texto;
}



public static String consultartotalDeClientes() {
	int clientes = daocliente.consultarTotalClientes();
	return "\nTOTAL DE CLIENTES: " + clientes;
	
}

//public static String consultartotalDePedidos() {
//	int pedidos = daopedido.consultarTotalPedidos();
//	return "TOTAL DE PEDIDOS: " + pedidos;
//	
//}

public static String consultartotalDeProdutos1() {
	int produtos = daoproduto.consultarTotalProdutos();
	return "TOTAL DE PRODUTOS: " + produtos;
	
}
public static String consultarPorProduto1(String n) {
	List<Produto> result = daoproduto.consultarPorProduto(n);
	String texto = "\nCONSULTAR  PRODUTOS " + n.toUpperCase() + ":";
	if (result.isEmpty())  
		texto += "consulta vazia";
	else 
		for(Produto t: result)texto += "\n" + t;
	return texto;
}


	public static Funcionario cadastrarFuncionario(String nome, String cpf) 
			throws  Exception{
		DAO.begin();	
		Funcionario fun = daofuncionario.read(nome);
		if(fun != null) {
			DAO.rollback();
			throw new Exception("cadastrar funcionario - pessoa ja cadastrado:" + nome);
		}

		
		fun = new Funcionario(nome,"email");
		daofuncionario.create(fun);	
		DAO.commit();
		return fun;
	}


	
	/**********************************************************
	 *  SELECIONAR
	 **********************************************************/
	
	//SELECIONA Produtos

	public static Item selecionarProdutos(
				String nomeItem,
				Integer quantidade) 
						throws  Exception{
		DAO.begin();
				
		Produto pro = daoproduto.read(codigoProduto);
		System.out.println(pro);
		if(pro == null) {
			DAO.rollback();
			throw new Exception("adicionar Item -  nao cadastrado:");
		}
				
		int codIntem = 0;
		codIntem++;
		Object nomeProd = null;
		Produto pro1 = new Produto(nomeProd);
		Item i = new Item(codIntem,pro1,quantidade,pro1);
		pro1.adicionar(i);
		daoproduto.update(pro1);
		DAO.commit();
		return i;
	}
	
	//LISTAR TODOS OS clientes
			public static String listarCliente() { 	
				List<Cliente> aux = daocliente.readAll();
				String texto="-----------listagem de Clientes---------\n";
				for(Cliente t: aux) {
					texto += "\n" + t; 
				}
				return texto;
			}
			
			
			public static String listarFuncionario(){
				List<Funcionario> funcionarios = daofuncionario.readAll();
				String texto="-----------listagem de Funcionarios-----------\n";
				for (Funcionario a : funcionarios) {
					texto += a +"\n";
				}
				return texto;
			}
		

	
	//LISTAR TODOS OS ITENS
	public static String listarItem() {
		List<Produto> aux = daoitens.readAll();
		String texto="-----------listagem de Pedidos---------\n";
		for(Produto t: aux) {
			texto += "\n" + t; 
		}
		return texto;
	}
	
	// LISTAR Produtos
		public static String listarProduto() {
			List<Produto> aux = daoproduto.readAll();
			String texto="-----------listagem de Produtos---------\n";
			for(Produto t: aux) {
				texto += "\n" + t; 
			}
			return texto;
			
		}
	
	public static void excluirCliente(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	
			
	public static Cliente AtualizarCliente(
			String nnome, 
			String ncpf, 
			String nendereco, 
			String ntelefone,
			String nemail

)
			throws  Exception{
		DAO.begin();	
		
		Cliente cl1 = new Cliente(
					nnome, 
					ncpf, 
					nendereco,
					ntelefone,
					nemail);
		//((DAO<Cliente>) daocliente).create(cl1);	
		
		return cl1;

		
		
		
		
//		///atualizar
//cod_Iten++;
//Produto pr1 = new Produto(nome_produto);
//Item i = new Item(cod_Iten,pr1,quant,pr1);
//pr1.adicionar(i);
//daoproduto.update(pr1);
//DAO.commit();
//return i;
//}
		
		
	}
	
	
	
		
		////////////////////update teste
		
	
//	public static Cliente AtualizarCliente(
//				
//			
//			String nnome, 
//			String ncpf,
//			String nendereco,
//			String ntelefone, 
//			String nemail) 
//					throws  Exception{
//		DAO.begin();	
//		//Object daocliente = null;
//		Cliente cl = daocliente.read(ncpf);
//		Funcionario fun = daofuncionario.read(nnome);
//		//Cliente cl = ((DAOCliente) daocliente).read(cpf);
//		if(cl != null) {
//			DAO.rollback();
//			throw new Exception("cadastrar cliente - cliente ja cadastrado:" + nome);
//		}
//	
//		Cliente cl1 = new Cliente(
//					nnome, 
//					ncpf, 
//					nendereco,
//					ntelefone,
//					nemail);
//		//((DAO<Cliente>) daocliente).create(cl1);	
//		
//		return cl1;
//		
//		
//	}


	//private static Funcionario Funcionario(Cliente cl) {
//			// TODO Auto-generated method stub
//			return null;
//		}
		
		
		//* PEDIDO ITENS 
		 //**********************************************************/
		
		//SELECIONA ITENS
		//Problema com o codigo
//		public static Item selecionarProdutos(
//					Integer cod, 
//					String nome_produto,
//					Integer quant_estoq,
//					String  descricao, 
//					int cod_Iten, 
//					int quant
//				
//				) throws  Exception{
//			DAO.begin();
			
			///////atualizar  
//			public void atualizarCliente(
//					String _nome, 
//					String cpf, 
//					String endereco,
//					String email,
//					String telefone)
//			Object q;
//			List<Cliente> resultados = null;
//			if(resultados.size() > 0) {	
//				Cliente cl = resultados.get(0);
//				cl.setNome("Laura");
//				DAO.rollback();
//				throw new Exception("teste");
//			};
//			
//			Produto pr = daoproduto.read(cod);
//			System.out.println(pr);
//			if(pr == null) {
//				DAO.rollback();
//				throw new Exception("adicionar Produto- Produto nao cadastrado:");
//			}
//					///atualizar
//			cod_Iten++;
//			Produto pr1 = new Produto(nome_produto);
//			Item i = new Item(cod_Iten,pr1,quant,pr1);
//			pr1.adicionar(i);
//			daoproduto.update(pr1);
//			DAO.commit();
//			return i;
//		}
	//	



}


	
	
	
	
	
		
	
