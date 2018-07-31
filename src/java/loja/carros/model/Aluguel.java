package loja.carros.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "ALUGUEL_SEQ", sequenceName = "ALUGUEL_SEQ", allocationSize = 1, initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "Aluguel.consultarPorConta", query = "SELECT a FROM Aluguel a WHERE a.conta.id = :idConta")
})
public class Aluguel implements EntidadeBase, Serializable {
    
    private static final long serialVersionUID = 5754285995423521417L;
    
    @Id
    @GeneratedValue(generator = "ALUGUEL_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private int dias;
    @Column(nullable = false)
    private String status;
    @OneToOne
    private Conta conta;
    @OneToOne
    private Loja loja;
    @OneToOne
    private Carro carro;

    public Aluguel() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
     
}
