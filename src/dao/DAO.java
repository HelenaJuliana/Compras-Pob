
package dao;

//import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;

//import javax.management.Query;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.ClientServerConfiguration;
import com.db4o.config.CommonConfigurationProvider;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Item;
import modelo.Produto;
import modelo.Venda;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;

	public static void open() {
		if (manager == null) {
			abrirBancoLocal();
			// abrirBancoServidor();
		}
	}

	public static void abrirBancoLocal() {
		// Backup.criar("banco.db4o"); //criar uma copia do banco
		 //new File("banco.db4o").delete(); //apagar o banco
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0); // 0,1,2,3...

		config.common().objectClass(Cliente.class).cascadeOnUpdate(true);
		config.common().objectClass(Cliente.class).cascadeOnDelete(true);
		config.common().objectClass(Cliente.class).cascadeOnActivate(true);
		config.common().objectClass(Funcionario.class).cascadeOnUpdate(true);
		config.common().objectClass(Funcionario.class).cascadeOnDelete(true);
		config.common().objectClass(Funcionario.class).cascadeOnActivate(true);
		config.common().objectClass(Item.class).cascadeOnUpdate(true);
//		config.common().objectClass(Telefone.class).cascadeOnDelete(true);
		config.common().objectClass(Item.class).cascadeOnActivate(true);
		config.common().objectClass(Venda.class).cascadeOnActivate(true);
	

		// indices
		config.common().objectClass(modelo.Cliente.class).objectField("nome").indexed(true);
		config.common().objectClass(Item.class).objectField("itens").indexed(true);
		config.common().objectClass(Produto.class).objectField("Produtos").indexed(true);
		config.common().objectClass(Venda.class).objectField("Vendas").indexed(true);

		manager = Db4oEmbedded.openFile(config, "banco.db4o");
	}

	public static void abrirBancoServidor() {
		ClientServerConfiguration config = (ClientServerConfiguration) Db4oClientServer.newClientConfiguration();
		((CommonConfigurationProvider) config).common().messageLevel(0); // 0,1,2,3,4

		((CommonConfigurationProvider) config).common().objectClass(Cliente.class).cascadeOnUpdate(true);
		((CommonConfigurationProvider) config).common().objectClass(Cliente.class).cascadeOnDelete(true);
		((CommonConfigurationProvider) config).common().objectClass(Cliente.class).cascadeOnActivate(true);
		((CommonConfigurationProvider) config).common().objectClass(Funcionario.class).cascadeOnUpdate(true);
		((CommonConfigurationProvider) config).common().objectClass(Funcionario.class).cascadeOnDelete(true);
		((CommonConfigurationProvider) config).common().objectClass(Funcionario.class).cascadeOnActivate(true);
		((CommonConfigurationProvider) config).common().objectClass(Item.class).cascadeOnUpdate(true);
		// config.common().objectClass(Telefone.class).cascadeOnDelete(true);
		((CommonConfigurationProvider) config).common().objectClass(Item.class).cascadeOnActivate(true);

		// indices
		((CommonConfigurationProvider) config).common().objectClass(Cliente.class).objectField("nome").indexed(true);
		((CommonConfigurationProvider) config).common().objectClass(Item.class).objectField("Itens").indexed(true);

		manager = Db4oClientServer.openClient((ClientConfiguration) config, "10.0.51.119", 34000, "usuario1", "senha1");
		// manager =
		// Db4oClientServer.openClient(config,"localhost",34000,"usuario1","senha1");
	}

	public static void close() {
		if (manager != null) {
			manager.close();
			manager = null;
		}
	}

	// ----------CRUD-----------------------

	
	
	public void create(T obj){
		manager.store( obj );
	}
	
	public T update(T obj) {
		manager.store(obj);
		return obj;
	}

	public void delete(T obj) {
		manager.delete(obj);
	}

	public void refresh(T obj) {
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll() {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		com.db4o.query.Query q = manager.query();
		q.constrain(type);
		return (List<T>) q.execute();
	}

	// --------transação---------------
	public static void begin() {
	} // tem que ser vazio

	public static void commit() {
		manager.commit();
	}

	public static void rollback() {
		manager.rollback();
	}

}
