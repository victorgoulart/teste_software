package model;

public class Contato {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    
    public Contato(){}
    
    public Contato(String nome, String telefone, String endereco, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Contato){
            Contato contato = (Contato)o;
            if(this.getNome().equals(contato.getNome())){
                return true;
            }
        }
        return false;
    }
}
