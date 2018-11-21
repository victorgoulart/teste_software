package control;

import model.Usuario;

public class UsuarioAtivo {
	public static Usuario usuario = new Usuario();

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		UsuarioAtivo.usuario = usuario;
	}
}
