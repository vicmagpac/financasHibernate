package br.com.alura.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
	
	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3);
		
		TypedQuery<BigDecimal> query = manager.createQuery("SELECT MAX(m.valor) FROM Movimentacao m WHERE m.conta=:pConta", BigDecimal.class);
		query.setParameter("pConta", conta);
		
		BigDecimal valor = query.getSingleResult();
		System.out.println(valor);
	}
	
}
