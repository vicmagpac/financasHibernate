
package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String args[]) {
		
		
		Conta conta = new Conta();
		conta.setTitular("Victor Magalhães");
		conta.setBanco("Bradesco");
		conta.setAgencia("123456");
		conta.setNumero("654");
				

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de LUZ");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123"));
		movimentacao.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(movimentacao);
	
		manager.getTransaction().commit();
		manager.close();
	}
}
