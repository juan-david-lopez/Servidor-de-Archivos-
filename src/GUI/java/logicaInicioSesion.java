package src.GUI.java;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class logicaInicioSesion extends VBox {

    private final TextField correoField;
    private final PasswordField passwordField;
    private final Map<String, String> users; // Almacenamiento de usuarios en memoria
    private final File usersFile;

    public logicaInicioSesion(Stage primaryStage) {
        users = new HashMap<>();
        usersFile = new File("users.txt");

        // Cargar usuarios almacenados previamente, si existen
        loadUsers();

        // Crear nodos
        correoField = new TextField();
        correoField.setPromptText("Correo electrónico");

        passwordField = new PasswordField();
        passwordField.setPromptText("Contraseña");

        Button iniciarSesionButton = new Button("Iniciar Sesión");
        Button registrarButton = new Button("Registrar");

        // Configurar eventos de los botones
        iniciarSesionButton.setOnAction(event -> iniciarSesion());
        registrarButton.setOnAction(event -> registrarUsuario());

        // Configurar el diseño
        setSpacing(10);
        setPadding(new Insets(20));
        getChildren().addAll(correoField, passwordField, iniciarSesionButton, registrarButton);
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        // Verificar si el archivo ya contiene usuarios
        boolean fileIsEmpty = !usersFile.exists() || usersFile.length() == 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
            // Si el archivo está vacío o no existe, escribir los usuarios
            if (fileIsEmpty) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    writer.write(entry.getKey() + ":" + entry.getValue());
                    writer.newLine();
                }
            } else {
                // Eliminar usuarios duplicados antes de escribirlos
                Map<String, String> uniqueUsers = new HashMap<>();
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    uniqueUsers.put(entry.getKey(), entry.getValue());
                }
                // Escribir los usuarios únicos en el archivo
                for (Map.Entry<String, String> entry : uniqueUsers.entrySet()) {
                    writer.write(entry.getKey() + ":" + entry.getValue());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void iniciarSesion() {
        String correo = correoField.getText();
        String password = passwordField.getText();

        // Verificar si el usuario existe en el almacenamiento
        if (users.containsKey(correo) && users.get(correo).equals(password)) {
            showAlert("Inicio de sesión exitoso para " + correo);
        } else {
            showAlert("Correo electrónico o contraseña incorrectos.");
        }
    }

    private void registrarUsuario() {
        String correo = correoField.getText();
        String password = passwordField.getText();

        // Verificar si el usuario ya existe en el almacenamiento
        if (users.containsKey(correo)) {
            showAlert("El usuario ya existe.");
        } else {
            // Guardar el nuevo usuario en el almacenamiento
            users.put(correo, password);
            saveUsers();
            showAlert("Usuario registrado exitosamente.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
