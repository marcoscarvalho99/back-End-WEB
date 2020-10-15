package tads.eaj.ufrn.Escola.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.Escola.Modelo.Aluno;

public interface RepositorioAluno extends JpaRepository<Aluno,Long> {
    
}
