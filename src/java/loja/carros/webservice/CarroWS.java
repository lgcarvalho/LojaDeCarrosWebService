package loja.carros.webservice;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import loja.carros.dao.CarroDAO;
import loja.carros.dao.ClassificacaoDAO;
import loja.carros.dao.MarcaDAO;
import loja.carros.model.Carro;
import loja.carros.model.Classificacao;
import loja.carros.model.Marca;

@WebService(serviceName = "CarroWS")
@Stateless()
public class CarroWS {

    @WebMethod(operationName = "salvarCarro")
    public Carro salvarCarro(@WebParam(name = "modelo") String modelo, @WebParam(name = "ano") String ano,
            @WebParam(name = "km") String km, @WebParam(name = "cor") String cor, @WebParam(name = "portas") String portas,
            @WebParam(name = "combustivel") String combustivel, @WebParam(name = "cambio") String cambio,
            @WebParam(name = "finalPlaca") String finalPlaca, @WebParam(name = "valor") String valor,
            @WebParam(name = "observacoes") String observacoes, @WebParam(name = "imagem") String imagem,
            @WebParam(name = "oferta") String oferta,
            @WebParam(name = "idMarca") String idMarca, @WebParam(name = "idClassificacao") String idClassificacao) {

        Marca marca = new MarcaDAO().consultarPorId(Marca.class, Long.valueOf(idMarca));

        System.out.println(marca.getNome());

        Classificacao classificacao = new ClassificacaoDAO().consultarPorId(Classificacao.class, Long.valueOf(idClassificacao));

        System.out.println(classificacao.getNome());

        Carro carro = new Carro();
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setKm(km);
        carro.setCor(cor);
        carro.setPortas(portas);
        carro.setCombustivel(combustivel);
        carro.setCambio(cambio);
        carro.setFinalPlaca(finalPlaca);
        carro.setValor(Double.valueOf(valor));
        carro.setObservacoes(observacoes);
        carro.setOferta(Boolean.valueOf(oferta));
        carro.setImagem(imagem);
        carro.setMarca(marca);
        carro.setClassificacao(classificacao);

        return new CarroDAO().salvar(carro);
    }

    @WebMethod(operationName = "consultarCarros")
    public List<Carro> consultarCarros() {
        return new CarroDAO().listaTodos(Carro.class);
    }

    @WebMethod(operationName = "consultarOfertas")
    public List<Carro> consultarOfertas() {
        return new CarroDAO().consultarOfertas();
    }

    @WebMethod(operationName = "consultarPorId")
    public Carro consultarPorId(@WebParam(name = "idCarro") String idCarro) {
        return new CarroDAO().consultarPorId(Carro.class, Long.valueOf(idCarro));
    }

    @WebMethod(operationName = "consultarPorMarca")
    public List<Carro> consultarPorMarca(@WebParam(name = "idMarca") String idMarca) {
        return new CarroDAO().consultarPorMarca(Long.valueOf(idMarca));
    }

    @WebMethod(operationName = "consultarPorClass")
    public List<Carro> consultarPorClass(@WebParam(name = "idClassificacao") String idClassificacao) {
        return new CarroDAO().consultarPorClass(Long.valueOf(idClassificacao));
    }

    @WebMethod(operationName = "consultarPorMarcaEClass")
    public List<Carro> consultarPorMarcaEClass(@WebParam(name = "idMarca") String idMarca, @WebParam(name = "idClassificacao") String idClassificacao) {
        return new CarroDAO().consultarPorMarcaEClass(Long.valueOf(idMarca), Long.valueOf(idClassificacao));
    }
}
