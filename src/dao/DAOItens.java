package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Item;

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


	public void create(Item obj) {
		// TODO Auto-generated method stub
		
	}


}
}


