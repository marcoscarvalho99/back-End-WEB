package tads.eaj.ufrn.Escola.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.Escola.Modelo.Credencial;

public interface RepositorioCredencial extends JpaRepository<Credencial, Long> {
}
