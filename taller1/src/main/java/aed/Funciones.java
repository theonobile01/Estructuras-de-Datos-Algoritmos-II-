package aed;
import java.lang.Math;


class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    boolean esPar(int n) {
        return (n % 2 == 0);
    }

    boolean esBisiesto(int n) {
        return (((n % 4 == 0) && (n % 100 != 0))) || (n % 400 == 0);
    }

    int factorialIterativo(int n) {
        int res = 1;
        while (n !=0){
            res = res * n;
            n -= 1;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n == 0){
            return res;
        }
        else{
            res = n * factorialRecursivo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        int cantDivisores = 0;
        int divisor = 1;
        while (divisor <= n) {
            if (n % divisor == 0) {
                cantDivisores += 1;
            }
            divisor +=1;
        }
        return (cantDivisores == 2);
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int x : numeros){
            res = res + x;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int posicion = 0;
        while (posicion < numeros.length) {
            if (numeros[posicion] == buscado) {
                return posicion;
            }
            posicion +=1;
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int x : numeros) {
            if (esPrimo(x)==true){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int x : numeros){
            if (x % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        int i = 0;
        if (s1.length() <= s2.length()){
            while (i < s1.length()){
                if (s1.charAt(i)!= s2.charAt(i)){
                    return false;
                }
            i +=1;
            }
        return true;
        }
    return false;
    }

    String revertir (String s){
        String reverso = "";
        for (int i = s.length() -1;i > -1; i--){
            reverso += s.charAt(i);
        }
        return reverso;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        s2 = revertir(s2);
        s1 = revertir (s1);
        return esPrefijo(s1, s2);
    }

}
