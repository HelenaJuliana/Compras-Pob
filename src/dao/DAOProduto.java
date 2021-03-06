
package dao;


import java.util.Date;
import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Item;
import modelo.Produto;
import modelo.Venda;

public class DAOProduto  extends DAO<Produto>{
	//cod � campo �nico 
	public Produto read (Object chave) {
		String cod = (String) chave;
		
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("cod").constrain(cod);
		List<Produto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	public int consultarTotalProdutos() {
		Query q = manager.query();
		q.constrain(Produto.class);
		int total = q.execute().size(); 
		return total;
	}

	public  List<Produto> consultarProdutoPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome_produto").constrain(caracteres).like();
		List<Produto> result = q.execute(); 
		return result;
	}
	public List<Produto> consultarPorProduto(String n){
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("produto").descend("produto").descend("nomeProduto").constrain(n).like();
		List<Produto> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados;

	}


	public List<Produto> consultarItem(String n) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome_produto").constrain(n).like();
		List<Produto> result = q.execute(); 
		return result;
	}


	

	public List<Produto> consultarVendas(String n) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome_produto").constrain(n).like();
		List<Produto> result = q.execute(); 
		return result;
	}


	
}
