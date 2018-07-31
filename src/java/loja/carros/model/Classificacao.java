package loja.carros.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "CLASSIFICACAO_SEQ", sequenceName = "CLASSIFICACAO_SEQ", allocationSize = 1, initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "Classificacao.consultarClassificacao", query = "SELECT c FROM Classificacao c WHERE c.nome = :nome")
})
public class Classificacao implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 3911717865286224668L;

    @Id
    @GeneratedValue(generator = "CLASSIFICACAO_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String imagem;

    public Classificacao() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
