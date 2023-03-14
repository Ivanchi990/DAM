package ad.bedam.demo.servicios.imp;

import ad.bedam.demo.entidades.Usuario;
import ad.bedam.demo.repositorios.UsuarioRepositorio;
import ad.bedam.demo.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImp implements UsuarioServicio
{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {
        return usuarioRepositorio.findById(idUsuario).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public boolean eliminarUsuario(Long idUsuario) {
        usuarioRepositorio.deleteById(idUsuario);
        return true;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
