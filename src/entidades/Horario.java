package entidades;

import java.util.Objects;

public final class Horario {

    private final DiaSemana diaSemana;
    private final Periodo periodo;

    public Horario(DiaSemana diaSemana, Periodo periodo) {

        if (diaSemana == null || periodo == null) {
            throw new IllegalArgumentException("Horário inválido.");
        }

        this.diaSemana = diaSemana;
        this.periodo = periodo;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    @Override
    public String toString() {
        return diaSemana + " - " + periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horario)) return false;
        Horario horario = (Horario) o;
        return diaSemana == horario.diaSemana && periodo == horario.periodo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diaSemana, periodo);
    }
}