package Ejercicio_06;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar por el nombre y la posición en la empresa
        System.out.println("¡Bienvenido al Chequeo de Salud Mental!");
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Por favor, ingresa tu puesto en la empresa: ");
        String posicion = scanner.nextLine();

        // Preguntar cómo se siente el usuario
        System.out.println("¿Cómo te sientes hoy?");
        System.out.println("1. Bien");
        System.out.println("2. Regular");
        System.out.println("3. Mal");
        int animo = obtenerOpcionUsuario(scanner);

        // Preguntar sobre el nivel de estrés
        System.out.println("¿Cómo calificarías tu nivel de estrés?");
        System.out.println("1. Bajo");
        System.out.println("2. Medio");
        System.out.println("3. Alto");
        int estres = obtenerOpcionUsuario(scanner);

        // Preguntar sobre la calidad del sueño
        System.out.println("¿Cómo calificarías la calidad de tu sueño?");
        System.out.println("1. Buena");
        System.out.println("2. Regular");
        System.out.println("3. Mala");
        int sueno = obtenerOpcionUsuario(scanner);

        // Preguntar sobre el apetito
        System.out.println("¿Cómo está tu apetito?");
        System.out.println("1. Bueno");
        System.out.println("2. Regular");
        System.out.println("3. Malo");
        int apetito = obtenerOpcionUsuario(scanner);

        // Preguntar sobre la motivación
        System.out.println("¿Cómo calificarías tu nivel de motivación?");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Baja");
        int motivacion = obtenerOpcionUsuario(scanner);

        // Preguntar sobre la interacción social
        System.out.println("¿Con qué frecuencia interactúas con otras personas?");
        System.out.println("1. Frecuentemente");
        System.out.println("2. A veces");
        System.out.println("3. Casi nunca");
        int interaccionSocial = obtenerOpcionUsuario(scanner);

        // Generar un mensaje basado en las respuestas
        String resultado = obtenerConsejoSaludMental(animo, estres, sueno, apetito, motivacion, interaccionSocial);

        // Mostrar los resultados al usuario
        System.out.println("\nResultados del Chequeo de Salud Mental:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: " + posicion);
        System.out.println(resultado);
        
        scanner.close();
    }

    // Función para proporcionar consejo basado en las respuestas
    private static String obtenerConsejoSaludMental(int animo, int estres, int sueno, int apetito, int motivacion, int interaccionSocial) {
        int puntaje = 0;

        // Evaluar cada respuesta y calcular el puntaje
        puntaje += evaluarRespuesta(animo);
        puntaje += evaluarRespuesta(estres);
        puntaje += evaluarRespuesta(sueno);
        puntaje += evaluarRespuesta(apetito);
        puntaje += evaluarRespuesta(motivacion);
        puntaje += evaluarRespuesta(interaccionSocial);

        // Proporcionar el consejo basado en el puntaje
        if (puntaje >= 12) {
            return "Parece que estás atravesando un momento difícil. Es importante buscar ayuda de un profesional de la salud mental.";
        } else if (puntaje >= 7) {
            return "Tal vez te sientas un poco abrumado. Tómate un tiempo para relajarte y practicar el autocuidado.";
        } else {
            return "Parece que te encuentras bien. ¡Sigue manteniendo un equilibrio saludable en tu vida!";
        }
    }

    // Función para evaluar la respuesta del usuario
    private static int evaluarRespuesta(int opcion) {
        if (opcion == 3) {
            return 3; // Caso peor (mal ánimo, alto estrés, mala calidad de sueño, etc.)
        } else if (opcion == 2) {
            return 2; // Caso intermedio
        } else {
            return 1; // Mejor caso
        }
    }

    // Función para obtener una opción válida del usuario
    private static int obtenerOpcionUsuario(Scanner scanner) {
        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            System.out.print("Ingresa tu opción (1, 2 o 3): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                scanner.next(); // Limpiar entrada inválida
            }
        }
        return opcion;
    }
}
