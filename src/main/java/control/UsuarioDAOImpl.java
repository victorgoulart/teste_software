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
import model.Usuario;
import model.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {
    
    Cesar cesar = new Cesar();
    String nomeArquivo = "users.txt";
    public UsuarioDAOImpl(String arquivo){
        nomeArquivo = arquivo;
    }

    @Override
    public Usuario inserir(Usuario u)
    {
		try(FileWriter arquivo = new FileWriter(("src/main/java/resources/" + nomeArquivo), true);
			BufferedWriter bw = new BufferedWriter(arquivo);
			PrintWriter writer = new PrintWriter(bw))
		{
            writer.println(cesar.criptografar(u.getNomeUsuario()) + "; " + cesar.criptografar(u.getSenha()));
            return u;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
        } catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException g) {
			g.printStackTrace();
		}
		return null;
    }

    @Override
    public Usuario buscarPorNomeUsuario(String nomeUsuario)
    {
        List<Usuario> usuarios = listarTodosUsuarios();
        if(usuarios != null){
            for(int i = 0; i < usuarios.size(); i++){
                if(usuarios.get(i).getNomeUsuario().contains(nomeUsuario)){
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public boolean removerUsuario(Usuario u)
    {
        List<Usuario> usuarios = listarTodosUsuarios();
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).equals(u)){
                usuarios.remove(i);
                try(FileWriter arquivo = new FileWriter(("src/main/java/resources/" + nomeArquivo), false);
                    BufferedWriter bw = new BufferedWriter(arquivo);
                    PrintWriter writer = new PrintWriter(bw))
                {
                    for(int j = 0; j < usuarios.size(); j++){
                        writer.println(cesar.criptografar(u.getNomeUsuario()) + "; " + cesar.criptografar(u.getSenha()));
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
    
    @Override
    public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual)
    {
        List<Usuario> usuarios = listarTodosUsuarios();
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).equals(uAnt)){
                usuarios.set(i, uAtual);
                try(FileWriter arquivo = new FileWriter(("src/main/java/resources/" + nomeArquivo), false);
                    BufferedWriter bw = new BufferedWriter(arquivo);
                    PrintWriter writer = new PrintWriter(bw))
                {
                    for(int j = 0; j < usuarios.size(); j++){
                        writer.println(cesar.criptografar(usuarios.get(j).getNomeUsuario()) + "; " + cesar.criptografar(usuarios.get(j).getSenha()));
                    }
                    return uAtual;
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
    
    @Override
    public List<Usuario> listarTodosUsuarios()
    {
        List<Usuario> usuarios = new ArrayList<Usuario>();
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
		    	usuarios.add(new Usuario(cesar.descriptografar(aux[0]), cesar.descriptografar(aux[1])));
		    }
		} catch (IOException e) {
            e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
                    br.close();
                    return usuarios;
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