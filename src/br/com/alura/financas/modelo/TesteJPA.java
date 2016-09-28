
package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPA {
	public static void main(String args[]) {
		
		/*
		Conta conta = new Conta();
		conta.setTitular("Victor Magalhães");
		conta.setBanco("Bradesco");
		conta.setAgencia("123456");
		conta.setNumero("654");
		*/
		
		EntityManager manager = new JPAUtil().getEntityManager();		
		manager.getTransaction().begin();
	
		
		Conta conta = manager.find(Conta.class, 7);
		conta.setTitular("Victor Mag");
			
		manager.getTransaction().commit();
		manager.close();
	}
}
