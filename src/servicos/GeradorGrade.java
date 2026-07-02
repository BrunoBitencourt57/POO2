package servicos;

import entidades.*;
import excecoes.*;
import strategy.CriterioMatch;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorGrade {

    private final CriterioMatch criterioMatch;

    public GeradorGrade(CriterioMatch criterioMatch) {

        if (criterioMatch == null) {
            throw new IllegalArgumentException("Critério de match inválido.");
        }

        this.criterioMatch = criterioMatch;
    }

    public Grade gerarGrade(
            List<Professor> professores,
            List<Disciplina> disciplinas,
            List<Aluno> alunos,
            List<Horario> horariosDisponiveis) {

        if (professores == null || professores.isEmpty()) {
            throw new IllegalArgumentException("Lista de professores inválida.");
        }

        if (disciplinas == null || disciplinas.isEmpty()) {
            throw new IllegalArgumentException("Lista de disciplinas inválida.");
        }

        if (alunos == null) {
            throw new IllegalArgumentException("Lista de alunos inválida.");
        }

        if (horariosDisponiveis == null || horariosDisponiveis.isEmpty()) {
            throw new IllegalArgumentException("Lista de horários inválida.");
        }

        Grade grade = new Grade();

        List<Disciplina> disciplinasOrdenadas =
                ordenarDisciplinasPorInteresse(disciplinas, alunos);

        int contadorTurmas = 1;

        for (Disciplina disciplina : disciplinasOrdenadas) {

            boolean alocada = false;

            for (Horario horario : horariosDisponiveis) {

                Professor professor = criterioMatch.escolherProfessor(
                        disciplina,
                        professores,
                        horario
                );

                if (professor == null) {
                    continue;
                }

                Turma turma = new Turma(
                        "T" + contadorTurmas,
                        disciplina,
                        professor,
                        horario
                );

                try {
                    grade.adicionarTurma(turma);
                    contadorTurmas++;
                    alocada = true;
                    break;

                } catch (ConflitoHorarioException |
                         CompetenciaInvalidaException e) {

                    System.out.println(
                            "Conflito ao alocar " + disciplina.getNome()
                            + ": " + e.getMessage()
                    );
                }
            }

            if (!alocada) {
                System.out.println(
                        "AVISO: Não foi possível alocar a disciplina "
                        + disciplina.getNome()
                );
            }
        }

        return grade;
    }

    private List<Disciplina> ordenarDisciplinasPorInteresse(
            List<Disciplina> disciplinas,
            List<Aluno> alunos) {

        return disciplinas.stream()
                .sorted(Comparator.comparingLong(
                        (Disciplina d) -> quantidadeInteressados(d, alunos)
                ).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private long quantidadeInteressados(
            Disciplina disciplina,
            List<Aluno> alunos) {

        return alunos.stream()
                .filter(a -> a.possuiInteresse(disciplina))
                .count();
    }
}