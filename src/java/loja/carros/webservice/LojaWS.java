package loja.carros.webservice;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import loja.carros.dao.LojaDAO;
import loja.carros.model.Endereco;
import loja.carros.model.Loja;
import loja.carros.model.Telefone;

@WebService(serviceName = "LojaWS")
@Stateless()
public class LojaWS {
    
    @WebMethod(operationName = "salvarLoja")
    public Loja salvarLoja(@WebParam(name = "nome") String nome, @WebParam(name = "coordenada") String coordenada, @WebParam(name = "imagem") String imagem,
            @WebParam(name = "cep") String cep, @WebParam(name = "cidade") String cidade, @WebParam(name = "estado") String estado,
            @WebParam(name = "numero") String numero, @WebParam(name = "tipo") String tipo) {
        Loja loja = new Loja();
        loja.setNome(nome);
        loja.setCoordenada(coordenada);
        loja.setImagem(imagem);

        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        Telefone telefone = new Telefone();
        telefone.setNumero(numero);
        telefone.setTipo(tipo);

        loja.setEndereco(endereco);
        loja.setTelefone(telefone);

        return new LojaDAO().salvar(loja);
    }

    @WebMethod(operationName = "atualizarLoja")
    public Loja atualizarLoja(@WebParam(name = "idLoja") String idLoja, @WebParam(name = "nome") String nome, 
            @WebParam(name = "coordenada") String coordenada, @WebParam(name = "imagem") String imagem,
            @WebParam(name = "idEndereco") String idEndereco, @WebParam(name = "cep") String cep, @WebParam(name = "cidade") String cidade, @WebParam(name = "estado") String estado,
            @WebParam(name = "idTelefone") String idTelefone, @WebParam(name = "numero") String numero, @WebParam(name = "tipo") String tipo) throws Exception {
        Loja loja = new Loja();
        loja.setId(Long.parseLong(idLoja));
        loja.setNome(nome);
        loja.setCoordenada(coordenada);
        loja.setImagem(imagem);

        Endereco endereco = new Endereco();
        endereco.setId(Long.parseLong(idEndereco));
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        
        Telefone telefone = new Telefone();
        telefone.setId(Long.parseLong(idTelefone));
        telefone.setNumero(numero);
        telefone.setTipo(tipo);
        
        loja.setEndereco(endereco);
        loja.setTelefone(telefone);
        
        return new LojaDAO().atualizar(loja);
    }

    @WebMethod(operationName = "consultarLojas")
    public List<Loja> consultarLojas() {
        return new LojaDAO().listaTodos(Loja.class);
    }
}
