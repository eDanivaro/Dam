package ejercicio2;

import java.util.*;

/**
 *
 * @author alumnoinfo
 */
public class DatosCiudades {
    
    int filas=4;
    int columnas=6;
    ArrayList<String> ciudades = new ArrayList<>();
    int[][] datos = new int[filas][columnas];

    public DatosCiudades(){
        this.ciudades= new ArrayList<>();
        this.datos=new int[0][0];
    }
    
    public DatosCiudades(ArrayList<String> listaCiudades) {
        int nFilas = 4;
        datos = new int[nFilas][ciudades.size()];
        
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                datos[i][j] = (int)(Math.random()*11+6);
            }
        }
    }
    
    public void muestraDatos(int [][] m){
        m = datos;
        for (int i = 0; i < m.length; i++) {
            ciudades.get(i).toUpperCase();
        }
        for (int i = 0; i < m.length; i++) {
            System.out.println("DATOS"+1);
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%4d",m[i][j]);
            }
            System.out.println("");
        }
    }
    
    private int [][] obtenerSumas(int[][]datos){
        int [][] sFilas = new int[datos.length][datos.length];
        for (int i = 0; i < 10; i++) {
            
        }
        return null;
    }
    
    public void visualizarTodo(){
        muestraDatos(datos);
        obtenerSumas(datos);
        
//        for(int d : datos){
//            
//        }
    }
    
}
