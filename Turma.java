public class Turma {

    private String nome;
    private int semestre;

    public Turma(String nome, int semestre) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da turma inválido.");
        }

        if (semestre <= 0) {
            throw new IllegalArgumentException("Semestre inválido.");
        }

        this.nome = nome;
        this.semestre = semestre;
    }

    public String getNome() {
        return nome;
    }

    public int getSemestre() {
        return semestre;
    }

    @Override
    public String toString() {
        return nome + " - " + semestre + "º semestre";
    }
}
