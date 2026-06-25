import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Professor {

    private String nome;
    private Set<String> competencias;
    private Set<Horario> disponibilidades;

    public Professor(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }

        this.nome = nome;
        this.competencias = new HashSet<>();
        this.disponibilidades = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Set<String> getCompetencias() {
        return Collections.unmodifiableSet(competencias);
    }

    public Set<Horario> getDisponibilidades() {
        return Collections.unmodifiableSet(disponibilidades);
    }

    public void adicionarCompetencia(String competencia) {
        if (competencia == null || competencia.isBlank()) {
            throw new IllegalArgumentException("Competência inválida.");
        }

        competencias.add(competencia);
    }

    public void adicionarDisponibilidade(Horario horario) {
        if (horario == null) {
            throw new IllegalArgumentException("Horário inválido.");
        }

        disponibilidades.add(horario);
    }

    public boolean possuiCompetencia(String competencia) {
        return competencias.contains(competencia);
    }

    public boolean estaDisponivel(Horario horario) {
        return disponibilidades.contains(horario);
    }

    @Override
    public String toString() {
        return nome;
    }
}
