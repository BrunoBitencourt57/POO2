import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Grade {

    private List<Turma> turmas;

    public Grade() {
        this.turmas = new ArrayList<>();
    }

    public List<Turma> getTurmas() {
        return new ArrayList<>(turmas);
    }

    public void adicionarTurma(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("Turma inválida.");
        }

        validarCompetenciaProfessor(turma);
        validarDisponibilidadeProfessor(turma);
        validarConflitoProfessor(turma);
        validarConflitoTurma(turma);

        turmas.add(turma);
    }

    private void validarCompetenciaProfessor(Turma turma) {
        String competenciaNecessaria = turma.getDisciplina().getCompetenciaNecessaria();

        if (!turma.getProfessor().possuiCompetencia(competenciaNecessaria)) {
            throw new CompetenciaInvalidaException(
                    "O professor " + turma.getProfessor().getNome()
                            + " não possui a competência necessária para ministrar "
                            + turma.getDisciplina().getNome()
                            + ". Competência exigida: " + competenciaNecessaria
            );
        }
    }

    private void validarDisponibilidadeProfessor(Turma turma) {
        if (!turma.getProfessor().estaDisponivel(turma.getHorario())) {
            throw new ConflitoHorarioException(
                    "O professor " + turma.getProfessor().getNome()
                            + " não está disponível no horário "
                            + turma.getHorario() + "."
            );
        }
    }

    private void validarConflitoProfessor(Turma novaTurma) {
        for (Turma turmaExistente : turmas) {
            boolean mesmoProfessor =
                    turmaExistente.getProfessor().equals(novaTurma.getProfessor());

            boolean mesmoHorario =
                    turmaExistente.getHorario().equals(novaTurma.getHorario());

            if (mesmoProfessor && mesmoHorario) {
                throw new ConflitoHorarioException(
                        "Conflito de horário do professor "
                                + novaTurma.getProfessor().getNome()
                                + ": ele já está alocado na turma "
                                + turmaExistente.getCodigo()
                                + " no horário "
                                + novaTurma.getHorario() + "."
                );
            }
        }
    }

    private void validarConflitoTurma(Turma novaTurma) {
        for (Turma turmaExistente : turmas) {
            boolean mesmoCodigoTurma =
                    turmaExistente.getCodigo().equalsIgnoreCase(novaTurma.getCodigo());

            boolean mesmoHorario =
                    turmaExistente.getHorario().equals(novaTurma.getHorario());

            if (mesmoCodigoTurma && mesmoHorario) {
                throw new ConflitoHorarioException(
                        "Conflito de horário da turma "
                                + novaTurma.getCodigo()
                                + ": já existe uma disciplina alocada nesse horário."
                );
            }
        }
    }

    public void exibirGrade() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma alocada na grade.");
            return;
        }

        System.out.println("===== GRADE DE HORÁRIOS =====");
        for (Turma turma : turmas) {
            System.out.println(turma);
        }
    }

    public void exibirGradeOrdenadaPorHorario() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma alocada na grade.");
            return;
        }

        System.out.println("===== GRADE ORDENADA POR HORÁRIO =====");
        turmas.stream()
                .sorted(Comparator
                        .comparing((Turma t) -> t.getHorario().getDiaSemana().ordinal())
                        .thenComparing(t -> t.getHorario().getPeriodo().ordinal()))
                .forEach(System.out::println);
    }

    public void exibirTurmasProfessor(String nomeProfessor) {
        List<Turma> resultado = turmas.stream()
                .filter(t -> t.getProfessor().getNome().equalsIgnoreCase(nomeProfessor))
                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            System.out.println("Nenhuma turma encontrada para o professor " + nomeProfessor + ".");
            return;
        }

        System.out.println("===== TURMAS DO PROFESSOR " + nomeProfessor.toUpperCase() + " =====");
        resultado.forEach(System.out::println);
    }

    public void exibirTurmasDisciplina(String nomeDisciplina) {
        List<Turma> resultado = turmas.stream()
                .filter(t -> t.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplina))
                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            System.out.println("Nenhuma turma encontrada para a disciplina " + nomeDisciplina + ".");
            return;
        }

        System.out.println("===== TURMAS DA DISCIPLINA " + nomeDisciplina.toUpperCase() + " =====");
        resultado.forEach(System.out::println);
    }

    @Override
    public String toString() {
        if (turmas.isEmpty()) {
            return "Nenhuma turma cadastrada na grade.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===== GRADE DE HORÁRIOS =====\n");

        for (Turma turma : turmas) {
            sb.append(turma).append("\n");
        }

        return sb.toString();
    }
}
    }
}
