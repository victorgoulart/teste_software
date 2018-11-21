package control;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Contato;
import control.ServicoContatoImpl;

public class ServicoContatoImplTest{

    @Test
    public void inserirTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNotNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroContExistTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroNomeCarEspTeste(){
        Contato contato = new Contato("@Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroNomeVazioTeste(){
        Contato contato = new Contato(" ", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroTelLetrasTeste(){
        Contato contato = new Contato("Victor Goulart", "abc12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroTelNumCarTeste(){
        Contato contato = new Contato("Victor Goulart", "123456781234567812345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroEmailTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroEmail2Teste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroEndTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", " ", "victor@.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void inserirErroEndNumSeiTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "num sei", "victor@.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        assertNull(servicoContato.inserir(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void buscarParteNomeTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        servicoContato.inserir(contato2);
        servicoContato.inserir(contato3);
        servicoContato.inserir(contato4);
        servicoContato.inserir(contato5);
        assertNotNull(servicoContato.buscarPorParteNome("Victor"));
        servicoContato.apagarArquivo();
    }

    @Test
    public void buscarParteNome2Teste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        servicoContato.inserir(contato2);
        servicoContato.inserir(contato3);
        servicoContato.inserir(contato4);
        servicoContato.inserir(contato5);
        assertNotNull(servicoContato.buscarPorParteNome("ais"));
        servicoContato.apagarArquivo();
    }

    @Test
    public void buscarParteNomeErroTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        servicoContato.inserir(contato2);
        servicoContato.inserir(contato3);
        servicoContato.inserir(contato4);
        servicoContato.inserir(contato5);
        assertNull(servicoContato.buscarPorParteNome("Erro"));
        servicoContato.apagarArquivo();
    }

    @Test
    public void removerContatoTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        servicoContato.inserir(contato2);
        servicoContato.inserir(contato3);
        servicoContato.inserir(contato4);
        servicoContato.inserir(contato5);
        assertTrue(servicoContato.removerContato(contato));
        servicoContato.apagarArquivo();
    }

    @Test
    public void removerContatoErroTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato2 = new Contato("Nome teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato3 = new Contato("Outro teste", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato4 = new Contato("Mais um", "12345678", "endereco teste", "victor@teste.teste");
        Contato contato5 = new Contato("Ultimo nome", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        servicoContato.inserir(contato2);
        servicoContato.inserir(contato3);
        servicoContato.inserir(contato4);
        servicoContato.inserir(contato5);
        Contato contatoRemover = new Contato("Victor", "12345678", "endereco teste", "victor@teste.teste");
        assertFalse(servicoContato.removerContato(contatoRemover));
        servicoContato.apagarArquivo();
    }

    @Test
    public void atualizarContatoTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        Contato contatoAtual = new Contato("Victor Souza", "12345678", "endereco teste", "victor@teste.teste");
        assertEquals(contatoAtual, servicoContato.atualizarContato(contato, contatoAtual));
        servicoContato.apagarArquivo();
    }

    @Test
    public void atualizarContato2Teste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        Contato contatoAtual = new Contato("Victor Souza", "12345678", "outro endereco", "victor@teste.teste");
        assertEquals(contatoAtual, servicoContato.atualizarContato(contato, contatoAtual));
        servicoContato.apagarArquivo();
    }

    @Test
    public void atualizarContatoErroTeste(){
        Contato contato = new Contato("Victor Goulart", "12345678", "endereco teste", "victor@teste.teste");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        servicoContato.inserir(contato);
        Contato contatoAtual = new Contato("Victor Souza", "12345678", "outro endereco", "victor@teste.teste");
        assertNull(servicoContato.atualizarContato(contatoAtual, contatoAtual));
        servicoContato.apagarArquivo();
    }

    @Test
    public void ListarContatosTeste(){
        Contato contato = new Contato("Victor", "12345678", "teste", "teste@teste.com");
        ServicoContatoImpl servicoContato = new ServicoContatoImpl("teste.txt");
        for(int i = 0; i < 10; i++){
            contato.setNome(contato.getNome() + "x");
            servicoContato.inserir(contato);
        }
        assertEquals(10, servicoContato.listarTodosContatos().size());
        servicoContato.apagarArquivo();
    }
}