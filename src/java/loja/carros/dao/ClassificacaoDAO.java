package loja.carros.dao;

import java.util.List;
import javax.persistence.Query;
import loja.carros.model.Classificacao;

public class ClassificacaoDAO extends GenericoDAO<Classificacao> {
  
    public List<Classificacao> consultarClassificacao(String nome) {
        Query query = em.createNamedQuery("Classificacao.consultarClassificacao");
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
}
