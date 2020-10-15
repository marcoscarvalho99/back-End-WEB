package tads.eaj.ufrn.Escola.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.Escola.Modelo.Curso;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioCurso;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCurso {


    @Autowired
    private RepositorioCurso repositorioCurso;


    public void setRepositorioCurso(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    public Curso cursoInsert(Curso curso) {

        return repositorioCurso.save(curso);

    }

    public Curso updateCurso(Curso curso) {

        return repositorioCurso.save(curso);

    }

    public void delete(Curso curso) {
        repositorioCurso.deleteById(curso.getId());
    }

    public Curso getOne(long id) {
        return repositorioCurso.findById(id).orElse(null);
    }

    public List<Curso> getAll() {

        return repositorioCurso.findAll();
    }


    public Optional<Curso> fyndBy(Long id) {
        return repositorioCurso.findById(id);

    }

    public Curso saveAndFlush(Curso curso) {
        return repositorioCurso.saveAndFlush(curso);
    }
}
