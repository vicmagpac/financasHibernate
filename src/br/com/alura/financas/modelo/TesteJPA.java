
package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPA {
	public static void main(String args[]) {
				
		/*
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas2");
		EntityManager manager = entityManagerFactory.createEntityManager();
		*/
		EntityManager manager = new JPAUtil().getEntityManager();		
		
		Conta conta = new Conta();
		conta.setTitular("Victor Magalhães");
		conta.setBanco("Bradesco");
		conta.setAgencia("123456");
		conta.setNumero("654");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		
		manager.close();
	}
}
