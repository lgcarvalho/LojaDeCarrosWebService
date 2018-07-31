package loja.carros.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "ENDERECO_SEQ", allocationSize = 1, initialValue = 1)
public class Endereco implements EntidadeBase, Serializable {

    private static final long serialVersionUID = -6250535647847254115L;
    
    @Id
    @GeneratedValue(generator = "ENDERECO_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;

    public Endereco() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
