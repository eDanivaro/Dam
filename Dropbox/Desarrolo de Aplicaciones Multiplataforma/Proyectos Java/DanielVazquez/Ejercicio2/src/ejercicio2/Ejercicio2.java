
package ejercicio2;
import java.util.*;
/**
 *
 * @author alumnoinfo
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String aux;
        int opcion;
        int n=4;
        
        int[][] datos = new int[n][n];
        
        Scanner sc = new Scanner(System.in);
        DatosCiudades d = new DatosCiudades();
        DatosCiudades[][]  ciudad ={};
        
            do {
                System.out.println("===========================");
                System.out.println("=====LISTA DE CIUDADES=====");
                System.out.println("1- Insertar Nombre");
                System.out.println("2- Eliminar Nombre");
                System.out.println("3- Terminar");
                System.out.println("");
                System.out.println("Escoge una opción");
                
                //opcion = sc.nextInt();
                //sc.nextLine();
        try {
                opcion = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Dato invalido");
                    opcion = 1;
                }
                switch (opcion) {
                    case 1:
                        // Petición de ciudades
                            System.out.println("Introduce el nombre de una ciudad.");
                            aux = sc.nextLine();
                            d.ciudades.add(aux.trim().substring(1, 4));
                            
                        for (int i = 0; i < d.ciudades.size(); i++) {
                            System.out.println("Introduce el nombre de una ciudad.");
                        }
                        break;
                    case 2:
                        // Ciudad a eliminar
                        System.out.println("Introduce el nombre que quieres eliminar de la lista");
                        aux = sc.nextLine();
                        for (DatosCiudades[] dc : ciudad) {
                            
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Has introducido un valor incorrecto");
                        System.out.println("");
                        System.out.println("");
                        break;
                }
            } while (opcion != 3);
        
    }
    
}
