package entidades;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Aluno {

    private String nome;
    private Set<Disciplina> interesses;

    public Aluno(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }

        this.nome = nome;
        this.interesses = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Set<Disciplina> getInteresses() {
        return Collections.unmodifiableSet(interesses);
    }

    public void adicionarInteresse(Disciplina disciplina) {

        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina inválida.");
        }

        interesses.add(disciplina);
    }

    public boolean possuiInteresse(Disciplina disciplina) {

        if (disciplina == null) {
            return false;
        }

        return interesses.contains(disciplina);
    }

    @Override
    public String toString() {
        return nome;
    }

}