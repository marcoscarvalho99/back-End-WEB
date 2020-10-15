package tads.eaj.ufrn.Escola.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.Escola.Modelo.Credencial;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioCredencial;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCredencial {

    @Autowired
    private RepositorioCredencial repositorioCredencial;


    public void setRepositorioCredencial(RepositorioCredencial repositorioCredencial) {
        this.repositorioCredencial = repositorioCredencial;
    }

    public Credencial credencialInsert(Credencial credencial) {

        return repositorioCredencial.save(credencial);

    }

    public Credencial updateCredencial(Credencial credencial) {

        return repositorioCredencial.save(credencial);

    }

    public void delete(Credencial credencial) {
        repositorioCredencial.deleteById(credencial.getId());
    }

    public Credencial getOne(long id) {
        return repositorioCredencial.findById(id).orElse(null);
    }

    public List<Credencial> getAll() {

        return repositorioCredencial.findAll();
    }


    public Optional<Credencial> fyndBy(Long id) {
        return repositorioCredencial.findById(id);

    }

    public Credencial saveAndFlush(Credencial credencial) {
        return repositorioCredencial.saveAndFlush(credencial);
    }

}
