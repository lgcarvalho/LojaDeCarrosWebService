package loja.carros.dao;

import java.util.List;
import javax.persistence.Query;
import loja.carros.model.Marca;

public class MarcaDAO extends GenericoDAO<Marca> {
    
    public List<Marca> consultarMarca(String nome) {
        Query query = em.createNamedQuery("Marca.consultarMarca");
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
}
