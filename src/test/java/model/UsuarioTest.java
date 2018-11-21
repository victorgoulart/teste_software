package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import model.Usuario;

public class UsuarioTest{
    @Test
    public void compararUsuarios(){
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        u1.setNomeUsuario("Usuario1");
        u1.setSenha("123456");
        u2.setNomeUsuario("Usuario1");
        u2.setSenha("123456");
        assertEquals(u1, u2);
    }

    @Test
    public void compararUsuariosErro(){
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        u1.setNomeUsuario("Usuario1");
        u1.setSenha("123456");
        u2.setNomeUsuario("Usuario2");
        u1.setSenha("654321");
        assertNotEquals(u1, u2);
    }
}