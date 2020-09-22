package edu.escuelaing.arep.client;

import static spark.Spark.*;


public class Client {

    public static void main(String[] args){
        port(getPort());
        get("/", (req,res) -> pagina());
        get("/add",(req,res) -> "Vamos a agregar");
        get("/result",(req,res) -> getDatos());
    }

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

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
