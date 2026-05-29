package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Instancias de categorias
        Categoria burritos = new Categoria(
                1,
                false, LocalDateTime.now(),
                "Burritos",
                "Burritos tradicionales");

        Categoria gorditas = new Categoria(
                2,
                false, LocalDateTime.now(),
                "Gorditas",
                "Gorditas estilo CDMX");

        Categoria quesadillas = new Categoria(
                3,
                false, LocalDateTime.now(),
                "Quesadillas",
                "Quesadillas tradicionales Mexicanas");

        //Se muestran las categorías por pantalla
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Instanciar 3 categorías.\n");
        System.out.println(burritos);
        System.out.println(gorditas);
        System.out.println(quesadillas);
        //========================================================================================

        //Instancias de productos

        //Primero se crea un HashSet que luego mostrará el listado de productos
        Set<Producto> listadoProductos = new HashSet<>();

        //Se instancian los productos
        Producto burritoTex = new Producto(
                1,
                false, LocalDateTime.now(),
                "Burrito Tex",
                6000.0,
                "Burrito estilo TexMex de maíz, arroz, frijoles y cilantro",
                20,
                "/assets/burrito1.jpg",
                true, burritos);

        listadoProductos.add(burritoTex);

        Producto burritoRaw = new Producto(
                2,
                false, LocalDateTime.now(),
                "Raw Burrito",
                6000.0,
                "Burrito de vegetales frescos con, aguacate, tomate, lechuga," +
                        "cebolla morada y cilantro",
                15,
                "/assets/burrito2.jpg",
                true, burritos);

        listadoProductos.add(burritoRaw);

        Producto burritoNotChicken = new Producto(
                3,
                false, LocalDateTime.now(),
                "Not Chicken Burrito",
                6800.0,
                "Burrito de not pollo, lechuga, tomate, choclo y queso",
                10,
                "/assets/burrito3.jpg",
                true, burritos);

        listadoProductos.add(burritoNotChicken);

        Producto gorditasPuebla = new Producto(
                4,
                false, LocalDateTime.now(),
                "Gorditas Puebla",
                10000.0,
                "Masa de maíz rellena con frijoles, lechuga, queso Oaxaca" +
                        "y pico de gallo",
                0,
                "/assets/gorditas1.jpg",
                false, gorditas);

        listadoProductos.add(gorditasPuebla);

        Producto gorditasGuanajuato = new Producto(
                5,
                false, LocalDateTime.now(),
                "Gorditas Guanajuato",
                10000.0,
                "Masa de maíz rellena con frijoles, queso panela, queso manchego" +
                        "y chile habanero",
                100,
                "/assets/gorditas2.jpg",
                true, gorditas);

        listadoProductos.add(gorditasGuanajuato);

        Producto gorditasTepoz = new Producto(
                6,
                false, LocalDateTime.now(),
                "Gorditas Tepoz",
                12000.0,
                "Masa de maíz rellena con tomate, not carne, aguacate y cebolla morada",
                40,
                "/assets/gorditas3.jpg",
                true, gorditas);

        listadoProductos.add(gorditasTepoz);

        Producto quesadillasNorte = new Producto(
                7,
                false, LocalDateTime.now(),
                "Quesadillas Norteñas",
                7000.0,
                "Tortilla de trigo rellena de frijoles, tomate, queso cheddar," +
                        "queso manchego y cilantro",
                60,
                "/assets/quesadillas1.jpg",
                true, quesadillas);

        listadoProductos.add(quesadillasNorte);

        Producto quesadillasChiapanecas = new Producto(
                8,
                false, LocalDateTime.now(),
                "Quesadillas Chiapanecas",
                7000.0,
                "Tortilla de maiz rellena de choclo, tomate, zucchini," +
                        "queso oaxaca y cilantro",
                20,
                "/assets/quesadillas2.jpg",
                true, quesadillas);

        listadoProductos.add(quesadillasChiapanecas);

        Producto quesadillasSincro = new Producto(
                9,
                false, LocalDateTime.now(),
                "Quesadillas Sincronizadas",
                7000.0,
                "Tortilla de maiz rellena de queso y jamon de seitán",
                18,
                "/assets/quesadillas3.jpg",
                true, quesadillas);

        listadoProductos.add(quesadillasSincro);

        Producto quesadillasCosta = new Producto(
                10,
                false, LocalDateTime.now(),
                "Quesadillas Costeñas",
                7500.0,
                "Tortilla de maiz azul rellena de queso oaxaca, cebolla," +
                        "tomate y queso azul",
                10,
                "/assets/quesadillas4.jpg",
                true, quesadillas);

        listadoProductos.add(quesadillasCosta);

        //Se vuelven a mostrar las categorías para demostrar que los productos fueron asignados
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Se muestran las categorías con la cantidad de productos asignados.\n");
        System.out.println(burritos);
        System.out.println(gorditas);
        System.out.println(quesadillas);

        //Se muestra por consola un producto disponible y otro no disponible
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Utilizar toString para mostrar por consola un producto\n");
        System.out.println("Producto disponible:\n");
        System.out.println(quesadillasCosta);
        System.out.println("Producto no disponible:\n");
        System.out.println(gorditasPuebla);

        //Se muestra por consola el listado de productos
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Mostrar la lista de productos cargados\n");
        for (Producto prod : listadoProductos) {
            System.out.println(prod);
        }

        //========================================================================================

        //Instancias de usuarios

        //Primero se crea un HashSet que luego utilizaremos para buscar el usuario con más pedidos
        Set<Usuario> listadoUsuarios = new HashSet<>();

        //Se instancian los usuarios
        Usuario u1 = new Usuario(
                1,
                false, LocalDateTime.now(),
                "Micaela",
                "Alterio",
                "micaela@mail.com",
                "1132334432",
                "1234", Rol.ADMIN);

        listadoUsuarios.add(u1);

        Usuario u2 = new Usuario(
                2,
                false, LocalDateTime.now(),
                "Diego Nicolás",
                "Díaz Valiero",
                "diego@mail.com",
                "1133977765",
                "4321", Rol.USUARIO);

        listadoUsuarios.add(u2);

        //Se muestran por consola los usuarios creados
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Instanciar 2 usuarios.\n");
        System.out.println(u1);
        System.out.println(u2);

        //=========================================================================================

        //Instancias de pedidos
        Pedido ped1 = new Pedido(
                1,
                false, LocalDateTime.now(),
                Estado.CONFIRMADO,
                FormaPago.TRANSFERENCIA, u2);

        ped1.addDetallePedido(3, burritoTex);
        ped1.addDetallePedido(1, quesadillasChiapanecas);

        Pedido ped2 = new Pedido(
                2,
                false, LocalDateTime.now(),
                Estado.PENDIENTE,
                FormaPago.TARJETA, u2);

        ped2.addDetallePedido(4, gorditasTepoz);
        ped2.addDetallePedido(2, quesadillasSincro);

        Pedido ped3 = new Pedido(
                3,
                false, LocalDateTime.now(),
                Estado.TERMINADO,
                FormaPago.EFECTIVO, u1);

        ped3.addDetallePedido(5, burritoNotChicken);
        ped3.addDetallePedido(2, gorditasGuanajuato);
        ped3.addDetallePedido(1, quesadillasNorte);

        //Se muestran por consola los pedidos creados
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Instanciar 3 Pedidos con al menos 2 detalles por cada uno).\n");
        System.out.println(ped1);
        System.out.println(ped2);
        System.out.println(ped3);

        //Se muestran por consola los pedidos del usuario que más pedidos posea
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Mostrar los pedidos del usuario que más pedidos posea.\n");

        Usuario usuarioMaxPedidos = null;
        int maxPedidos = -1;
        for (Usuario usu : listadoUsuarios) {
            if (usu.getPedidos() != null) {
                int cantPedidos = usu.getPedidos().size();

                if (cantPedidos > maxPedidos) {
                    maxPedidos = cantPedidos;
                    usuarioMaxPedidos = usu;
                }
            }
        }

        System.out.println("Usuario con más pedidos:\n" +
                usuarioMaxPedidos.getNombre()+ usuarioMaxPedidos.getApellido());
        System.out.println("Pedidos realizados:\n" + usuarioMaxPedidos.getPedidos().
                toString().replace("[", "").replace("]",
                        "").replace(", ", "\n"));

        //Instancia de producto nuevo con campos comparados en equals iguales a otro producto
        Producto quesadillasSur = new Producto(
                11,
                false, LocalDateTime.now(),
                "Quesadillas Norteñas",
                7500.0,
                "Tortilla de trigo rellena de lentejas, morrón, y queso manchego",
                65,
                "/assets/quesadillas1.jpg",
                true, quesadillas);

        listadoProductos.add(quesadillasSur);

        //Se muestra el producto instanciado
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Instancie un producto nuevo donde el/los campos comparados" +
                "en equals sean iguales.\n");
        System.out.println(quesadillasSur);

        //Se compara el producto con toda la colección y se muestra por consola
        boolean productoDuplicado = listadoProductos.contains(quesadillasSur);

        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Consigna: Compare esa instancia con toda la colección. " +
                "Mostrar resultados por pantalla.\n");

        if (productoDuplicado) {
            System.out.println("El producto cargado ya existe en la colección según la comparación " +
                    "con equals.");
        } else {
            System.out.println("No se han encontrado coincidencias en el HashSet del producto cargado.");
        }
    }
}