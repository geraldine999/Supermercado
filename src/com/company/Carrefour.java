package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrefour {

    public static void main(String[] args) {

        //NOTA: metodo static, pertenece a la clase y no a los objetos creados a partir de ella.

        //creo productos
        List<Producto> productos = new ArrayList<>();

        Producto protectorSolar = new Producto("Protector Sola", "--", 678.9, "Perfumeria", 56);
        Producto banana = new Producto("Banana", "--", 5.0, "Comida", 98);

        productos.add(protectorSolar);
        productos.add(banana);


        //creo una sucursal
        Sucursal vicenteLopez = new Sucursal(productos);

        //creo un carrito para el cliente
        Carrito carritoPedro = new Carrito();

        //creo un cliente que entro a la sucursal de vicente lopez
        Cliente pedro = new Cliente("Pedro", true, LocalDate.of(1953, 2, 8), carritoPedro, vicenteLopez );

        //Pedro agrega productos al carrito, modifica la cantidad de protectores solares y deja las bananas
        pedro.agregarProductoalCarrito(protectorSolar, 45);
        pedro.agregarProductoalCarrito(banana, 34);

        pedro.modificarCantidadDeUnProducto(protectorSolar, 55);

        pedro.eliminarProducto(banana);

        //informar el precio total de la compra
        System.out.println("El total de la compra de Pedro es de "+pedro.informarTotalCompra());

        //listar productos disponibles de la sucursal Vicente Lopez
        vicenteLopez.listarProductosDisponibles();

        //listar productos de la categoria perfumeria
        vicenteLopez.listarProductosPorCategoria("Perfumeria");

        //consulto el descuento aplicado al cliente pedro
        vicenteLopez.consultarDescuentoAplicadoAUnCliente(pedro);

        //cliente pedro consulta cual seria el total sin el descuento que se le aplico
        System.out.println("El total de pedro sin el descuento seria de "+ pedro.getTotalCompraSinDescuento());










    }
}
