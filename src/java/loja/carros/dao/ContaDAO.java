package loja.carros.dao;

import javax.persistence.Query;
import loja.carros.model.Conta;

public class ContaDAO extends GenericoDAO<Conta> {

    public Conta consultarConta(Conta conta) {
        Query query = em.createNamedQuery("Conta.consultarLogin");
        query.setParameter("email", conta.getEmail());
        query.setParameter("senha", conta.getSenha());

        try {
            conta = (Conta) query.getSingleResult();
        } catch (Exception e) {
            return conta = new Conta();
        } finally {
            em.close();
        }

        return conta;
    }
}
