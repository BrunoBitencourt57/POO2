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
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Horario)) {
            return false;
        }

        Horario outro = (Horario) obj;

        return diaSemana == outro.diaSemana
                && periodo == outro.periodo;
    }

    @Override
    public int hashCode() {
        return diaSemana.hashCode() * 31
                + periodo.hashCode();
    }
}
