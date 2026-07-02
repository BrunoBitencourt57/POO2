package app;

import servicos.DadosExemplo;
import servicos.GeradorGrade;
import strategy.MatchMenorNumeroCompetencias;
import entidades.*;
import excecoes.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            List<Horario> horarios = 
                    DadosExemplo.criarHorarios();

            List<Professor> professores =
                    DadosExemplo.criarProfessores(horarios);

            List<Disciplina> disciplinas =
                    DadosExemplo.criarDisciplinas();

            List<Aluno> alunos =
                    DadosExemplo.criarAlunos(disciplinas);

            GeradorGrade gerador =
                    new GeradorGrade(
                            new MatchMenorNumeroCompetencias()
                    );

            Grade grade = gerador.gerarGrade(
                    professores,
                    disciplinas,
                    alunos,
                    horarios
            );

            grade.exibirGrade(); //grade final

            grade.exibirGradeOrdenadaPorHorario();

            grade.exibirTurmasProfessor("Carlos");

        } catch (CompetenciaInvalidaException |
                 ConflitoHorarioException |
                 GradeInvalidaException |
                 IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
}