/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utp.puestoventa;

/**
 *
 * @author Admin
 */
public class Productos {
     // Atributos de la clase, corresponden a las columnas del JSON
    private String id; // Identificador único del producto
    private String nombre; // Nombre del producto
    private String categoriaId; // ID de la categoría del producto
    private String unidadMedida; // Unidad de medida (ejemplo: Kg, unidad)
    private double precioUnidad; // Precio por unidad
    private String fechaVencimiento; // Fecha de vencimiento
    private int stock; // Cantidad disponible en inventario
    private String proveedor; // Nombre del proveedor

    // Métodos getter y setter para cada atributo
    public String getId() {
        return id; // Retorna el ID del producto
    }

    public void setId(String id) {
        this.id = id; // Asigna el ID del producto
    }

    public String getNombre() {
        return nombre; // Retorna el nombre del producto
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Asigna el nombre del producto
    }

    public String getCategoriaId() {
        return categoriaId; // Retorna el ID de la categoría
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId; // Asigna el ID de la categoría
    }

    public String getUnidadMedida() {
        return unidadMedida; // Retorna la unidad de medida
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida; // Asigna la unidad de medida
    }

    public double getPrecioUnidad() {
        return precioUnidad; // Retorna el precio por unidad
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad; // Asigna el precio por unidad
    }

    public String getFechaVencimiento() {
        return fechaVencimiento; // Retorna la fecha de vencimiento
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento; // Asigna la fecha de vencimiento
    }

    public int getStock() {
        return stock; // Retorna el stock disponible
    }

    public void setStock(int stock) {
        this.stock = stock; // Asigna el stock disponible
    }

    public String getProveedor() {
        return proveedor; // Retorna el nombre del proveedor
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor; // Asigna el nombre del proveedor
    }
}
