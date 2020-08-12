/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.nio.file.Files;
import java.util.List;


import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;


import modelo.Cliente;
import modelo.Funcionario;

public class DAOCliente  extends DAO<Cliente>{

	private List<Cliente> resultados;


	//nome é campo unico 
	public Cliente read (Object chave) {
		String cpf = (String) chave;	//casting para o tipo da chave
		
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("cpf").constrain(cpf);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return  resultados.get(0);
		else
			return null;
	}


	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE CLIENTE
	 * 
	 **********************************************************/
	public static  List<Cliente> consultarClientePorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("nome").constrain(caracteres).like();
		List<Cliente> result = q.execute(); 
		return result;
	}

	public List<Cliente>  consultarCliente(int n) {
		Query q = manager.query();
		q.constrain(Cliente.class);
//		q.constrain(new Files());
		List<Cliente> result = q.execute(); 
		return result;
	}

	public int consultarTotalFuncionario() {
		Query q = manager.query();
		q.constrain(Funcionario.class);
		int total = q.execute().size(); 
		return total;
	}

	public static Cliente consultarClientePorNumero(String n){
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("telefones").descend("numero").constrain(n);
		List<Cliente> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados.get(0);

	}



	
}


///*-------------------------------------------------*/
@SuppressWarnings("serial")
class Filtro  implements Evaluation {
	private int n;
	public Filtro (int n) {this.n=n;}
	public void evaluate(Candidate candidate) {
		Cliente cl = (Cliente) candidate.getObject();
		//candidate.include( cl.getCpf.().size()==n);
	}
//	public Filtro(int n2) {
//		// TODO Auto-generated constructor stub
//	}
//	public void evaluate(Candidate candidate) {
//		Cliente cl = (Cliente) candidate.getObject();
//		candidate.include( cl.getTelefones().size()==n);
//	}
//	private boolean compara(Cliente cl, int n) {
//		return cl.getTelefones().size()==n;
	}


