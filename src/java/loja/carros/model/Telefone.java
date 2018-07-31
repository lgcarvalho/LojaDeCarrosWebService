package loja.carros.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "TELEFONE_SEQ", sequenceName = "TELEFONE_SEQ", allocationSize = 1, initialValue = 1)
public class Telefone implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 6494756763092379405L;
    
    @Id
    @GeneratedValue(generator = "TELEFONE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String tipo;

    public Telefone() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
