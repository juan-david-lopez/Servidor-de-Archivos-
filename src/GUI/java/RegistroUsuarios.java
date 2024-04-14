package src.GUI.java;

import java.util.HashMap;
import java.util.Map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class RegistroUsuarios {
    private Map<String, String> usuarios;

    public RegistroUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(String correo, String contraseña) {
        usuarios.put(correo, contraseña);
        saveUsers(); // Guardar el usuario recién registrado
    }

    public boolean autenticarUsuario(String correo, String contraseña) {
        return usuarios.containsKey(correo) && usuarios.get(correo).equals(contraseña);
    }

    public void mostrarUsuariosRegistrados() {
        System.out.println("Usuarios registrados:");
        for (Map.Entry<String, String> entry : usuarios.entrySet()) {
            System.out.println("Correo: " + entry.getKey() + ", Contraseña: " + entry.getValue());
        }
    }

    public Map<String, String> getUsuariosRegistrados() {
        return usuarios;
    }

    public void cambiarContraseña(String correo, String nuevaContraseña) {
        if (usuarios.containsKey(correo)) {
            usuarios.put(correo, nuevaContraseña);
            System.out.println("Contraseña cambiada correctamente para el usuario con correo: " + correo);
        } else {
            System.out.println("El usuario con correo " + correo + " no existe.");
        }
    }

    private void saveUsers() {
        String usersFile = "users.txt"; // Ruta del archivo donde se guardarán los usuarios
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile, true))) {
            // Obtener el último usuario registrado
            Map.Entry<String, String> lastEntry = usuarios.entrySet().stream().skip(usuarios.size() - 1).findFirst().orElse(null);
            if (lastEntry != null) {
                writer.write(lastEntry.getKey() + ":" + lastEntry.getValue());
                writer.newLine();
            }
            writer.flush(); // Asegúrate de que todos los datos se escriban en el archivo
        } catch (IOException e) {
            e.printStackTrace(); // Maneja cualquier excepción de escritura de archivo
        }
    }
}