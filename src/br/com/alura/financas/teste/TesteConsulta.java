package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsulta {
	public static void main(String args[]) {
		EntityManager manager = new JPAUtil().getEntityManager();
			
		Conta conta = new Conta();
		conta.setId(2);
	
		Query query = manager.createQuery(
				"SELECT m FROM Movimentacao m WHERE m.conta = :pConta AND m.tipoMovimentacao = :pTipoMovimentacao" + 
				" ORDER BY m.valor DESC"
		);
		query.setParameter("pConta", conta);
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		
		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao m : movimentacoes) {
			System.out.println("\n\nDescrição ..: " + m.getDescricao());
			System.out.println("Valor ......: " + m.getValor());
		}
	}
}
