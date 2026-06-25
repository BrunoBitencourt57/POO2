public class Main {

    public static void main(String[] args) {

        try {

            Professor p1 = new Professor("Carlos");
            Professor p2 = new Professor("Maria");
            Professor p3 = new Professor("João");
            Professor p4 = new Professor("Sandra");
            Professor p5 = new Professor("Roger");

            p1.adicionarCompetencia("Programação Orientada a Objetos");
            p1.adicionarCompetencia("Banco de Dados");

            p2.adicionarCompetencia("Arquitetura e Organização de Computadores I");
            p2.adicionarCompetencia("Arquitetura e Organização de Computadores II");
            p2.adicionarCompetencia("Sistemas Operacionais");

            p3.adicionarCompetencia("Redes de Computadores");
            p3.adicionarCompetencia("Sistemas Distribuidos");

            p4.adicionarCompetencia("Algoritmos e Programação");
            p4.adicionarCompetencia("Estrutura de Dados I");
            p4.adicionarCompetencia("Estrutura de Dados II");
            p4.adicionarCompetencia("Teoria dos Grafos");

            p5.adicionarCompetencia("Fundamentos de Matemática para Computação");
            p5.adicionarCompetencia("Calculo I");
            p5.adicionarCompetencia("Calculo II");

            Horario hsd1 =
                    new Horario(
                            DiaSemana.SEGUNDA,
                            Periodo.PRIMEIRO);

            Horario hsd2 =
                    new Horario(
                            DiaSemana.SEGUNDA,
                            Periodo.SEGUNDO);

            Horario ht1 =
                    new Horario(
                            DiaSemana.TERCA,
                            Periodo.PRIMEIRO);

            Horario ht2 =
                    new Horario(
                            DiaSemana.TERCA,
                            Periodo.SEGUNDO);

            Horario ht3 =
                    new Horario(
                            DiaSemana.TERCA,
                            Periodo.TERCEIRO);

            Horario hqa1 =
                    new Horario(
                            DiaSemana.QUARTA,
                            Periodo.PRIMEIRO);

            Horario hqi1 =
                    new Horario(
                            DiaSemana.QUINTA,
                            Periodo.PRIMEIRO);

            Horario hst1 =
                    new Horario(
                            DiaSemana.SEXTA,
                            Periodo.PRIMEIRO);

            p1.adicionarDisponibilidade(hsd1);
            p1.adicionarDisponibilidade(ht3);

            p2.adicionarDisponibilidade(ht2);

            p3.adicionarDisponibilidade(hst1);

            p4.adicionarDisponibilidade(hqa1);
            p4.adicionarDisponibilidade(hqi1);

            p5.adicionarDisponibilidade(hsd2);
            p5.adicionarDisponibilidade(ht1);

            Disciplina d1 =
                    new Disciplina(
                            "POO101",
                            "Programação Orientada a Objetos",
                            60,
                            "Programação Orientada a Objetos");

            Disciplina d2 =
                    new Disciplina(
                            "BD101",
                            "Banco de Dados",
                            60,
                            "Banco de Dados");

            Disciplina d3 =
                    new Disciplina(
                            "AOC101",
                            "Arquitetura e Organização de Computadores I",
                            60,
                            "Arquitetura e Organização de Computadores I");

            Disciplina d4 =
                    new Disciplina(
                            "AOC202",
                            "Arquitetura e Organização de Computadores II",
                            60,
                            "Arquitetura e Organização de Computadores II");

            Disciplina d5 =
                    new Disciplina(
                            "RC101",
                            "Redes de Computadores",
                            60,
                            "Redes de Computadores");

            Disciplina d6 =
                    new Disciplina(
                            "AP101",
                            "Algoritmos e Programação",
                            60,
                            "Algoritmos e Programação");

            Disciplina d7 =
                    new Disciplina(
                            "ED101",
                            "Estrutura de Dados I",
                            60,
                            "Estrutura de Dados I");

            Disciplina d8 =
                    new Disciplina(
                            "ED202",
                            "Estrutura de Dados II",
                            60,
                            "Estrutura de Dados II");

            Disciplina d9 =
                    new Disciplina(
                            "FMC101",
                            "Fundamentos de Matemática para Computação",
                            60,
                            "Fundamentos de Matemática para Computação");

            Disciplina d10 =
                    new Disciplina(
                            "CCL101",
                            "Calculo I",
                            60,
                            "Calculo I");

            Disciplina d11 =
                    new Disciplina(
                            "CCL202",
                            "Calculo II",
                            60,
                            "Calculo II");


            Turma t1 =
                    new Turma(
                            "T1",
                            d1,
                            p1,
                            ht3);

            Turma t2 =
                    new Turma(
                            "T2",
                            d2,
                            p1,
                            hsd1);


            Turma t3 =
                    new Turma(
                            "T3",
                            d3,
                            p2,
                            ht2);

            Turma t4 =
                    new Turma(
                            "T4",
                            d5,
                            p3,
                            hst1);

            Turma t5 =
                    new Turma(
                            "T5",
                            d6,
                            p4,
                            hqa1);

            Turma t6 =
                    new Turma(
                            "T6",
                            d8,
                            p4,
                            hqi1);

            Turma t7 =
                    new Turma(
                            "T7",
                            d9,
                            p5,
                            hsd2);

            Turma t8 =
                    new Turma(
                            "T8",
                            d11,
                            p5,
                            ht1);

            Grade grade = new Grade();

            grade.adicionarTurma(t1);
            grade.adicionarTurma(t2);
            grade.adicionarTurma(t3);
            grade.adicionarTurma(t4);
            grade.adicionarTurma(t5);
            grade.adicionarTurma(t6);
            grade.adicionarTurma(t7);
            grade.adicionarTurma(t8);

            grade.exibirGrade();

            System.out.println();
            grade.exibirGradeOrdenadaPorHorario();

            System.out.println();
            grade.exibirTurmasProfessor("Carlos");

        } catch (CompetenciaInvalidaException | ConflitoHorarioException | IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
