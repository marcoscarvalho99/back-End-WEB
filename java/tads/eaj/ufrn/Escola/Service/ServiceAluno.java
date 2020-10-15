package tads.eaj.ufrn.Escola.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.Escola.Modelo.Aluno;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioAluno;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAluno {

    @Autowired
    private RepositorioAluno repositorioAluno;


    public void setRepositorioAluno(RepositorioAluno repositorioAluno) {
        this.repositorioAluno = repositorioAluno;
    }

    public Aluno alunoInsert(Aluno aluno) {

        return repositorioAluno.save(aluno);

    }

    public Aluno updateAluno(Aluno aluno) {

        return repositorioAluno.save(aluno);

    }

    public void delete(Aluno aluno) {
        repositorioAluno.deleteById(aluno.getId());
    }

    public Aluno getOne(long id) {
        return repositorioAluno.findById(id).orElse(null);
    }

    public List<Aluno> getAll() {

        return repositorioAluno.findAll();
    }


    public Optional<Aluno> fyndBy(Long id) {
        return repositorioAluno.findById(id);

    }

    public Aluno saveAndFlush(Aluno aluno) {
        return repositorioAluno.saveAndFlush(aluno);
    }

}