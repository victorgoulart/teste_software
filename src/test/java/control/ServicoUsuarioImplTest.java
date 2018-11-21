package control;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import model.Usuario;
import control.ServicoUsuarioImpl;

public class ServicoUsuarioImplTest{

    @Test
    public void inserirTeste(){
        Usuario usuario = new Usuario("victorgoulart", "12345678");
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl("users.txt");
        assertNotNull(servicoUsuario.inserir(usuario));
        servicoUsuario.apagarArquivo();
    }

    @Test
    public void inserirErroUsuExistTeste(){
        Usuario usuario = new Usuario("victorgoulart", "12345678");
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl("users.txt");
        servicoUsuario.inserir(usuario);
        assertNull(servicoUsuario.inserir(usuario));
        servicoUsuario.apagarArquivo();
    }

    @Test
    public void inserirErroNomeCarEspTeste(){
        Usuario usuario = new Usuario("@victorgoulart", "12345678");
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl("users.txt");
        assertNull(servicoUsuario.inserir(usuario));
        servicoUsuario.apagarArquivo();
    }

    @Test
    public void inserirErroNomeVazioTeste(){
        Usuario usuario = new Usuario(" ", "12345678");
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl("users.txt");
        assertNull(servicoUsuario.inserir(usuario));
        servicoUsuario.apagarArquivo();
    }

    @Test
    public void inserirErroSenhaCarEspTeste(){
        Usuario usuario = new Usuario("victorgoulart", "12345678@");
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl("users.txt");
        assertNull(servicoUsuario.inserir(usuario));
        servicoUsuario.apagarArquivo();
    }

    @Test
    public void inserirErroSenhaVazioTeste(){
        Usuario usuario = new Usuario("victorgoulart", " ");
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl("users.txt");
        assertNull(servicoUsuario.inserir(usuario));
        servicoUsuario.apagarArquivo();
    }
}