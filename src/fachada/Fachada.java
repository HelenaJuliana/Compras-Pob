
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
	private static final String Clientes = null;
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
		//Cliente cl = ((DAOCliente) daocliente).read(cpf);
		if(cl != null) {
			DAO.rollback();
			throw new Exception("cadastrar cliente - cliente ja cadastrado:" + nome);
		}

		Cliente cl1 = new Cliente("nome", "cpf", "endereco","telefone","email");
		//((DAO<Cliente>) daocliente).create(cl1);	
		DAO.commit();
		return cl1;
	}
	
	
//	public static String consultarClienteNTelefones(int n) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public static String consultarClientePorParteNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public static Funcionario cadastrarFuncionario(String nome, String cpf) 
			throws  Exception{
		DAO.begin();	
		Cliente cl = daocliente.read(nome);
		if(cl != null) {
			DAO.rollback();
			throw new Exception("cadastrar funcionario - pessoa ja cadastrado:" + nome);
		}

		
		cl = new Cliente("helena", "123", "rua tal", "helena@gmail.com","4561233");
		daocliente.create(cl);	
		DAO.commit();
		return (Funcionario(cl));
	}


private static Funcionario Funcionario(Cliente cl) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String listarCliente(){
		List<Cliente> pessoas = daocliente.readAll();
		String texto="-----------listagem de Clientes-----------\n";
//		for (Cliente cl : Clientes) {
//			texto += cl +"\n";
//		}
		return texto;
 
	}
	
	public static String listarFuncionario(){
		List<Funcionario> clientes = daofuncionario.readAll();
		String texto="-----------listagem de Funcionarios-----------\n";
		for (Funcionario a : clientes) {
			texto += a +"\n";
		}
		return texto;
	}
	
	/**********************************************************
	 *  ITENS 
	 **********************************************************/
	
	//SELECIONA ITENS
	//Problema com o codigo
	public static Item selecionarItens(
				String nomeItem,
				Integer quantidade) 
						throws  Exception{
		DAO.begin();
		
		
		
		Produto pe = daoproduto.read(codigoProduto);
		System.out.println(pe);
		if(pe == null) {
			DAO.rollback();
			throw new Exception("adicionar Item -  nao cadastrado:");
		}
				
		int codIntem = 0;
		codIntem++;
		Object nomeProd = null;
		Produto pro = new Produto(nomeProd);
		Item i = new Item(codIntem,pe,quantidade,pro);
		pe.adicionar(i);
		daoproduto.update(pe);
		DAO.commit();
		return i;
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
	
	
	
	
	
	
	
		
	}
