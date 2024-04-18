package src.GUI.java;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class HelloController {

    @FXML
    private Button IniciarSesion;

    @FXML
    private Button Registrar;

    @FXML
        private TextField correoField;

        @FXML
        private PasswordField passwordField;

        private final Map<String, String> users = new HashMap<>();
        private final File usersFile = new File("users.txt");

        @FXML
        protected void initialize() {
            loadUsers(); // Cargar los usuarios al iniciar la aplicación
        }

        @FXML
        protected void onLoginButtonClick() {
            String correo = correoField.getText();
            String password = passwordField.getText();

            if (users.containsKey(correo) && users.get(correo).equals(password)) {
                showAlert("Inicio de sesión exitoso para " + correo);
            } else {
                showAlert("Correo electrónico o contraseña incorrectos.");
            }
        }

        @FXML
        protected void onRegisterButtonClick() {
            String correo = correoField.getText();
            String password = passwordField.getText();

            if (users.containsKey(correo)) {
                showAlert("El usuario ya existe.");
            } else {
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

        private void loadUsers() {
            if (!usersFile.exists()) {
                return; // Si el archivo no existe, no hay usuarios para cargar
            }

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
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile, true))) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    writer.write(entry.getKey() + ":" + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
