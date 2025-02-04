package edu.rafaelrodriguez.sockets.models;

import edu.rafaelrodriguez.sockets.models.Mensaje;
import edu.rafaelrodriguez.sockets.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// CLASE CREADA PARA HACER FUNCION, SI NO TOCO ANGULAR EL PROGRAMA NO FUNCIONARA CORRECTAMENTE.
@Service
public class MensajeService1 {

    @Autowired
    private MensajeRepository mensajeRepository;

    // Guardar un mensaje
    public Mensaje guardarMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    // Obtener todos los mensajes
    public List<Mensaje> obtenerTodosLosMensajes() {
        return mensajeRepository.findAll();
    }

    // Obtener mensajes de un usuario específico
    public List<Mensaje> obtenerMensajesPorUsuario(String username) {
        return mensajeRepository.findByUsername(username);
    }

}
