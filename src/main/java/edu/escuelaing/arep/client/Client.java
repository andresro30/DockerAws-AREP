package edu.escuelaing.arep.client;

import static spark.Spark.*;


/**
 * Propiedades de la clase Client
 */
public class Client {

    /**
     * Método principal de la clase
     * @param args de tipo String[]
     */
    public static void main(String[] args){
        port(getPort());
        get("/", (req,res) -> pagina());
        get("/add",(req,res) -> new RoundRobbin().find());
        get("/result",(req,res) -> getDatos());
    }

    /**
     * Método que carga la página principal de la aplicación
     * @return variable de tipo String
     */
    private static String pagina() {
        String outputLine = "<DOCTYPE html"
                + "<html>"
                + "<title> Client </title>"
                + "<body>"
                + "<h1>Bienvenido a DockerWebApp</h1>"
                + "<form action=\"/add\">"
                + "<p>Esta aplicación esta desplegada en un contenedor de docker y te permite ocnsultar datos de una base de datos MongoDB</p>"
                + "<p>Por favor sigue las siguientes recomendaiciones para usar de forma correcta la aplicación:</p>"
                + "<ol>"
                + "<li>Si deseas consultar los registros de la base de datos, da click en el botón consultar</li>"
                + "<li>Si deseas agregar un nuevo registro, escribe en el valor en el campo de texto y presiona el botón agregar</li>"
                + "</ol>"
                + "<br></br>"
                + "<label for=\"fdata\">Agregar datos:</label>"
                + "<input type=\"text\" id=\"fdata\" name=\"fdata\"><br><br>"
                + "<input type=\"submit\" value=\"submit\">"
                + "</form>"
                + "<form action=\"/result\">"
                + "<label for=\"fdata\">Consultar datos:</label>"
                + "<input type=\"submit\" value=\"submit\">"
                + "</body>"
                + "</html>";

        return outputLine;
    }

    /**
     * Método que carga la página de respuesta a una consulta
     * @return de tipo String
     */
    private static String getDatos() {
        String outputLine = "<DOCTYPE html"
                + "<html>"
                + "<title> Datos Consultados</title>"
                + "<body>"
                + "<h1>Datos Consultados</h1>"
                + "<h3> Aquí van los resultados</h3>"
                + "</body>"
                + "</html>";

        return outputLine;
    }

    /**
     * Método que especifica el puerto de la clase
     * @return variable de tipo int con el valor del puerto
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
