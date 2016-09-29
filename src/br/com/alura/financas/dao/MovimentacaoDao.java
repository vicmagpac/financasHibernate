package br.com.alura.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	private EntityManager manager;
	
	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {
		TypedQuery<Double> query = this.manager.createQuery(
				"SELECT AVG(m.valor) FROM Movimentacao m "
				+"WHERE m.conta=:pConta AND m.tipoMovimentacao=:pTipoMovimentacao",
				Double.class
		);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipoMovimentacao", tipo);
		
		return query.getSingleResult();		
	}
}
