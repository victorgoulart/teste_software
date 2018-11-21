package control;

import java.util.List;
import model.Contato;
import model.ServicoContato;

public class ServicoContatoImpl implements
             ServicoContato{

    ContatoDAOImpl daoContato;
    Cesar cesar = new Cesar();
    public ServicoContatoImpl(String nome_arq_dados_c){
        daoContato = new ContatoDAOImpl("data_u" + cesar.criptografar(nome_arq_dados_c) + ".txt");
    }

    @Override
    public Contato inserir(Contato c) {
        if(daoContato.listarTodosContatos() != null){
            for(int i = 0; i < daoContato.listarTodosContatos().size(); i++){
                if(daoContato.listarTodosContatos().get(i).equals(c)){
                    return null;
                }
            }
        }
        VerificarContato verificar = new VerificarContato(c);
        if(verificar.contatoOk()){
            daoContato.inserir(c);
            return c;
        }
        return null;
    }

    @Override
    public Contato inserir(String nome, String tel, String email, String end) {
        Contato c = new Contato(nome, tel, email, end);
        if(!daoContato.listarTodosContatos().contains(c)){
            VerificarContato verificar = new VerificarContato(c);
            if(verificar.contatoOk()){
                daoContato.inserir(c);
                return c;
            }
        }
        return null;
    }
    
    @Override
    public List<Contato> buscarPorParteNome(String parteNome) {
        List<Contato> contatos = daoContato.buscarPorParteNome(parteNome);
        return contatos;
    }

    @Override
    public boolean removerContato(Contato c) {
        if(daoContato.listarTodosContatos().contains(c)){
            return daoContato.removerContato(c);
        }
        return false;
    }

    @Override
    public Contato atualizarContato(Contato cAnt, Contato cAtual) {
        VerificarContato verificar = new VerificarContato(cAtual);
        if(verificar.contatoOk()){
            if(daoContato.listarTodosContatos().contains(cAnt)){
                return daoContato.atualizarContato(cAnt, cAtual);
            }
        }
        return null;
    }

    @Override
    public List<Contato> listarTodosContatos() {
        return daoContato.listarTodosContatos();
    }

    public boolean apagarArquivo()
    {
        return daoContato.apagarArquivo();
    }
}
