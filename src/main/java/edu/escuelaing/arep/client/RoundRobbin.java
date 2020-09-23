package edu.escuelaing.arep.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Propiedades de la clase RoundRobbin
 */
public class RoundRobbin {
    private String[] puertos;
    private int numeroServidor;
    private String url;

    /**
     * Constructor de la clase
     */
    public RoundRobbin(){
        puertos = new String[]{"4570", "4571", "4572"};
        numeroServidor = 0;
    }

    /**
     * Método encargado de manejar la petición de consulta
     * @return variable de tipo String
     * @throws UnirestException
     */
    public String find() throws UnirestException {
        HttpResponse<String> apiResponse = Unirest.get(url+":"+puertos[numeroServidor]+"/find").asString();
        return apiResponse.getBody();
    }

    /**
     * Método encargado de manejar la petición de inserción
     * @param dato de tipo String
     * @return variable de tipo String
     * @throws UnirestException
     */
    public String save(String dato) throws UnirestException{
        HttpResponse<String> apiResponse = Unirest.post(url+":"+puertos[numeroServidor]+"/save")
                .body(dato)
                .asString();

        return apiResponse.getBody();
    }
}
