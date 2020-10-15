package tads.eaj.ufrn.Escola.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.Escola.Modelo.Disciplina;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioDisciplinas;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDisciplinas {


//    @Autowired
//    RepositorioDisciplinas repositorioDisciplinas;



    private RepositorioDisciplinas repositorioDisciplinas;

    @Autowired
    public void setRepositorioDisciplinas(RepositorioDisciplinas repositorioDisciplinas) {
        this.repositorioDisciplinas = repositorioDisciplinas;
    }

    public Disciplina disciplinaInsert(Disciplina disciplina) {

        return repositorioDisciplinas.save(disciplina);

    }

    public Disciplina updateDisciplina(Disciplina disciplina) {

        return repositorioDisciplinas.save(disciplina);

    }

    public void delete(Disciplina disciplina) {
        repositorioDisciplinas.deleteById(disciplina.getId());
    }

    public Disciplina getOne(long id) {
        return repositorioDisciplinas.findById(id).orElse(null);
    }

    public List<Disciplina> getAll() {

        return repositorioDisciplinas.findAll();
    }


    public Optional<Disciplina> fyndBy(Long id) {
        return repositorioDisciplinas.findById(id);

    }

    public Disciplina saveAndFlush(Disciplina disciplina) {
        return repositorioDisciplinas.saveAndFlush(disciplina);
    }

}
