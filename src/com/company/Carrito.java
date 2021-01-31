package com.company;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
     private List<Producto> productos;
     private List <Integer> cantidades;

    public Carrito() {
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, Integer cantidad){
        productos.add(producto);
        cantidades.add(cantidad);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public Double sumarTotales(){
        Double sumaTotal = 0.0;
        for(int i= 0; i< productos.size(); i ++){
            sumaTotal += productos.get(i).getPrecioUnitario() * cantidades.get(i);
        }
        return sumaTotal;
    }
}
