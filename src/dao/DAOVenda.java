
package dao;


import java.util.List;

import com.db4o.query.Query;

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
	
	public List<Venda> consultarVendas(String codV){
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("codV").descend("cpf").descend("nome").constrain("1234").like();
		List<Venda> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados;

	}
	


}
