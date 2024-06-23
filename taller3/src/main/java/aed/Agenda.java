    package aed;

import java.lang.reflect.Array;

public class Agenda {
    Fecha fecha;
    ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fecha = new Fecha(fechaActual.dia(),fechaActual.mes());
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {
        String str = new String(fechaActual() + "\n=====\n" );
        for(int n=0; n < this.recordatorios.longitud(); n++) {
            if(fechaActual().equals(this.recordatorios.obtener(n).fecha())){
                str += this.recordatorios.obtener(n).toString() + "\n";
            }
        }
        return str;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();

    }

    public Fecha fechaActual() {
        Fecha fechaActual = new Fecha(this.fecha);
        return fechaActual;
    }

}
