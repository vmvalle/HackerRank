package codinginterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;

/**
 * Created by Víctor on 26/09/2017.
 */
public class ArraysLeftRotation {

    /**
     * Rota un array tantas posiciones como tenga el parámetro numRotation
     * @param array
     * @param length
     * @param numRotation
     * @return array con las posiciones rotadas
     */
    static int[] leftRotation(int array[], int length, int numRotation){
        int[] secondArray = Arrays.copyOfRange(array, 0, numRotation);
        int[] firstArray = Arrays.copyOfRange(array, numRotation, length);
        return IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray();
    }

    /**
     * Imprime el array de números separados por espacios en blanco
     * @param array
     * @return
     */
    static String arrayToString(int array[]) {
        String result = "";
        for(int a : array){
            result += a + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Número de elementos del array
        int k = in.nextInt(); // Número de rotaciones
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Comenzamos...
        if(k < n) {
            // Rotación a la izquierda
            System.out.println(arrayToString(leftRotation(a, n, k)));
        } else if ( k > n) {
            // Calculamos la rotación a la izquierda mínima
            System.out.println(arrayToString(leftRotation(a, n, k - n)));
        } else {
            // Si k == n no rotamos
            System.out.println(arrayToString(a));
        }
    }
}
