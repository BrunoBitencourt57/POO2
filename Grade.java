import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grade {

    private List<Alocacao> alocacoes;

    public Grade() {
        this.alocacoes = new ArrayList<>();
    }

    public void adicionarAlocacao(Alocacao alocacao) {
       
        if (alocacao == null) {
            throw new IllegalArgumentException("A alocação não pode ser nula.");
        }
       
        this.alocacoes.add(alocacao);
    }

    public List<Alocacao> getAlocacoes() {
        return Collections.unmodifiableList(alocacoes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo da Grade:\n");
        for (Alocacao alocacao : alocacoes) {
            sb.append(alocacao.toString()).append("\n");
        }
        return sb.toString();
    }
}
