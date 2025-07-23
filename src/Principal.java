import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;
        String menu = """
                _______________________________________________\
                
                Sea bienvenido/a al conversor de moneda.\
                            
                            == MENU ==
                1.-\tPeso Mexicano\t-->\tPeso Argentino.
                2.-\tPeso Argentino\t-->\tPeso Mexicano.
                3.-\tPeso Mexicano\t-->\tReal Brasileño.
                4.-\tReal Brasileño\t-->\tPeso Mexicano.
                5.-\tPeso Mexicano\t-->\tPeso Colombiano.
                6.-\tPeso Colombiano\t-->\tPeso Mexicano.
                7.-\tSalir.
                _______________________________________________\
                
                Elija una opción:\t
                """;
        ConsultarAPI consulta = new ConsultarAPI();
        double importe= 0.0;

        System.out.println(menu);
        opcion = Integer.valueOf(teclado.nextLine());
        System.out.println("Indique el importe a convertir:\t");
        importe = Double.valueOf(teclado.nextDouble());
        Moneda moneda = consulta.convertirMoneda(opcion, importe);
        System.out.println(moneda);
    }
}
