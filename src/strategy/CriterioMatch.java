package strategy;

import entidades.*;
import java.util.List;

public interface CriterioMatch {

    Professor escolherProfessor(
            Disciplina disciplina,
            List<Professor> professores,
            Horario horario
        );
        
    }