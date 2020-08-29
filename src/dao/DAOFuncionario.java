
package dao;

import java.util.List;
import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Venda;

public class DAOFuncionario  extends DAO<Funcionario>{

	public modelo.Funcionario read (Object chave) {
		String cpf = (String) chave;
		
		Query q = manager.query();
		q.constrain(Funcionario.class);
		q.descend("cpf").constrain(cpf);
		List<Funcionario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}


	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE FUNCIONARIOS
	 * 
	 **********************************************************/
	public static  List<Funcionario> consultarFuncionarioPorNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Funcionario.class);
		q.descend("nome").constrain(caracteres).like();
		List<Funcionario> result = q.execute(); 
		return result;
	}

	public List<Funcionario>  consultarFuncionario(int n) {
		Query q = manager.query();
		q.constrain(Funcionario.class);
		List<Funcionario> result = q.execute(); 
		return result;
	}

	
	
	public int consultartotalDeFuncionarios() {
		Query q = manager.query();
		q.constrain(Funcionario.class);
		int total = q.execute().size(); 
		return total;
	}

	public static Cliente consultarClientePorCPF(String n){
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("telefones").descend("numero").constrain(n);
		List<Cliente> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados.get(0);

	}


	public int consultarTotalFuncionarios() {
		Query q = manager.query();
		q.constrain(Funcionario.class);
		int total = q.execute().size(); 
		return total;
	}


	


	

}

