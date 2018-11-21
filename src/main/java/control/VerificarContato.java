package control;

import model.Contato;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificarContato{
    Contato contato;
    
    public VerificarContato(Contato contato){
        this.contato = contato;
    }

    public boolean contatoOk(){
        boolean dadosOk = true;
    	if(contato.getNome().trim().isEmpty() || !contato.getNome().matches("^[a-zA-Z0-9áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\\s]+$")){
    		dadosOk = false;
    	}
    	if(!contato.getTelefone().matches("^[0-9]+$") || !(contato.getTelefone().length() >=8 && contato.getTelefone().length() <= 20)){
    		dadosOk = false;
    	}
    	Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(contato.getEmail());
        if(!m.find()){
        	dadosOk = false;
        }
        List<String> endInvalidos = Arrays.asList("lugar nenhum", "judas perdeu as botas", "casa da mae joana", "num sei");
        if(!(contato.getEndereco().length() >=3 && contato.getEndereco().length() <= 255) || endInvalidos.contains(contato.getEndereco())){
        	dadosOk = false;
        }
        return dadosOk;
    }
}