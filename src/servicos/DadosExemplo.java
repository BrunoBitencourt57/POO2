package servicos;

import servicos.DadosExemplo;
import entidades.*;

import java.util.ArrayList;
import java.util.List;

public class DadosExemplo{

    public static List<Horario> criarHorarios(){
        List<Horario> horarios=new ArrayList<>();

        horarios.add(new Horario(DiaSemana.SEGUNDA,Periodo.PRIMEIRO));
        horarios.add(new Horario(DiaSemana.SEGUNDA,Periodo.SEGUNDO));
        horarios.add(new Horario(DiaSemana.SEGUNDA,Periodo.TERCEIRO));

        horarios.add(new Horario(DiaSemana.TERCA,Periodo.PRIMEIRO));
        horarios.add(new Horario(DiaSemana.TERCA,Periodo.SEGUNDO));
        horarios.add(new Horario(DiaSemana.TERCA,Periodo.TERCEIRO));

        horarios.add(new Horario(DiaSemana.QUARTA,Periodo.PRIMEIRO));
        horarios.add(new Horario(DiaSemana.QUINTA,Periodo.PRIMEIRO));
        horarios.add(new Horario(DiaSemana.SEXTA,Periodo.PRIMEIRO));

        return horarios;
    }

    public static List<Professor> criarProfessores(List<Horario> horarios){

        List<Professor> professores=new ArrayList<>();

        Professor p1=new Professor("Carlos");
        p1.adicionarCompetencia("Programação Orientada a Objetos");
        p1.adicionarCompetencia("Banco de Dados");
        p1.adicionarDisponibilidade(horarios.get(0));
        p1.adicionarDisponibilidade(horarios.get(5));

        Professor p2=new Professor("Maria");
        p2.adicionarCompetencia("Arquitetura e Organização de Computadores I");
        p2.adicionarCompetencia("Arquitetura e Organização de Computadores II");
        p2.adicionarCompetencia("Sistemas Operacionais");
        p2.adicionarDisponibilidade(horarios.get(3));
        p2.adicionarDisponibilidade(horarios.get(6));

        Professor p3=new Professor("João");
        p3.adicionarCompetencia("Redes de Computadores");
        p3.adicionarCompetencia("Sistemas Distribuidos");
        p3.adicionarDisponibilidade(horarios.get(8));

        Professor p4=new Professor("Sandra");
        p4.adicionarCompetencia("Algoritmos e Programação");
        p4.adicionarCompetencia("Estrutura de Dados I");
        p4.adicionarCompetencia("Estrutura de Dados II");
        p4.adicionarCompetencia("Teoria dos Grafos");
        p4.adicionarDisponibilidade(horarios.get(6));
        p4.adicionarDisponibilidade(horarios.get(4));

        Professor p5=new Professor("Roger");
        p5.adicionarCompetencia("Fundamentos de Matemática para Computação");
        p5.adicionarCompetencia("Calculo I");
        p5.adicionarCompetencia("Calculo II");
        p5.adicionarDisponibilidade(horarios.get(1));
        p5.adicionarDisponibilidade(horarios.get(4));

        professores.add(p1);
        professores.add(p2);
        professores.add(p3);
        professores.add(p4);
        professores.add(p5);

        return professores;
    }

    public static List<Aluno> criarAlunos(List<Disciplina> disciplinas) {

        List<Aluno> alunos = new ArrayList<>();

        Aluno a1 = new Aluno("Anelise"); 
        a1.adicionarInteresse(buscarDisciplina(disciplinas, "POO101"));
        a1.adicionarInteresse(buscarDisciplina(disciplinas, "BD101"));
        a1.adicionarInteresse(buscarDisciplina(disciplinas, "AOC101"));

        Aluno a2 = new Aluno("Rafael");
        a2.adicionarInteresse(buscarDisciplina(disciplinas, "POO101"));
        a2.adicionarInteresse(buscarDisciplina(disciplinas, "AOC202"));
        a2.adicionarInteresse(buscarDisciplina(disciplinas, "RC101"));

        Aluno a3 = new Aluno("Jonas"); 
        a3.adicionarInteresse(buscarDisciplina(disciplinas, "BD101"));
        a3.adicionarInteresse(buscarDisciplina(disciplinas, "AOC101"));
        a3.adicionarInteresse(buscarDisciplina(disciplinas, "AP101"));

        Aluno a4 = new Aluno("Elisa"); 
        a4.adicionarInteresse(buscarDisciplina(disciplinas, "POO101"));
        a4.adicionarInteresse(buscarDisciplina(disciplinas, "ED101"));
        a4.adicionarInteresse(buscarDisciplina(disciplinas, "ED202"));

        Aluno a5 = new Aluno("Guilherme"); 
        a5.adicionarInteresse(buscarDisciplina(disciplinas, "FMC101"));
        a5.adicionarInteresse(buscarDisciplina(disciplinas, "CCL101"));
        a5.adicionarInteresse(buscarDisciplina(disciplinas, "CCL202"));

        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);

        return alunos;

    }

    private static Disciplina buscarDisciplina(List<Disciplina> disciplinas, String codigo) {

        return disciplinas.stream()
                .filter(d -> d.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada: " + codigo));

    }

    public static List<Disciplina> criarDisciplinas() {

        List<Disciplina> disciplinas = new ArrayList<>();

        disciplinas.add(new Disciplina("POO101", "POO", 60, "Programação Orientada a Objetos"));
        disciplinas.add(new Disciplina("BD101", "Banco de Dados", 60, "Banco de Dados"));
        disciplinas.add(new Disciplina("AOC101", "AOC I", 60, "Arquitetura e Organização de Computadores I"));
        disciplinas.add(new Disciplina("AOC202", "AOC II", 60, "Arquitetura e Organização de Computadores II"));
        disciplinas.add(new Disciplina("RC101", "Redes", 60, "Redes de Computadores"));
        disciplinas.add(new Disciplina("AP101", "Algoritmos", 60, "Algoritmos e Programação"));
        disciplinas.add(new Disciplina("ED101", "ED I", 60, "Estrutura de Dados I"));
        disciplinas.add(new Disciplina("ED202", "ED II", 60, "Estrutura de Dados II"));
        disciplinas.add(new Disciplina("FMC101", "Matemática", 60, "Fundamentos de Matemática para Computação"));
        disciplinas.add(new Disciplina("CCL101", "Cálculo I", 60, "Calculo I"));
        disciplinas.add(new Disciplina("CCL202", "Cálculo II", 60, "Calculo II"));

        return disciplinas;
    }

}