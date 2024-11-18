/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utp.puestoventa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */

public class ServicioLogeo {
    public boolean enviarCredenciales(Credencial credencial) throws MalformedURLException, IOException, Exception  {
         // URL de la página PHP
        URL miUrl = new URL("https://serviciosargos.com/sistemas/tallerprogramacion/logeo.php");

        // Configuración de la conexión
        HttpURLConnection connection = (HttpURLConnection) miUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // Datos que se enviarán en el cuerpo de la solicitud
        String parametros = "&llave=jfg73hd83hjd9wjd783jf8" + "&user=" + credencial.getUsuario() + "&pass=" + credencial.getContraseña();

        // Enviar los datos
        try (OutputStream os = connection.getOutputStream()) {
            os.write(parametros.getBytes());
            os.flush();
        }
        
        // Leer la respuesta
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Procesar el JSON de la respuesta
            JSONObject jsonResponse = new JSONObject(response.toString());
            String respuesta = jsonResponse.getString("Estado");

            return "OK".equals(respuesta);  // Verifica si la respuesta es "ok"
        } else {
            throw new Exception("Error en la conexión: Código de respuesta " + responseCode);
        }
        
        
        
        
      
    }
    
}
