package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import control.UsuarioDAOImpl;
import model.Usuario;

public class UsuarioDAOImplTest{

    @Test
    public void inserirTeste(){
        Usuario Usuario = new Usuario("Victor Goulart", "12345678");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        assertNotNull(daoUsuario.inserir(Usuario));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void buscarNomeUsuarioTeste(){
        Usuario Usuario = new Usuario("victor", "12345678");
        Usuario Usuario2 = new Usuario("victor_goulart", "87654321");
        Usuario Usuario3 = new Usuario("teste", "teste");
        Usuario Usuario4 = new Usuario("outro", "outro");
        Usuario Usuario5 = new Usuario("ultimo", "ultimo");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        daoUsuario.inserir(Usuario);
        daoUsuario.inserir(Usuario2);
        daoUsuario.inserir(Usuario3);
        daoUsuario.inserir(Usuario4);
        daoUsuario.inserir(Usuario5);
        assertNotNull(daoUsuario.buscarPorNomeUsuario("victor"));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void buscarNomeUsuarioErroTeste(){
        Usuario Usuario = new Usuario("victor", "12345678");
        Usuario Usuario2 = new Usuario("victor_goulart", "87654321");
        Usuario Usuario3 = new Usuario("teste", "teste");
        Usuario Usuario4 = new Usuario("outro", "outro");
        Usuario Usuario5 = new Usuario("ultimo", "ultimo");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        daoUsuario.inserir(Usuario);
        daoUsuario.inserir(Usuario2);
        daoUsuario.inserir(Usuario3);
        daoUsuario.inserir(Usuario4);
        daoUsuario.inserir(Usuario5);
        assertNull(daoUsuario.buscarPorNomeUsuario("Erro"));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void removerUsuarioTeste(){
        Usuario Usuario = new Usuario("victor", "12345678");
        Usuario Usuario2 = new Usuario("victor_goulart", "87654321");
        Usuario Usuario3 = new Usuario("teste", "teste");
        Usuario Usuario4 = new Usuario("outro", "outro");
        Usuario Usuario5 = new Usuario("ultimo", "ultimo");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        daoUsuario.inserir(Usuario);
        daoUsuario.inserir(Usuario2);
        daoUsuario.inserir(Usuario3);
        daoUsuario.inserir(Usuario4);
        daoUsuario.inserir(Usuario5);
        assertTrue(daoUsuario.removerUsuario(Usuario));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void removerUsuarioErroTeste(){
        Usuario Usuario = new Usuario("victor", "12345678");
        Usuario Usuario2 = new Usuario("victor_goulart", "87654321");
        Usuario Usuario3 = new Usuario("teste", "teste");
        Usuario Usuario4 = new Usuario("outro", "outro");
        Usuario Usuario5 = new Usuario("ultimo", "ultimo");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        daoUsuario.inserir(Usuario);
        daoUsuario.inserir(Usuario2);
        daoUsuario.inserir(Usuario3);
        daoUsuario.inserir(Usuario4);
        daoUsuario.inserir(Usuario5);
        Usuario UsuarioRemover = new Usuario("VictorSouza", "12345678");
        assertFalse(daoUsuario.removerUsuario(UsuarioRemover));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void atualizarUsuarioTeste(){
        Usuario Usuario = new Usuario("VictorGoulart", "12345678");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        daoUsuario.inserir(Usuario);
        Usuario UsuarioAtual = new Usuario("VictorSouza", "12345678");
        assertEquals(UsuarioAtual, daoUsuario.atualizarUsuario(Usuario, UsuarioAtual));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void atualizarUsuarioErroTeste(){
        Usuario Usuario = new Usuario("VictorGoulart", "12345678");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        daoUsuario.inserir(Usuario);
        Usuario UsuarioAtual = new Usuario("VictorSouza", "12345678");
        assertNull(daoUsuario.atualizarUsuario(UsuarioAtual, UsuarioAtual));
        daoUsuario.apagarArquivo();
    }

    @Test
    public void ListarUsuariosTeste(){
        Usuario Usuario = new Usuario("Victor", "12345678");
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl("users.txt");
        for(int i = 0; i < 10; i++){
            Usuario.setNomeUsuario(Usuario.getNomeUsuario() + "x");
            daoUsuario.inserir(Usuario);
        }
        assertEquals(10, daoUsuario.listarTodosUsuarios().size());
        daoUsuario.apagarArquivo();
    }
}