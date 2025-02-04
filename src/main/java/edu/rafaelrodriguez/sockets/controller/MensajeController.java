package edu.rafaelrodriguez.sockets.controller;

import edu.rafaelrodriguez.sockets.models.Mensaje;
import edu.rafaelrodriguez.sockets.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

   /* // Endpoint para guardar un mensaje
    @PostMapping
    public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
        return mensajeService.guardarMensaje(mensaje);
    }*/

    @PostMapping
    public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
        // Si el mensaje tiene una imagen, guarda la URL
        if (mensaje.getImagen() != null) {
            // Lógica para guardar el mensaje con la URL de la imagen
        }
        return mensajeService.guardarMensaje(mensaje);
    }

    // Endpoint para obtener todos los mensajes
    @GetMapping
    public List<Mensaje> obtenerTodosLosMensajes() {
        return mensajeService.obtenerTodosLosMensajes();
    }

    // Endpoint para obtener mensajes de un usuario específico
    @GetMapping("/usuario/{username}")
    public List<Mensaje> obtenerMensajesPorUsuario(@PathVariable String username) {
        return mensajeService.obtenerMensajesPorUsuario(username);
    }

   /* @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path filePath = Paths.get("src/main/resources/static/uploads/" + fileName);

        Files.createDirectories(filePath.getParent()); // Asegura que la carpeta exista
        Files.write(filePath, file.getBytes()); // Guarda la imagen

        Map<String, String> response = new HashMap<>();
        response.put("url", "/uploads/" + fileName); // URL relativa
        return ResponseEntity.ok(response);
    }*/

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadDir = "uploads/"; // Carpeta en la raíz del proyecto
        Files.createDirectories(Paths.get(uploadDir)); // Asegura que la carpeta exista

        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);
        Files.write(filePath, file.getBytes());

        Map<String, String> response = new HashMap<>();
        response.put("url", "/uploads/" + fileName);

        return ResponseEntity.ok(response);
    }
}

