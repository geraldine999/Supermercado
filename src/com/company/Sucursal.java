package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private List<Producto> productos;
    private List <Cliente> clientes;

    public Sucursal(List<Producto> productos) {
        this.productos = productos;
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void listarProductosDisponibles(){
        System.out.println("Los productos en stock de la sucursal son");
        for (Producto p: productos
             ) {
            if(p.getStock() > 0){
                System.out.println(p.getNombre());
            }


        }
    }

    public void listarProductosPorCategoria(String categoria){
        System.out.println("Los productos de la categoria "+ categoria + " son los siguientes:");
        for (Producto p: productos
             ) {
            if(p.getSeccion() == categoria){
                System.out.println(p.getNombre());
            }

        }

    }

    public void consultarDescuentoAplicadoAUnCliente(Cliente cliente){
        Double descuentoAplicado = 0.0;
        for (Cliente c : clientes
             ) {
            if(cliente == c){
                System.out.println("El descuento aplicado al cliente "+ c.getNombre() + " fue de "+ c.getDescuentoAplicado());
                if(c.getDescuentoAplicado() == 0.10){
                    System.out.println("Por ser su cumpleanios");
                }if(c.getDescuentoAplicado() == 0.15){
                    System.out.println("Por ser jubilado");
                }else{
                    System.out.println("Por ser jubilado y ser su cumpleanios");
                }
            }

        }
    }

}
