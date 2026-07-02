package strategy;

import entidades.*;
import java.util.Comparator;
import java.util.List;

public class MatchMenorNumeroCompetencias implements CriterioMatch {

    @Override
    public Professor escolherProfessor(
            Disciplina disciplina,
            List<Professor> professores,
            Horario horario) {

        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina inválida.");
        }

        if (professores == null || professores.isEmpty()) {
            throw new IllegalArgumentException("Lista de professores inválida.");
        }

        if (horario == null) {
            throw new IllegalArgumentException("Horário inválido.");
        }

        return professores.stream()
                .filter(professor ->
                        professor.possuiCompetencia(
                                disciplina.getCompetenciaNecessaria()))
                .filter(professor ->
                        professor.estaDisponivel(horario))
                .min(Comparator.comparingInt(
                        professor -> professor.getCompetencias().size()))
                .orElse(null);
    }
}