package main.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("main")
@PropertySource("classpath:app.properties")
@EnableJpaRepositories(basePackages="main.repository",entityManagerFactoryRef="entityManagerFactor")
public class PersistanceConfig {
	private static final String PROP_DATABASE_DRIVER = "db.driver";
	private static final String PROP_DATABASE_PASSWORD = "db.password";
	private static final String PROP_DATABASE_URL = "db.url";
	private static final String PROP_DATABASE_USERNAME = "db.username";
	private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
//	private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show.sql";
	private static final String PROP_ENTITYMANAGER_PACKAGETS_TO_SCAN = "db.entitymanager.packages.to.scan";
//	private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hdbm2ddl.auto";
	
	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactor(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
//		entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGETS_TO_SCAN));
//		entityManagerFactory.setJpaProperties(getHibernateProperties());
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
//	private Properties getHibernateProperties() {
//		Properties prop = new Properties();
//		prop.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
//		prop.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
//		prop.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
//		return prop;
//	}
	
	 @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	        hibernateJpaVendorAdapter.setShowSql(true);
	        hibernateJpaVendorAdapter.setGenerateDdl(true);
	        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
	        return hibernateJpaVendorAdapter;
	    }
}
