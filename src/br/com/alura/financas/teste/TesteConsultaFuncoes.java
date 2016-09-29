package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.financas.dao.MovimentacaoDao;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncoes {
	public static void main(String args[]) {
		EntityManager manager = new JPAUtil().getEntityManager();
			
		Conta conta = new Conta();
		conta.setId(3);
	
		String jpql = "SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta=:pConta AND m.tipoMovimentacao=:pTipoMovimentacao";
		
		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		Double resultado = query.getSingleResult();
		System.out.println("\nTotal movimentado ...: " + resultado);
		
		
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);	
		Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA);
		System.out.println("\nTotal media DAO ...: " + media);
	}
}
