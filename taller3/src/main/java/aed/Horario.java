package aed;

public class Horario {
    int horas;
    int minutos;
    public Horario(int hora, int minutos) {
        this.horas = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.horas;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return String.valueOf(this.horas) +":"+ String.valueOf(this.minutos);
    }

    @Override
    public boolean equals(Object otro) {
        if ((otro.getClass()!= this.getClass()) || (otro == null)){
            return false;
        }else{
            Horario nuevoHorario = (Horario) otro;
            return (nuevoHorario.horas == this.horas) && (nuevoHorario.minutos == this.minutos);
        }
    }

}
