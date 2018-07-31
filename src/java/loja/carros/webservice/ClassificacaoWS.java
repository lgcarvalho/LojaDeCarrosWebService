package loja.carros.webservice;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import loja.carros.dao.ClassificacaoDAO;
import loja.carros.model.Classificacao;

@WebService(serviceName = "ClassificacaoWS")
@Stateless()
public class ClassificacaoWS {

    @WebMethod(operationName = "salvarClassificacao")
    public Classificacao salvarClassificacao(@WebParam(name = "nome") String nome, @WebParam(name = "imagem") String imagem) {
        Classificacao classificacao = new Classificacao();
        classificacao.setNome(nome);
        classificacao.setImagem(imagem);

        return new ClassificacaoDAO().salvar(classificacao);
    }

    @WebMethod(operationName = "atualizarMarca")
    public Classificacao atualizarMarca(@WebParam(name = "id") String id, @WebParam(name = "nome") String nome, @WebParam(name = "imagem") String imagem) throws Exception {
        Classificacao classificacao = new Classificacao();
        classificacao.setId(Long.parseLong(id));
        classificacao.setNome(nome);
        classificacao.setImagem(imagem);

        return new ClassificacaoDAO().salvar(classificacao);
    }
    
    @WebMethod(operationName = "consultarClassificacoes")
    public List<Classificacao> consultarClassificacoes() {
        return new ClassificacaoDAO().listaTodos(Classificacao.class);
    }
    
    @WebMethod(operationName = "consultarClassificacao")
    public Classificacao consultarClassificacao(@WebParam(name = "nome") String nome) {
        List<Classificacao> cla = new ClassificacaoDAO().consultarClassificacao(nome);
        
        return cla.get(0);
    }
}
