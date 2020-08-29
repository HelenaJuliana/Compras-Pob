
package dao;


import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Item;
import modelo.Produto;
import modelo.Venda;

public class DAOVenda  extends DAO<Venda>{
	//cod é campo único 
	public Venda read (Object chave) {
		String codV= (String) chave;
		
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("codV").constrain(codV);
		List<Venda> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Venda> consultarVendas(String n){
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("venda").descend("venda").descend("nome").constrain(n).like();
		List<Venda> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados;

	}


	public void create(Venda v) {
		// TODO Auto-generated method stub
		
	}

	

	

}
