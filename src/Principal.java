import com.google.gson.Gson;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
        String menu = """
                _______________________________________________
                
                Sea bienvenido/a al conversor de moneda.
                \n        == MENU DE OPCIONES ==
                1.-\tPeso Mexicano\t-->\tPeso Argentino.
                2.-\tPeso Argentino\t-->\tPeso Mexicano.
                3.-\tPeso Mexicano\t-->\tReal Brasileño.
                4.-\tReal Brasileño\t-->\tPeso Mexicano.
                5.-\tPeso Mexicano\t-->\tPeso Colombiano.
                6.-\tPeso Colombiano\t-->\tPeso Mexicano.
                7.-\tSalir.
                _______________________________________________
                """;

        ConsultarAPI consulta = new ConsultarAPI();
        List<String> codigos = List.of(
            "MXN/ARS", "ARS/MXN", "MXN/BRL", "BRL/MXN", "MXN/COP", "COP/MXN"
        );

        Gson gson = new Gson();

        while (!salir) {
            try {
                // Menú principal
                System.out.println(menu);
                boolean entradaValida = false;

                // Validar opción
                while (!entradaValida) {
                    try {
                        System.out.print("Elija una opción:\t");
                        opcion = teclado.nextInt();
                        if (opcion >= 1 && opcion <= 7) {
                            entradaValida = true;
                        } else {
                            System.out.println("Entrada inválida. Solo números del 1 al 7.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Ingrese solo números.");
                        teclado.next(); // Limpiar entrada inválida
                    }
                }

                //Condición para salir de la app
                if (opcion == 7) {
                    salir = true;
                    break;
                }

                // Validar importe
                double importe = 0.0;
                entradaValida = false;
                while (!entradaValida) {
                    try {
                        System.out.print("Indique el importe que desea convertir: ");
                        importe = teclado.nextDouble();
                        if (importe > 0.0) {
                            entradaValida = true;
                        } else {
                            System.out.println("El importe debe ser mayor a 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Ingrese solo números.");
                        teclado.next(); // Limpiar entrada inválida
                    }
                }

                // Lógica de conversión
                Moneda moneda = consulta.convertirMoneda(codigos.get(opcion - 1), importe);

                // Serializar y deserializar usando GSON
                String json = gson.toJson(moneda);
                Moneda monedaDeserializada = gson.fromJson(json, Moneda.class);

                System.out.printf("El valor de %.2f [%s] equivale a %.2f [%s]%n",
                        importe,
                        monedaDeserializada.base_code(),
                        monedaDeserializada.conversion_result(),
                        monedaDeserializada.target_code()
                );

            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                e.printStackTrace(); // Para depurar el error
            }
        }

        System.out.println("\nEligieron la opción salir.\nFinalizando la app.");
        teclado.close();
    }
}
