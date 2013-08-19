package hibernate;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;*/

public class Conexao {
	
/*	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			sessionFactory = getSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			sessionFactory.openSession();
			return sessionFactory;
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	*/
}


