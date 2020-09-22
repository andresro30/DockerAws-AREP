package edu.escuelaing.arep.server;

import edu.escuelaing.arep.server.DBConecction;
import org.json.JSONObject;
import spark.Request;

import static spark.Spark.*;

public class LogService {

    public static void main(String[] args) {
        port(getPort());

        get("/find",(req,res) ->  select());

        post("/save",(req, res) -> insert(new JSONObject(req.body())));
    }

    private static JSONObject insert(JSONObject valor) {
        System.out.println(valor);
        DBConecction dbConecction = new DBConecction();
        JSONObject respuesta;

        respuesta = dbConecction.insert(valor.toString());
        System.out.println(respuesta);
        return respuesta;
    }

    private static JSONObject select() {
        DBConecction dbConecction = new DBConecction();
        JSONObject respuesta;

        respuesta = dbConecction.select();
        System.out.println(respuesta);
        return respuesta;
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4560;
    }
}
