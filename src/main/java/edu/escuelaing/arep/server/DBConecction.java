package edu.escuelaing.arep.server;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import edu.escuelaing.arep.server.model.Archivo;
import org.bson.Document;
import org.json.JSONObject;

import java.util.Iterator;


/**
 * Propiedades de la case DBConecction
 */
public class DBConecction {

    private final static String host = "ec2-54-197-36-72.compute-1.amazonaws.com";

    /**
     * Método encargado de consultar los últimos 10 registros de la base de datos
     * @return de tipo JSONObject
     */
    public JSONObject select() {
        JSONObject respuesta = new JSONObject();
        try{
            MongoClient mongo = new MongoClient(host, 27017);
            MongoIterable<String> mongoIterable = mongo.listDatabaseNames();
            MongoDatabase db = mongo.getDatabase("lab");
            MongoCollection<Document> collection = db.getCollection("lab");
            FindIterable<Document> datos = collection.find();
            {
                int contador = 1;
                for(Document iterador: datos){
                    String id = String.valueOf(contador);
                    respuesta.put(id,"Nombre: "+iterador.get("nombre")+",Fecha: "+iterador.get("fecha"));
                    contador++;
                }
                System.out.println(contador);
                if(contador >10)
                {
                    Iterator<String> datosConsulta = respuesta.keys();
                    int diferencia = contador - 10;
                    while (datosConsulta.hasNext() && diferencia >0)
                    {
                        respuesta.remove(String.valueOf(diferencia));
                        diferencia--;
                    }
                }
            }
        }
        catch (Exception e) {
            respuesta = new JSONObject();
            respuesta.put("respuesta","Error en la consulta de datos");
        }
        return respuesta;
    }

    /**
     * Método encargado de insertar un nuevo dato a la base ed datos
     * @param dato de tipo String que contiene el nuevo valor a agregar
     * @return JSSONObject
     */
    public JSONObject insert(String dato) {
        JSONObject respuesta = new JSONObject();
        try {
            MongoClient mongo = new MongoClient(host, 27017);
            MongoDatabase db = mongo.getDatabase("lab");
            MongoCollection<Document> collection = db.getCollection("lab");

            Document document = new Document();
            Archivo archivo = new Archivo(dato);
            document.append("nombre",archivo.getNombre());
            document.append("fecha", archivo.getFecha());
            collection.insertOne(document);
            respuesta.put("respuesta", "Insersión correcta");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error de insersión");
        }
        return respuesta;
    }

}

