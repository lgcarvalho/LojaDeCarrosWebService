package loja.carros.webservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import loja.carros.dao.AluguelDAO;
import loja.carros.dao.CarroDAO;
import loja.carros.dao.ContaDAO;
import loja.carros.dao.LojaDAO;
import loja.carros.model.Aluguel;
import loja.carros.model.Carro;
import loja.carros.model.Conta;
import loja.carros.model.Loja;

@WebService(serviceName = "AluguelWS")
@Stateless
public class AluguelWS {

    @WebMethod(operationName = "salvarAluguel")
    public Aluguel salvarAluguel(@WebParam(name = "dias") String dias, @WebParam(name = "status") String status,
            @WebParam(name = "idConta") String idConta, @WebParam(name = "idCarro") String idCarro,
            @WebParam(name = "idLoja") String idLoja) {

        Conta conta = new ContaDAO().consultarPorId(Conta.class, Long.valueOf(idConta));
        Carro carro = new CarroDAO().consultarPorId(Carro.class, Long.valueOf(idCarro));
        Loja loja = new LojaDAO().consultarPorId(Loja.class, Long.valueOf(idLoja));

        Aluguel aluguel = new Aluguel();
        aluguel.setDias(Integer.valueOf(dias));
        aluguel.setStatus(status);
        aluguel.setConta(conta);
        aluguel.setCarro(carro);
        aluguel.setLoja(loja);

        return new AluguelDAO().salvar(aluguel);
    }

    @WebMethod(operationName = "consultarPedidos")
    public List<Aluguel> consultarPedidos(@WebParam(name = "idCOnta") String idConta) {
        return new AluguelDAO().consultarPedidosPorId(Long.valueOf(idConta));
    }
    
    @WebMethod(operationName = "excluirPedido")
    public void excluirPedido(Long id) {
        new AluguelDAO().remover(Aluguel.class, id);
    }
}
