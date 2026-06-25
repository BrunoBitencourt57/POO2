public class Disciplina {

    private String codigo;
    private String nome;
    private int cargaHoraria;
    private String competenciaNecessaria;

    public Disciplina(String codigo,
                      String nome,
                      int cargaHoraria,
                      String competenciaNecessaria) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }

        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária inválida.");
        }

        if (competenciaNecessaria == null || competenciaNecessaria.isBlank()) {
            throw new IllegalArgumentException("Competência necessária inválida.");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.competenciaNecessaria = competenciaNecessaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getCompetenciaNecessaria() {
        return competenciaNecessaria;
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")";
    }
}
}
