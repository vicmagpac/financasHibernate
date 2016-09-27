package br.com.alura.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	 private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas2");
	 
	 public EntityManager getEntityManager() {
		 return this.entityManagerFactory.createEntityManager();
	 }
}
