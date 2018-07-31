package loja.carros.dao;

import java.util.List;
import javax.persistence.Query;
import loja.carros.model.Carro;

public class CarroDAO extends GenericoDAO<Carro> {

    public List<Carro> consultarOfertas() {
        Query query = em.createNamedQuery("Carro.consultarOfertas");
        return query.getResultList();
    }

    public List<Carro> consultarPorMarca(Long idMarca) {
        Query query = em.createNamedQuery("Carro.consultarPorMarca");
        query.setParameter("idMarca", idMarca);

        return query.getResultList();
    }

    public List<Carro> consultarPorClass(Long idClassificacao) {
        Query query = em.createNamedQuery("Carro.consultarPorClass");
        query.setParameter("idClassificacao", idClassificacao);

        return query.getResultList();
    }

    public List<Carro> consultarPorMarcaEClass(Long idMarca, Long idClassificacao) {
        Query query = em.createNamedQuery("Carro.consultarPorMarcaEClass");
        query.setParameter("idMarca", idMarca);
        query.setParameter("idClassificacao", idClassificacao);

        return query.getResultList();
    }
}
