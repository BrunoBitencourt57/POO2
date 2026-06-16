import java.util.HashSet;
import java.util.Set;

public class Professor {

    private String nome;

    private Set<String> competencias;

    private Set<Horario> disponibilidades;

    public Professor(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;

        competencias = new HashSet<>();
        disponibilidades = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Set<String> getCompetencias() {
        return competencias;
    }

    public Set<Horario> getDisponibilidades() {
        return disponibilidades;
    }

    public void adicionarCompetencia(String competencia) {
        competencias.add(competencia);
    }

    public void adicionarDisponibilidade(Horario horario) {
        disponibilidades.add(horario);
    }
}
