/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;
import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Funcionario;

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

	public void create(modelo.Cliente cl) {
		// TODO Auto-generated method stub
		
	}
}

