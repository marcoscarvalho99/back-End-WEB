package tads.eaj.ufrn.Escola.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.Escola.Modelo.Disciplina;

public interface RepositorioDisciplinas extends JpaRepository<Disciplina,Long> {
}
