package src.Util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {
    // ResourceBundle predeterminado
    private static final ResourceBundle DEFAULT_BUNDLE = ResourceBundle.getBundle("messages", Locale.getDefault());
    /**
     * Obtiene un mensaje internacionalizado del ResourceBundle predeterminado
     * para la clave especificada, formateado con los argumentos dados.
     *
     * @param key  La clave del mensaje.
     * @param args Los argumentos para formatear el mensaje.
     * @return El mensaje internacionalizado.
     */
    public static String getMessage(String key, Object... args) {
        return getMessage(DEFAULT_BUNDLE, key, args);
    }
    /**
     * Obtiene un mensaje internacionalizado del ResourceBundle especificado
     * para la clave especificada, formateado con los argumentos dados.
     *
     * @param locale El Locale del ResourceBundle.
     * @param key    La clave del mensaje.
     * @param args   Los argumentos para formatear el mensaje.
     * @return El mensaje internacionalizado.
     */
    public static String getMessage(Locale locale, String key, Object... args) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return getMessage(bundle, key, args);
    }
    /**
     * Método privado para obtener un mensaje internacionalizado del ResourceBundle dado
     * para la clave especificada, formateado con los argumentos dados.
     *
     * @param bundle El ResourceBundle.
     * @param key    La clave del mensaje.
     * @param args   Los argumentos para formatear el mensaje.
     * @return El mensaje internacionalizado.
     */
    private static String getMessage(ResourceBundle bundle, String key, Object... args) {
        String pattern;
        try {
            // Obtener el patrón del mensaje para la clave dada
            pattern = bundle.getString(key);
        } catch (Exception e) {
            // Si la clave no se encuentra, se devuelve un mensaje de error
            pattern = "???" + key + "???";
        }
        // Formatear el mensaje con los argumentos dados
        return MessageFormat.format(pattern, args);
    }

    // Obtener el mensaje para el título de la ventana
    String titulo = Internationalization.getMessage("ventana.titulo");

    // Obtener el mensaje para el mensaje de éxito de inicio de sesión
    String mensajeExito = Internationalization.getMessage("mensaje.login.exito");

    // Cambiar al español
    Locale spanishLocale = new Locale("es");
    String mjExito = Internationalization.getMessage(spanishLocale, "mensaje.login.exito");

}
