package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    Nodo primero;
    Nodo ultimo;
    int largo;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T v){this.valor = v;}

    }

    public ListaEnlazada() {
        this.primero = new Nodo(null); // estoy usando el constructor nodo de la clase nodo
        this.ultimo = new Nodo(null); //`""
        this.largo = 0;
    }

    public int longitud() {
        return this.largo;
    }

    public void agregarAdelante(T elem) {
        
        Nodo nuevoNodo = new Nodo(elem);
        if (this.primero.valor == null){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;   // debo definir el ultimo elemento. Porque si no en la recursion de agregar atras el ultimo es null y o estoy sobre escribiendo
            nuevoNodo.siguiente = new Nodo(null); // cuando no hay elemento. el nuevo elemento apunta a dos nodos nulos ( null <== nuevoNodo ===> null)
            nuevoNodo.anterior = new Nodo(null);
            this.largo = this.largo +1;
        }else{
            this.primero.anterior = nuevoNodo;
            nuevoNodo.anterior = new Nodo(null);
            nuevoNodo.siguiente = this.primero;
            this.primero = nuevoNodo;
            this.largo = this.largo +1;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (this.primero.valor == null){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
            nuevoNodo.siguiente = new Nodo(null);
            nuevoNodo.anterior = new Nodo(null);
            this.largo = this.largo +1;
        }else{
            this.ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = this.ultimo;
            nuevoNodo.siguiente = new Nodo(null);
            this.ultimo = nuevoNodo;
            this.largo = this.largo +1;
        }
    }
    public T obtener(int i) {
        ListaIterador it = new ListaIterador();
        if (i == 0){
            return this.primero.valor;
        }else{        
            for (int n=0;n<i;n++){
            it.iterador = it.iterador.siguiente;
            }
        return it.iterador.valor;
        }
    }

    public void eliminar(int i) {
        ListaIterador it = new ListaIterador();
        Nodo aBorrar = new Nodo(obtener(i));
        Nodo aux = new Nodo(null);
        while (it.iterador.valor != aBorrar.valor){
            it.iterador = it.iterador.siguiente;
        }
        if (it.iterador.siguiente.valor == null) {
            aux = it.iterador.anterior;
            aux.siguiente = new Nodo(null);
            this.ultimo = aux;
            this.largo = this.largo - 1;
        }
        if (it.iterador.anterior.valor != null && it.iterador.siguiente.valor!=null){
            aux = it.iterador.anterior;
            aux.siguiente = it.iterador.siguiente; 
            this.largo = this.largo -1;

        }if(it.iterador.anterior.valor == null){
            this.primero = it.iterador.siguiente;
            it.iterador.anterior = new Nodo(null);
            this.largo = this.largo -1;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        ListaIterador it = new ListaIterador();
        Nodo nuevoNodo = new Nodo(elem);
        for (int n=0;n<indice;n++){
            it.iterador = it.iterador.siguiente;
        }
        it.iterador.valor = nuevoNodo.valor;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada <T> copia = new ListaEnlazada<T>();
        if (this.largo == 0){
            return copia;   
        }else{

            for(int n =0 ;n< this.largo;n++){
                copia.agregarAtras(this.primero.valor);
                this.primero = this.primero.siguiente;
            }
            return copia;
        }
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.primero = lista.primero;
        this.ultimo = lista.ultimo;
        this.largo = lista.largo;
        lista.primero = lista.primero.siguiente;
        while (lista.primero.siguiente != lista.ultimo.anterior){
            lista.primero = lista.primero.siguiente;
            this.agregarAtras(lista.primero.valor);
        }
    }
    
    @Override
    public String toString() {
        int n = 0;
        String str = new String("["+this.obtener(n).toString());
        for (n=1;n<this.largo;n++){
            str += ", "+this.obtener(n).toString();
        }
        return str += "]";
    }

    private class ListaIterador implements Iterador<T> {
    	Nodo iterador = primero;//inicializado de el objeto iterador

        public boolean haySiguiente() { //notar que mientras se esten usando objetos de al clase Nodo todos los .method corresponden a Nodo.method
            return this.iterador.siguiente != null;
        }
        
        public boolean hayAnterior() {
            if (this.iterador.equals(primero)){
                return false;
            }
            if(this.iterador.equals(ultimo.siguiente)){
                return true;
            }else{
                return this.iterador.anterior != null;
            }
           
        }

        public T siguiente() {
            T dato = this.iterador.valor;
            this.iterador = this.iterador.siguiente;
            return dato;
         }
        

        public T anterior() {
            if (this.iterador.equals(ultimo.siguiente)){
                return ultimo.valor;
            }
            this.iterador = this.iterador.anterior;
            T dato = this.iterador.valor;
            return dato;
        }
    }

    public Iterador<T> iterador() {
	    Iterador<T> iterador = new ListaIterador();
        return iterador;
    }

}