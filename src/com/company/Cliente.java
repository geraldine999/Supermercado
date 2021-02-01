package com.company;

import java.time.LocalDate;

public class Cliente<totalCompra> {
    private String nombre;
    private Boolean jubilado;
    private LocalDate fechaDeCumpleanios;
    private Carrito carrito;

    public Cliente(String nombre, Boolean jubilado, LocalDate fechaDeCumpleanios, Carrito carrito) {
        this.nombre = nombre;
        this.jubilado = jubilado;
        this.fechaDeCumpleanios = fechaDeCumpleanios;
        this.carrito =carrito;
    }

    public void agregarProductoalCarrito(Producto producto, Integer cantidad){
        carrito.agregarProducto(producto, cantidad);
        producto.setStock(producto.getStock()- cantidad);
        //que pasa si el stock queda en negativo?
    }

    public void modificarCantidadDeUnProducto(Producto productoAModificar, Integer nuevaCantidad){
        for (int i = 0; i < carrito.getProductos().size(); i++) {
            if(carrito.getProductos().get(i) == productoAModificar){
                carrito.getCantidades().set(i, nuevaCantidad);
                productoAModificar.setStock(productoAModificar.getStock()+(carrito.getCantidades().get(i)-nuevaCantidad));

            }
        }


    }

    public void eliminarProducto(Producto productoAEliminar){
        for(int i = 0; i< carrito.getProductos().size(); i ++){
            if(carrito.getProductos().get(i) == productoAEliminar){
                carrito.getProductos().remove(i);
                productoAEliminar.setStock(productoAEliminar.getStock() + carrito.getCantidades().get(i));
                carrito.getCantidades().remove(i);
            }
        }

    }

    public Double informarTotalCompra(){
        Double totalCompra = 0.0;
        totalCompra = carrito.sumarTotales();

        if(jubilado){
            totalCompra -= totalCompra* 0.15;
        }

        LocalDate hoy = LocalDate.now();
        int esteAnio = hoy.getYear();
        int mesCumple = fechaDeCumpleanios.getMonthValue();
        int diaCumple = fechaDeCumpleanios.getDayOfMonth();
        Boolean cumpleAnios = hoy.equals(LocalDate.of(esteAnio, mesCumple, diaCumple));

        if(cumpleAnios)
            totalCompra -= totalCompra * 0.10;

        return totalCompra;
    }





}
