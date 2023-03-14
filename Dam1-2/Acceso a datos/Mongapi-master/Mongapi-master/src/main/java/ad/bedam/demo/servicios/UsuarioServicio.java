package ad.bedam.demo.servicios;

import ad.bedam.demo.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio
{
    Usuario obtenerUsuario(Long idUsuario);
    Usuario actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(Long idUsuario);
    Usuario crearUsuario(Usuario usuario);
}
