package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //metodo static, pertenece a la clase y no a los objetos creados a partir de ella.


        List<Producto> productos = new ArrayList<>();

        Producto protectorSolar = new Producto("Protector Sola", "--", 678.9, "Perfumeria", 56);
        Producto banana = new Producto("Banana", "--", 5.0, "Comida", 98);

        productos.add(protectorSolar);
        productos.add(banana);


            for (Producto p : productos) {
                System.out.println("Nombre: " + p.getNombre() + " Precio: " + p.getPrecioUnitario() + " Stock: " + p.getStock());
            }


    }
}
