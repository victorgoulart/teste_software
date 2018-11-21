package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import model.Contato;
import model.ContatoDAO;

public class ContatoDAOImpl implements ContatoDAO {
    
    String nomeArquivo;
    public ContatoDAOImpl(String arquivo){
        nomeArquivo = arquivo;
    }

    public Contato inserir(Contato c)
    {
		try(FileWriter arquivo = new FileWriter(("src/main/java/resources/" + nomeArquivo), true);
			BufferedWriter bw = new BufferedWriter(arquivo);
			PrintWriter writer = new PrintWriter(bw))
		{
            writer.println(c.getNome() + "; " + c.getTelefone() + "; " +
                    c.getEmail() + "; " + c.getEndereco());
            return c;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
        } catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException g) {
			g.printStackTrace();
		}
		return null;
    }

    public List<Contato> buscarPorParteNome(String parteNome)
    {
        List<Contato> resultado = new ArrayList<Contato>();
        List<Contato> contatos = listarTodosContatos();
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).getNome().contains(parteNome)){
                resultado.add(contatos.get(i));
            }
        }
        if(resultado.isEmpty()){
            return null;
        }
        return resultado;
    }

    public boolean removerContato(Contato c)
    {
        List<Contato> contatos = listarTodosContatos();
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).equals(c)){
                contatos.remove(i);
                try(FileWriter arquivo = new FileWriter(("src/main/java/resources/" + nomeArquivo), false);
                    BufferedWriter bw = new BufferedWriter(arquivo);
                    PrintWriter writer = new PrintWriter(bw))
                {
                    for(int j = 0; j < contatos.size(); j++){
                        writer.println(contatos.get(j).getNome() + "; " + contatos.get(j).getTelefone() + "; " +
                        contatos.get(j).getEmail() + "; " + contatos.get(j).getEndereco());
                    }
                    return true;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException f) {
                    f.printStackTrace();
                } catch (IOException g) {
                    g.printStackTrace();
                }
            }
        }
        return false;
    }

    public Contato atualizarContato(Contato cAnt, Contato cAtual)
    {
        List<Contato> contatos = listarTodosContatos();
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).equals(cAnt)){
                contatos.set(i, cAtual);
                try(FileWriter arquivo = new FileWriter(("src/main/java/resources/" + nomeArquivo), false);
                    BufferedWriter bw = new BufferedWriter(arquivo);
                    PrintWriter writer = new PrintWriter(bw))
                {
                    for(int j = 0; j < contatos.size(); j++){
                        writer.println(contatos.get(j).getNome() + "; " + contatos.get(j).getTelefone() + "; " +
                        contatos.get(j).getEmail() + "; " + contatos.get(j).getEndereco());
                    }
                    return cAtual;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException f) {
                    f.printStackTrace();
                } catch (IOException g) {
                    g.printStackTrace();
                }
            }
        }
        return null;
    }
    
    public List<Contato> listarTodosContatos()
    {
        List<Contato> contatos = new ArrayList<Contato>();
		FileReader arquivo = null;
		try {
		    arquivo = new FileReader(new File(("src/main/java/resources/" + nomeArquivo)));
		} catch (FileNotFoundException e1) {
		    return null;
		}
		BufferedReader br = new BufferedReader(arquivo);
		String linha;
		try {
		    while ((linha = br.readLine()) != null) {
		    	String aux[] = linha.split("; ");
		    	contatos.add(new Contato(aux[0], aux[1], aux[3], aux[2]));
		    }
		} catch (IOException e) {
            e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
                    br.close();
                    return contatos;
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
        }
        return null;
    } 

    public boolean apagarArquivo()
    {
        try{
    		File file = new File(("src/main/java/resources/" + nomeArquivo));
    		if(file.delete()){
                return true;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return false;
    }
}