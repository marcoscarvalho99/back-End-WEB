package tads.eaj.ufrn.Escola.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.Escola.Modelo.Curso;

public interface RepositorioCurso extends JpaRepository<Curso, Long> {

}
