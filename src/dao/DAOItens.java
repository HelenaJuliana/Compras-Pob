package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Funcionario;
import modelo.Item;
import modelo.Produto;

public class DAOItens extends DAOProduto {
	
	

public class DAOPedidoItem extends DAO<Item>{
	//numero é campo único 
	public Item read (Object chave) {
		Integer cod_Iten = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(Item.class);
		q.descend("cod_Iten").constrain(cod_Iten);
		List<Item> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DOS ITENS
	 * 
	 **********************************************************/
	public int consultarTotalItens() {
		Query q = manager.query();
		q.constrain(Item.class);
		int total = q.execute().size(); 
		return total;
	}


	public  List<Item> consultarItem(String caracteres) {
		Query q = manager.query();
		q.constrain(Item.class);
		q.descend("nome_produto").constrain(caracteres).like();
		List<Item> result = q.execute(); 
		return result;
	}

	public List<Item> consultarVendas(String n) {
		Query q = manager.query();
		q.constrain(Item.class);
		q.descend("cpf").constrain(n).like();
		List<Item> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados;
	}
	
	public List<Produto> consultaVenda(String n) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome_produto").constrain(n).like();
		List<Produto> result = q.execute(); 
		return result;
	}
}
}


