package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import control.ContatoDAOImpl;
import model.Contato;

public class ContatoDAOImplTest{

    @Test
    public void inserirTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        assertNotNull(daoContato.inserir(contato));
        daoContato.apagarArquivo();
    }

    @Test
    public void buscarParteNomeTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        daoContato.inserir(contato2);
        daoContato.inserir(contato3);
        daoContato.inserir(contato4);
        daoContato.inserir(contato5);
        assertNotNull(daoContato.buscarPorParteNome("Victor"));
        daoContato.apagarArquivo();
    }

    @Test
    public void buscarParteNome2Teste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        daoContato.inserir(contato2);
        daoContato.inserir(contato3);
        daoContato.inserir(contato4);
        daoContato.inserir(contato5);
        assertNotNull(daoContato.buscarPorParteNome("ais"));
        daoContato.apagarArquivo();
    }

    @Test
    public void buscarParteNomeErroTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        daoContato.inserir(contato2);
        daoContato.inserir(contato3);
        daoContato.inserir(contato4);
        daoContato.inserir(contato5);
        assertNull(daoContato.buscarPorParteNome("Erro"));
        daoContato.apagarArquivo();
    }

    @Test
    public void removerContatoTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        daoContato.inserir(contato2);
        daoContato.inserir(contato3);
        daoContato.inserir(contato4);
        daoContato.inserir(contato5);
        assertTrue(daoContato.removerContato(contato));
        daoContato.apagarArquivo();
    }

    @Test
    public void removerContatoErroTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        daoContato.inserir(contato2);
        daoContato.inserir(contato3);
        daoContato.inserir(contato4);
        daoContato.inserir(contato5);
        Contato contatoRemover = new Contato("Victor", "12345678", "endereco teste", "victor@teste.teste");
        assertFalse(daoContato.removerContato(contatoRemover));
        daoContato.apagarArquivo();
    }

    @Test
    public void atualizarContatoTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        Contato contatoAtual = new Contato("Victor Souza", "12345678", "endereco teste", "victor@teste.teste");
        assertEquals(contatoAtual, daoContato.atualizarContato(contato, contatoAtual));
        daoContato.apagarArquivo();
    }

    @Test
    public void atualizarContato2Teste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        Contato contatoAtual = new Contato("Victor Souza", "12345678", "outro endereco", "victor@teste.teste");
        assertEquals(contatoAtual, daoContato.atualizarContato(contato, contatoAtual));
        daoContato.apagarArquivo();
    }

    @Test
    public void atualizarContatoErroTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        daoContato.inserir(contato);
        Contato contatoAtual = new Contato("Victor Souza", "12345678", "outro endereco", "victor@teste.teste");
        assertNull(daoContato.atualizarContato(contatoAtual, contatoAtual));
        daoContato.apagarArquivo();
    }

    @Test
    public void ListarContatosTeste(){
        Contato contato = new Contato("Victor", "12345678", "teste", "teste@teste.com");
        ContatoDAOImpl daoContato = new ContatoDAOImpl("teste.txt");
        for(int i = 0; i < 10; i++){
            contato.setNome(contato.getNome() + "x");
            daoContato.inserir(contato);
        }
        assertEquals(10, daoContato.listarTodosContatos().size());
        daoContato.apagarArquivo();
    }
}