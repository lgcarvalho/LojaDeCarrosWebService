package loja.carros.webservice;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import loja.carros.dao.MarcaDAO;
import loja.carros.model.Marca;

@WebService(serviceName = "MarcaWS")
@Stateless()
public class MarcaWS {

    @WebMethod(operationName = "salvarMarca")
    public Marca salvarMarca(@WebParam(name = "nome") String nome, @WebParam(name = "imagem") String imagem) {
        Marca marca = new Marca();
        marca.setNome(nome);
        marca.setImagem(imagem);

        return new MarcaDAO().salvar(marca);
    }

    @WebMethod(operationName = "atualizarMarca")
    public Marca atualizarMarca(@WebParam(name = "id") String id, @WebParam(name = "nome") String nome, @WebParam(name = "imagem") String imagem) throws Exception {
        Marca marca = new Marca();
        marca.setId(Long.parseLong(id));
        marca.setNome(nome);
        marca.setImagem(imagem);

        return new MarcaDAO().atualizar(marca);
    }

    @WebMethod(operationName = "consultarMarcas")
    public List<Marca> consultarMarcas() {
        return new MarcaDAO().listaTodos(Marca.class);
    }
    
    @WebMethod(operationName = "consultarPorId")
    public Marca consultarPotId(@WebParam(name = "id") String id) {
        return new MarcaDAO().consultarPorId(Marca.class, Long.parseLong(id));
    }
    
    @WebMethod(operationName = "consultarMarca")
    public Marca consultarMarca(@WebParam(name = "nome") String nome) {
        List<Marca> mar = new MarcaDAO().consultarMarca(nome);
        
        return mar.get(0);
    }
}
