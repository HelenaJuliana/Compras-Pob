package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Item;

public class DAOItens extends DAOProduto {
	
	

public class DAOPedidoItem extends DAO<Item>{
	//numero é campo único 
	public Item read (Object chave) {
		Integer codi = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(Item.class);
		q.descend("codPedidoItem").constrain(codi);
		List<Item> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE TELEFONE
	 * 
	 **********************************************************/
	public int consultarTotalItens() {
		Query q = manager.query();
		q.constrain(Item.class);
		int total = q.execute().size(); 
		return total;
	}


}
}


