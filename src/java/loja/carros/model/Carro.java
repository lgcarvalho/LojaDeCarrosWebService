package loja.carros.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "CARRO_SEQ", sequenceName = "CARRO_SEQ", allocationSize = 1, initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "Carro.consultarOfertas", query = "SELECT c FROM Carro c WHERE c.oferta = true"),
    @NamedQuery(name = "Carro.consultarPorMarca", query = "SELECT c FROM Carro c WHERE c.marca.id = :idMarca"),
    @NamedQuery(name = "Carro.consultarPorClass", query = "SELECT c FROM Carro c WHERE c.classificacao.id = :idClassificacao"),
    @NamedQuery(name = "Carro.consultarPorMarcaEClass", query = "SELECT c FROM Carro c WHERE c.marca.id = :idMarca AND c.classificacao.id = :idClassificacao")
})
public class Carro implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 4388658300612784539L;

    @Id
    @GeneratedValue(generator = "CARRO_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String ano;
    @Column(nullable = false)
    private String km;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String portas;
    @Column(nullable = false)
    private String combustivel;
    @Column(nullable = false)
    private String cambio;
    @Column(name = "final_placa", nullable = false)
    private String finalPlaca;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private String observacoes;
    @Column(nullable = false)
    private boolean oferta;
    @Column(nullable = false)
    private String imagem;
    @OneToOne()
    private Marca marca;
    @OneToOne()
    private Classificacao classificacao;

    public Carro() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getFinalPlaca() {
        return finalPlaca;
    }

    public void setFinalPlaca(String finalPlaca) {
        this.finalPlaca = finalPlaca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isOferta() {
        return oferta;
    }

    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
   
}
