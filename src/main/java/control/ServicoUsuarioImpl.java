package control;

import java.util.List;
import model.Usuario;
import model.ServicoUsuario;
import model.Contato;

public class ServicoUsuarioImpl implements ServicoUsuario{

    Cesar cesar = new Cesar();
    String nomeArquivo = "users.txt";
    UsuarioDAOImpl daoUsuario;

    public ServicoUsuarioImpl(String nome_arq_dados_u){
        daoUsuario = new UsuarioDAOImpl(nomeArquivo);
    }
    
    @Override
    public Usuario inserir(Usuario u) {
        Usuario usuario = daoUsuario.buscarPorNomeUsuario(u.getNomeUsuario());
        if(usuario == null){
            VerificarUsuario verificar = new VerificarUsuario(u);
            if(verificar.usuarioOk()){
                daoUsuario.inserir(u);
                return u;
            }
        }
        return null;
    }
    
    @Override
    public Usuario inserir(String nomeUsuario, String senha, List<Contato> contatos) {
        Usuario usuario = daoUsuario.buscarPorNomeUsuario(nomeUsuario);
        if(usuario == null){
            VerificarUsuario verificar = new VerificarUsuario(usuario);
            if(verificar.usuarioOk()){
                Usuario u = new Usuario(nomeUsuario, senha, contatos);
                daoUsuario.inserir(u);
                return u;
            }
        }
        return null;
    }

    @Override
    public Usuario buscarPorNomeUsuario(String nomeUsuario) {
        Usuario usuario = daoUsuario.buscarPorNomeUsuario(nomeUsuario);
        if(usuario != null){
            return usuario;
        }
        return null;
    }

    @Override
    public boolean removerUsuario(Usuario u) {
        Usuario usuario = daoUsuario.buscarPorNomeUsuario(u.getNomeUsuario());
        if(usuario != null){
            return daoUsuario.removerUsuario(u);
        }
        return false;
    }

    @Override
    public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual) {
        VerificarUsuario verificar = new VerificarUsuario(uAtual);
        if(verificar.usuarioOk()){
            Usuario usuario = daoUsuario.buscarPorNomeUsuario(uAnt.getNomeUsuario());
            if(usuario != null){
                return daoUsuario.atualizarUsuario(uAnt, uAtual);
            }
        }
        return null;
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return daoUsuario.listarTodosUsuarios();
    }

    public boolean apagarArquivo()
    {
        return daoUsuario.apagarArquivo();
    }
}
