package com.aluracursos.challenge.principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        String monedaBase = " ";
        String monedaConvertir = "";
        double monto = 0;

        ConsultaServidor consulta = new ConsultaServidor();


        while (true) {
            imprimirAsteriscos(41);

            System.out.println(" Sea bienvenid@ al conversor de moneda :) ");
            System.out.println();
            String menu = """
                    1 - Dolar =>> Peso argentino
                    2 - Peso argentino =>> Dolar
                    3 - Dólar =>> Real Brasileño
                    4 - Real Brasileño =>> Dólar
                    5 - Dólar =>> Soles Peruano
                    6 - Soles Peruano =>> Dolar
                    7 - Salir
                    """;
            System.out.println(menu);
            System.out.println(" Elija una opción válida: ");
            imprimirAsteriscos(41);

            try {
                opcion = lectura.nextInt();

                boolean opcionValida = true;
                switch (opcion) {
                    case 1 -> {
                        monedaBase = "USD";
                        monedaConvertir = "ARS";
                    }
                    case 2 -> {
                        monedaBase = "ARS";
                        monedaConvertir = "USD";
                    }
                    case 3 -> {
                        monedaBase = "USD";
                        monedaConvertir = "BRL";
                    }
                    case 4 -> {
                        monedaBase = "BRL";
                        monedaConvertir = "USD";
                    }
                    case 5 -> {
                        monedaBase = "USD";
                        monedaConvertir = "PEN";
                    }
                    case 6 -> {
                        monedaBase = "PEN";
                        monedaConvertir = "USD";
                    }
                    case 7 -> {
                        System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                        return;
                    }
                    default -> {
                        System.out.println("Opción inválida");
                        opcionValida = false;
                    }
                }

                if (opcionValida) {
                    System.out.println("Estás convirtiendo " + monedaBase + " a " + monedaConvertir);
                    System.out.print("Ingrese el monto que deseas convertir: ");
                    monto = lectura.nextInt();

                    Moneda moneda = consulta.buscarMonedas(monedaBase, monedaConvertir, monto);
                    imprimirAsteriscos(41);
                    System.out.println("Vas a convertir con el valor de mercado de: " + moneda.conversion_rate());
                    System.out.println("El valor de " + monto + " " + monedaBase + " equivale a " + moneda.conversion_result() + " " + monedaConvertir);
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese solo números enteros para la opción.");
                lectura.nextLine(); // Limpiar el buffer de entrada
            }



        }
    }

    public static void imprimirAsteriscos(int cantidadAsteriscos) {
        System.out.println("*".repeat(cantidadAsteriscos));
    }
}
