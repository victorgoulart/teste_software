package control;

import model.Usuario;

public class VerificarUsuario{
    Usuario usuario;
    public VerificarUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public boolean usuarioOk(){
        String userName = this.usuario.getNomeUsuario();
        String senha = this.usuario.getSenha();
        if((userName.matches("^[a-z0-9]+$") && userName.length() >= 5 && userName.length() <= 15) &&
    		(senha.matches("^[a-z0-9]+$") && senha.length() >= 5 && senha.length() <= 15)){
    		return true;
        }
        return false;
    }
}