package edu.escuelaing.arep.server;

import edu.escuelaing.arep.server.DBConecction;
import org.json.JSONObject;
import spark.Request;

import static spark.Spark.*;

/**
 * Propiedades de la clase LogServices
 */
public class LogService {

    public static void main(String[] args) {
        port(getPort());

        get("/find",(req,res) ->  select());

        post("/save",(req, res) -> insert(new JSONObject(req.body())));
    }

    /**
     * Método encargado de conectarse a dbconectcion para agregar un nuevo dato
     * @param valor de tipo String que contiene el valor a agregar
     * @return variable de tipo JSONObject
     */
    private static JSONObject insert(JSONObject valor) {
        System.out.println(valor);
        DBConecction dbConecction = new DBConecction();
        JSONObject respuesta;

        respuesta = dbConecction.insert(valor.toString());
        System.out.println(respuesta);
        return respuesta;
    }

    /**
     * Método encargado de conectarse a dbconectcion para consultar los datos
     * @return variable de tipo JSONObject
     */
    private static JSONObject select() {
        DBConecction dbConecction = new DBConecction();
        JSONObject respuesta;

        respuesta = dbConecction.select();
        System.out.println(respuesta);
        return respuesta;
    }

    /**
     * Método que especifica el puerto de la clase
     * @return variable de tipo int con el valor del puerto
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4560;
    }
}
