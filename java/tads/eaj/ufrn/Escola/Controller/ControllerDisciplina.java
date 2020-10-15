package tads.eaj.ufrn.Escola.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.Escola.Modelo.Disciplina;
import tads.eaj.ufrn.Escola.Service.ServiceDisciplinas;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Disciplina")
@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
@Api(value = "API REST ALUNO")
public class ControllerDisciplina {



    private ServiceDisciplinas servicedisciplinas;


    @Autowired
    public void setServicedisciplinas(ServiceDisciplinas servicedisciplinas){
        this.servicedisciplinas = servicedisciplinas;
    }



    @ApiOperation(value = "cadastra uma disciplina")
    @PostMapping
    public Disciplina disciplinaInsert(@RequestBody Disciplina disciplina)
    {
        return servicedisciplinas.disciplinaInsert(disciplina);
    }


    @ApiOperation(value = "Retorna uma lista de Alunos")
    @GetMapping
    public List<Disciplina> listAll() {
        return servicedisciplinas.getAll();
    }

    @ApiOperation(value = "Retorna um Aluno especifico")
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Disciplina> getOne(@PathVariable Long id){

        Optional<Disciplina> disciplinaOptional= servicedisciplinas.fyndBy(id);

        if(disciplinaOptional.isPresent()){
            return ResponseEntity.ok().body(disciplinaOptional.get());
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "atualiza um aluno da lista")                                                                        //atualizar
    @PutMapping(path = "/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable long id,@RequestBody Disciplina disciplina){
        return servicedisciplinas
                .fyndBy(id)
                .map(record -> {
                    servicedisciplinas.saveAndFlush(disciplina);
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
    }
    @ApiOperation(value = "retira ou deleta um aluno da lista")                                                                //api deletar
    @DeleteMapping(path ="/{id}" )
    public  ResponseEntity<?>  delete(@PathVariable Long id){ // retorna um tipo generico
        //serviceAluno.delete();
        return servicedisciplinas
                .fyndBy(id)
                .map(record -> {
                    servicedisciplinas.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
