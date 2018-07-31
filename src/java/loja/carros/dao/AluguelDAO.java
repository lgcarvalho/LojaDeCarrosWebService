package loja.carros.dao;

import java.util.List;
import javax.persistence.Query;
import loja.carros.model.Aluguel;

public class AluguelDAO extends GenericoDAO<Aluguel> {

    public List<Aluguel> consultarPedidosPorId(Long idConta) {
        Query query = em.createNamedQuery("Aluguel.consultarPorConta");
        query.setParameter("idConta", idConta);
        
        return query.getResultList();
    }
}
