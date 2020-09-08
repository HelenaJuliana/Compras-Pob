package fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.DAO;
import dao.DAOCliente;
import dao.DAOFuncionario;
import dao.DAOItens;
import dao.DAOProduto;
import dao.DAOVenda;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Item;
import modelo.Produto;
import modelo.Venda;

public class Fachada {

	private static DAOCliente daocliente = new DAOCliente();
	private static DAOFuncionario daofuncionario = new DAOFuncionario();
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOVenda daovenda = new DAOVenda();
	private static DAOProduto daoitens = new DAOItens();
	private static Object codigoProduto;

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	/********************
	 * CADASTRAR
	 ********************/

	public static Cliente cadastrarCliente(String nome, String cpf, String endereco, String telefone, String email)
			throws Exception {
		DAO.begin();
		Cliente cl = daocliente.read(cpf);

		if (cl != null) {
			DAO.rollback();
			throw new Exception("cadastrar cliente -\n cliente ja cadastrado:" + nome);
		}
		cl = new Cliente(nome, cpf, endereco, telefone, email);

		daocliente.create(cl);
		DAO.commit();
		return cl;

	}

	public static Produto cadastrarProdutos(String cod, String nome_produto, double preco, int quant_estoq,
			String descricao) throws Exception {
		DAO.begin();
		Produto pro = daoproduto.read(cod);

		if (pro != null) {
			DAO.rollback();
			throw new Exception("cadastrar produto - produto ja cadastrado: " + nome_produto);
		}

		pro = new Produto(cod, nome_produto, preco, quant_estoq, descricao);
		daoproduto.create(pro);
		DAO.commit();
		return pro;
	}

	public static Funcionario cadastrarFuncionario(String cpf, String nome, String email) throws Exception {
		DAO.begin();
		Funcionario fun = daofuncionario.read(cpf);
		if (fun != null) {
			DAO.rollback();
			throw new Exception("cadastrar funcionario - funcionario ja cadastrado:" + nome);
		}

		fun = new Funcionario(cpf, nome, email);
		daofuncionario.create(fun);
		DAO.commit();
		return fun;
	}

	/********************
	 * CONSULTAS
	 ********************/

	public static String consultarClientePorParteNome(String n) {
		List<Cliente> result = daocliente.consultarClientePorParteNome(n);
		String texto = "\nCONSULTAR CLIENTE DE " + n.toUpperCase() + ":";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Cliente t : result)
				texto += "\n" + t;
		return texto;
	}

	public static String consultarFuncionarioNome(String n) {
		List<Funcionario> result = daofuncionario.consultarFuncionarioPorNome(n);
		String texto = "\nCONSULTAR FUNCIONARIO " + n.toUpperCase() + ":";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Funcionario t : result)
				texto += "\n" + t;
		return texto;
	}

	public static String consultartotalDeFuncionarios() {
		int funcionarios = daofuncionario.consultartotalDeFuncionarios();
		return "\nTOTAL DE FUNCIONARIOS: \n " + funcionarios;

	}

	public static String consultartotalDeClientes() {
		int clientes = daocliente.consultarTotalClientes();
		return "\nTOTAL DE CLIENTES: \n " + clientes;

	}

	public static String consultarProdutoPorParteNome(String n) {
		List<Produto> result = daoproduto.consultarProdutoPorParteNome(n);
		String texto = "\nCONSULTAR Produto DE " + n.toUpperCase() + ":";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Produto t : result)
				texto += "\n" + t;
		return texto;
	}

	// consultar item

	public static String consultarItem(String n) {
		List<Produto> result = daoitens.consultarItem(n);
		String texto = "\nCONSULTAR ITENS DE " + n.toUpperCase() + ":";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Produto t : result)
				texto += "\n" + t;
		return texto;
	}

	public static String consultartotalDeProdutos1() {
		int produtos = daoproduto.consultarTotalProdutos();
		return "\n TOTAL DE PRODUTOS:  " + produtos;

	}

	public static String consultarPorProduto1(String n) {
		List<Produto> result = daoproduto.consultarPorProduto(n);
		String texto = "\nCONSULTAR  PRODUTOS  >> " + n.toUpperCase() + "':";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Produto t : result)
				texto += "\n" + t;
		return texto;
	}

	public static String consultarTotalItens() {
		int iten = daoitens.consultarTotalProdutos();
		return "TOTAL DE ITENS: " + iten;
	}

	/********************
	 * SELECIONAR
	 ********************/

	// SELECIONA Produtos

	public static Item selecionarProdutos(String nomeItem, Integer quantidade) throws Exception {
		DAO.begin();

		Produto pro = daoproduto.read(codigoProduto);
		System.out.println(pro);
		if (pro == null) {
			DAO.rollback();
			throw new Exception("adicionar Item -  nao cadastrado:");
		}

		int codIntem = 0;
		codIntem++;
		Object nomeProd = null;
		Produto pro1 = new Produto(nomeProd);
		Item i = new Item(codIntem, pro1, quantidade, pro1);
		pro1.adicionar(i);
		daoproduto.update(pro1);
		DAO.commit();
		return i;
	}

//LISTAR TODOS OS CLIENTES
	public static String listarCliente() {
		List<Cliente> aux = daocliente.readAll();
		String texto = "-----------listagem de Clientes---------\n";
		for (Cliente t : aux) {
			texto += "\n" + t;
		}
		return texto;
	}

	public static String listarFuncionario() {
		List<Funcionario> funcionarios = daofuncionario.readAll();
		String texto = "\n-----------listagem de Funcionarios-----------\n";
		for (Funcionario a : funcionarios) {
			texto += a + "\n";
		}
		return texto;
	}

