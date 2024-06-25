package org.conversor_divisas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;

        while (!exit) {
            System.out.println("Bienvenido al conversor de divisas:");
            System.out.println("1. Convertir divisas");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        convertirDivisas(reader);
                        break;
                    case "2":
                        exit = true;
                        break;
                    default:
                        System.out.println("La opción no es válida. Debe seleccionar otra nuevamente.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Programa terminado.");
    }

    private static void convertirDivisas(BufferedReader reader) throws IOException {
        System.out.println("Ingrese la cantidad a convertir:");
        double amount = Double.parseDouble(reader.readLine());

        System.out.println("Ingrese la divisa de origen (ej. USD):");
        String fromCurrency = reader.readLine().toUpperCase();

        System.out.println("Ingrese la divisa de destino (ej. EUR):");
        String toCurrency = reader.readLine().toUpperCase();

        try {
            double convertedAmount = CurrencyConverter.convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IOException e) {
            System.out.println("Error al convertir divisas. Por favor, verifique las divisas ingresadas.");
        }
    }
}

