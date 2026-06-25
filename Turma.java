public class Turma {

    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;

    public Turma(String codigo,
                 Disciplina disciplina,
                 Professor professor,
                 Horario horario) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código da turma inválido.");
        }

        if (disciplina == null || professor == null || horario == null) {
            throw new IllegalArgumentException("Dados da turma inválidos.");
        }

        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario = horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Horario getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Turma " + codigo
                + " | Disciplina: " + disciplina.getNome()
                + " | Professor: " + professor.getNome()
                + " | Horário: " + horario;
    }
}
