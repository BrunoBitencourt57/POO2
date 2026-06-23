public class Main {

    public static void main(String[] args) {

        Professor p1 = new Professor("Carlos");
        Professor p2 = new Professor("Maria");
        Professor p3 = new Professor("João");

        p1.adicionarCompetencia("POO");
        p2.adicionarCompetencia("Banco de Dados");
        p3.adicionarCompetencia("Estruturas de Dados");

        Horario h1 =
                new Horario(
                        DiaSemana.SEGUNDA,
                        Periodo.PRIMEIRO);

        Horario h2 =
                new Horario(
                        DiaSemana.TERCA,
                        Periodo.SEGUNDO);

        p1.adicionarDisponibilidade(h1);
        p2.adicionarDisponibilidade(h2);

        Disciplina d1 =
                new Disciplina(
                        "POO101",
                        "Programação Orientada a Objetos",
                        60);

        Disciplina d2 =
                new Disciplina(
                        "BD101",
                        "Banco de Dados",
                        60);

        Turma a1 =
                new Turma(
                        d1,
                        p1,
                        h1);

        Turma a2 =
                new Turma(
                        d2,
                        p2,
                        h2);

        Grade grade = new Grade();

        grade.adicionarTurma(a1);
        grade.adicionarTurma(a2);

        grade.exibirGrade();
    }
}
