package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		/*
		Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
		System.out.println(movimentacao.getConta().getTitular());
		
		
		Conta conta = manager.find(Conta.class, 1);
		System.out.println(conta.getMovimentacoes().size());
		*/
		
		Query query = manager.createQuery("SELECT DISTINCT c FROM Conta c JOIN FETCH c.movimentacoes");
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
		}
	}
}
