import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grade {

    private List<> Turmas;

    public Grade() {
        this.Turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma Turma) {
       
        if (Turma == null) {
            throw new IllegalArgumentException("A alocação não pode ser nula.");
        }
       
        this.Turmas.add(Turma);
    }

    public List<Turma> getTurmas() {
        return Collections.unmodifiableList(Turmas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo da Grade:\n");
        for (Turma Turma : Turmas) {
            sb.append(Turma.toString()).append("\n");
        }
        return sb.toString();
    }
}
