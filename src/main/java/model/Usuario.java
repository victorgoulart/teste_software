package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nomeUsuario;
    private String senha;
    List<Contato> contatos;
    
    public Usuario(String nomeUsuario, String senha){
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        contatos = new ArrayList<Contato>();
    }

    public Usuario(String nomeUsuario, String senha, List<Contato> contatos){
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.contatos = contatos;
    }

    public Usuario(){}

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Usuario){
            Usuario usuario = (Usuario)o;
            if(this.getNomeUsuario().equals(usuario.getNomeUsuario()) && this.getSenha().equals(usuario.getSenha())){
                return true;
            }
        }
        return false;
    }
}
