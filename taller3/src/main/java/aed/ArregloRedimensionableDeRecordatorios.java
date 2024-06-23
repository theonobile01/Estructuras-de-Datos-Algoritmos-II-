package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    int longitud;
    Recordatorio[] arreglo;

    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[0];
        this.longitud = 0;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {  
        this.longitud = vector.longitud;
        this.arreglo = new Recordatorio[vector.longitud];
        for(int n=0; n < vector.longitud; n++) {
            this.arreglo[n] = vector.obtener(n);
        }
        this.longitud = vector.longitud();
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        this.longitud = this.longitud + 1;
        Recordatorio[] nuevoArreglo = new Recordatorio[this.longitud];
        for(int n=0; n < this.longitud-1; n++) {
            nuevoArreglo[n] = this.arreglo[n];
        }
        nuevoArreglo[this.longitud - 1] = i;
        this.arreglo = nuevoArreglo;
    }

    public Recordatorio obtener(int i) {
        return this.arreglo[i];
    }

    public void quitarAtras() {
        this.longitud = this.longitud - 1;
        Recordatorio[] nuevoArreglo = new Recordatorio[this.longitud];
        for(int n=0; n < this.longitud; n++) {
            nuevoArreglo[n] = this.arreglo[n];
        }
        this.arreglo = nuevoArreglo;
    }
    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios nuevoArreglo = new ArregloRedimensionableDeRecordatorios();
        for(int n=0; n < this.longitud; n++) {
            nuevoArreglo.agregarAtras(this.arreglo[n]);;
        }
        return nuevoArreglo;
    }
}