/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utp.puestoventa;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ServicioListaProductos {
     public List<Productos> obtenerProductos() {
        // Lista que almacenará los productos obtenidos
        List<Productos> listaProductos = new ArrayList<>();

        try {
            // Configurar la conexión HTTP
            URL url = new URL("https://serviciosargos.com/sistemas/tallerprogramacion/listaproductos.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST"); // Definir método POST
            connection.setRequestProperty("Content-Type", "application/json"); // Tipo de contenido JSON
            connection.setDoOutput(true); // Permitir envío de datos

            // Datos que se enviarán en la solicitud HTTP
            String datos = "{\"llave\":\"jd83d8sjdssfbg\"}";
            try (OutputStream os = connection.getOutputStream()) {
                os.write(datos.getBytes()); // Escribir los datos en la solicitud
                os.flush(); // Enviar los datos
            }

            // Leer la respuesta del servidor
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // Si la conexión fue exitosa
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Construir la respuesta como un String
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }

                // Procesar la respuesta JSON
                JSONArray jsonArray = new JSONArray(response.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    // Crear un objeto Productos para cada elemento del JSON
                    Productos producto = new Productos();
                    
                    producto.setId(jsonObject.getString("Id"));
                    producto.setNombre(jsonObject.getString("Nombre"));
                    producto.setCategoriaId(jsonObject.getString("CategoriaId"));
                    producto.setUnidadMedida(jsonObject.getString("UnidadMedida"));
                    producto.setPrecioUnidad(jsonObject.getDouble("PrecioUnidad"));
                    producto.setFechaVencimiento(jsonObject.getString("FechaVencimiento"));
                    producto.setStock(jsonObject.getInt("Stock"));
                    producto.setProveedor(jsonObject.getString("Proveedor"));

                    // Agregar el producto a la lista
                    listaProductos.add(producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir errores si los hay
        }

        // Retornar la lista de productos obtenida
        return listaProductos;
    }
}
