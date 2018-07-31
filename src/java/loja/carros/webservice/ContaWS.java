package loja.carros.webservice;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import loja.carros.dao.ContaDAO;
import loja.carros.model.Conta;
import loja.carros.model.Endereco;
import loja.carros.model.Telefone;

@WebService(serviceName = "ContaWS")
@Stateless()
public class ContaWS {

    @WebMethod(operationName = "salvarConta")
    public Conta salvarConta(@WebParam(name = "cpf") String cpf, @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha, @WebParam(name = "nome") String nome, @WebParam(name = "sobrenome") String sobrenome,
            @WebParam(name = "cep") String cep, @WebParam(name = "cidade") String cidade, @WebParam(name = "estado") String estado,
            @WebParam(name = "numero") String numero, @WebParam(name = "tipo") String tipo) {
        Conta conta = new Conta();
        conta.setCpf(cpf);
        conta.setEmail(email);
        conta.setSenha(senha);
        conta.setNome(nome);
        conta.setSobrenome(sobrenome);

        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        Telefone telefone = new Telefone();
        telefone.setNumero(numero);
        telefone.setTipo(tipo);

        conta.setEndereco(endereco);
        conta.setTelefone(telefone);

        return new ContaDAO().salvar(conta);
    }

    @WebMethod(operationName = "atualizarConta")
    public Conta atualizarConta(@WebParam(name = "idConta") String idConta, @WebParam(name = "cpf") String cpf, @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha, @WebParam(name = "nome") String nome, @WebParam(name = "sobrenome") String sobrenome,
            @WebParam(name = "idEndereco") String idEndereco, @WebParam(name = "cep") String cep, @WebParam(name = "cidade") String cidade, @WebParam(name = "estado") String estado,
            @WebParam(name = "idTelefone") String idTelefone, @WebParam(name = "numero") String numero, @WebParam(name = "tipo") String tipo) throws Exception {
        Conta conta = new Conta();
        conta.setId(Long.parseLong(idConta));
        conta.setCpf(cpf);
        conta.setEmail(email);
        conta.setSenha(senha);
        conta.setNome(nome);
        conta.setSobrenome(sobrenome);

        Endereco endereco = new Endereco();
        endereco.setId(Long.parseLong(idEndereco));
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        
        Telefone telefone = new Telefone();
        telefone.setId(Long.parseLong(idTelefone));
        telefone.setNumero(numero);
        telefone.setTipo(tipo);
        
        conta.setEndereco(endereco);
        conta.setTelefone(telefone);
        
        return new ContaDAO().atualizar(conta);
    }

    @WebMethod(operationName = "realizarLogin")
    public Conta realizarLogin(@WebParam(name = "email") String email, @WebParam(name = "senha") String senha) {
        Conta conta = new Conta();
        conta.setEmail(email);
        conta.setSenha(senha);

        return new ContaDAO().consultarConta(conta);
    }
    
    @WebMethod(operationName = "consultarContas")
    public List<Conta> consultarContas() {        
        List<Conta> contas = new ContaDAO().listaTodos(Conta.class);
        
        return contas;
    }
}