//LISTAR TODOS OS PRODUTOS
	public static String listarProdutos() {
		List<Produto> produtos = daoproduto.readAll();
		String texto = "-----------listagem de Produtos---------\n";
		for (Produto t : produtos) {
			texto += "\n" + t;
		}
		return texto;
	}

//LISTAR TODOS AS VENDAS
	public static String listarVendas() {
		List<Venda> vendas = daovenda.readAll();
		String texto = "-----------\nlistagem das Vendas---------\n";
		for (Venda t : vendas) {
			texto += "\n" + t;
		}
		return texto;
	}

//EXCLUINDO CLIENTE
	public static void excluirCliente(String cpf) throws Exception {
		DAO.begin();
		Cliente cl = daocliente.read(cpf);

		if (cl == null) {
			DAO.rollback();
			throw new Exception("excluir Cliente - cpf inexistente: " + cpf);
		}

		System.out.println("deletando o cliente: " + cl.getNome());
		daocliente.delete(cl); // cascata
		DAO.commit();
	}

//EXCLUINDO FUNCIONARIOS
	public static void excluirFuncionario(String cpf) throws Exception {
		DAO.begin();
		Funcionario fun = daofuncionario.read(cpf);

		if (fun == null) {
			DAO.rollback();
			throw new Exception("excluir Funcionario - cpf inexistente:" + cpf);
		}

		System.out.println("deletando o funccionario:" + fun.getNome());
		daofuncionario.delete(fun); // cascata
		DAO.commit();
	}

//EXCLUINDO PRODUTO
	public static void excluirProduto(String cod) throws Exception {
		DAO.begin();
		Produto pro = daoproduto.read(cod);

		if (pro == null) {
			DAO.rollback();
			throw new Exception("excluir Produto - c�digo inexistente:" + cod);
		}

		System.out.println("deletando o produto:" + pro.getNome_produto());
		daoproduto.delete(pro); // cascata
		DAO.commit();
	}

// Atualizar Cliente
	public static void AtualizarCliente(String novonome, String cpf, String endereco, String email

	) throws Exception {
		DAO.begin();
		Cliente cl = daocliente.read(cpf);

		if (cl == null) {
			DAO.rollback();
			throw new Exception("Cliente " + cpf + " inexistente ");
		}
		System.out.println("alterando o cliente: " + novonome + "  cod: " + cpf);

		cl.setNome(novonome);
		cl.setCPF(cpf);
		cl.setEndereco(endereco);
		cl.setEmail(email);
		cl = daocliente.update(cl);
		DAO.commit();

	}

// Atualizar Funcion�rio

	public static void AtualizarFuncionario(String novonome, String cpf, String nemail

	) throws Exception {
		DAO.begin();
		Funcionario fun = daofuncionario.read(cpf);

		if (fun == null) {
			DAO.rollback();
			throw new Exception("Funcionario " + cpf + " inexistente ");
		}
		System.out.println("alterando o cliente: " + novonome + "  cod: " + cpf);

		fun.setNome(novonome);
		fun.setCpf(cpf);
		fun.setEmail(nemail);
		fun = daofuncionario.update(fun);
		DAO.commit();

	}

	public static void AtualizarProduto(String nome, String cod, int quant, String descricao

	) throws Exception {
		DAO.begin();
		Produto pro = daoproduto.read(cod);

		if (pro == null) {
			DAO.rollback();
			throw new Exception("Produto " + cod + " inexistente ");
		}
		System.out.println("alterando o produto: " + nome + "  cod: " + cod);

		pro.setNome_produto(nome);
		// pro.setCod(cod);
		pro.setQuant_estoq(quant);
		pro.setDescricao(descricao);

		pro = daoproduto.update(pro);
		DAO.commit();

	}

	public static String consultarVendas(
			String n, 
			String cpf, 
			String nome) {
		List<Produto> result = daoproduto.consultarVendas(n);
		List<Funcionario> result2 = daofuncionario.consultarVendas(cpf);
		List<Cliente> result3 = daocliente.consultarVendas(nome);

	String texto = "\nCONSULTAR VENDAS COM " + n + "\nFuncionario " + cpf + "\nCliente " + nome + " PRODUTOS:";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Produto t : result)
				texto += "\n" + t;
		return texto;
	}

// CADASTRANDO VENDAS
	public static Venda CadastrarVendas(
			String codV, 
			String cpfFuncionario, 
			String nomeFuncionario,
			String emailFuncionario, 
			String nomeCliente, 
			String cpfCliente, 
			String enderecoCliente,
			String telefoneCliente, 
			String emailCliente, 
			String data, 
			double valor) throws Exception {

		DAO.begin();
		Funcionario funcionario = new Funcionario(
				cpfFuncionario, 
				nomeFuncionario, 
				emailFuncionario);

		Cliente cliente = new Cliente(
				nomeCliente, 
				cpfCliente, 
				enderecoCliente, 
				telefoneCliente, 
				emailCliente);

		Venda v = daovenda.read(codV);
		Funcionario fun = daofuncionario.read(cpfFuncionario);
		
		if (fun == null) {
			System.out.print(" Funcionario inexistente \n");
			}
		
		
		///Cliente cl = daocliente.read(cpfCliente);

		if (v != null) {
			DAO.rollback();
			throw new Exception("cadastrar venda - pessoa com codigo ja cadastrado:" + codV);
		}

		// Formatando string para data
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate LocalDate = java.time.LocalDate.parse(data, format);

		v = new Venda(
				codV, 
				funcionario, 
				cliente, 
				LocalDate, 
				valor);
		daovenda.create(v);
		DAO.commit();
		return v;
	}

}