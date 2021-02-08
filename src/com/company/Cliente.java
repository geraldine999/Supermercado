package com.company;

import java.time.LocalDate;

public class Cliente<totalCompra> {
    private String nombre;
    private Boolean jubilado;
    private LocalDate fechaDeCumpleanios;
    private Carrito carrito;
    private Sucursal sucursalALaQueEntro;
    private Double descuentoAplicado;
    private Double totalCompraSinDescuento;

    public Cliente(String nombre, Boolean jubilado, LocalDate fechaDeCumpleanios, Carrito carrito, Sucursal sucursalALaQueEntro) {
        this.nombre = nombre;
        this.jubilado = jubilado;
        this.fechaDeCumpleanios = fechaDeCumpleanios;
        this.carrito =carrito;
        this.sucursalALaQueEntro = sucursalALaQueEntro;
        sucursalALaQueEntro.getClientes().add(this); // se aniade el objeto Cliente a la lista de clientes de la sucursal
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
        totalCompraSinDescuento = totalCompra;

        LocalDate hoy = LocalDate.now();
        int esteAnio = hoy.getYear();
        int mesCumple = fechaDeCumpleanios.getMonthValue();
        int diaCumple = fechaDeCumpleanios.getDayOfMonth();
        Boolean cumpleAnios = hoy.equals(LocalDate.of(esteAnio, mesCumple, diaCumple));

        if(cumpleAnios && jubilado){
            descuentoAplicado = 0.25;
            totalCompra -= totalCompra * descuentoAplicado;
        }else if(cumpleAnios) {
            descuentoAplicado = 0.10;
            totalCompra -= totalCompra * descuentoAplicado;
        }else if(jubilado){
            descuentoAplicado = 0.15;
            totalCompra -= totalCompra* descuentoAplicado;
        }

        return totalCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getJubilado() {
        return jubilado;
    }

    public void setJubilado(Boolean jubilado) {
        this.jubilado = jubilado;
    }

    public LocalDate getFechaDeCumpleanios() {
        return fechaDeCumpleanios;
    }

    public void setFechaDeCumpleanios(LocalDate fechaDeCumpleanios) {
        this.fechaDeCumpleanios = fechaDeCumpleanios;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Sucursal getSucursalALaQueEntro() {
        return sucursalALaQueEntro;
    }

    public void setSucursalALaQueEntro(Sucursal sucursalALaQueEntro) {
        this.sucursalALaQueEntro = sucursalALaQueEntro;
    }

    public Double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(Double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public Double getTotalCompraSinDescuento() {
        return totalCompraSinDescuento;
    }
}
