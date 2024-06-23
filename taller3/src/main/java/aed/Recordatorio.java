package aed;

public class Recordatorio {
    Horario horario;
    Fecha fecha;
    String mensaje;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.horario = horario;
        this.mensaje = mensaje;
        this.fecha = new Fecha (fecha);
    }

    public Horario horario(){
        return this.horario;
    }

    public Fecha fecha(){
        Fecha nuevaFecha = new Fecha(this.fecha);
        return nuevaFecha;
    }
        

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " " + "@" + " "+ String.valueOf(this.fecha)+" "+ String.valueOf(this.horario);
    }

    @Override
    public boolean equals(Object otro) {
        if ((otro.getClass() != this.getClass() || otro == null)){
            return false;
        }else{
            Recordatorio otro2 = (Recordatorio) otro;
            return this.mensaje == otro2.mensaje && this.fecha.equals(otro2.fecha) && this.horario.equals(otro2.horario);
        }
    }

}
