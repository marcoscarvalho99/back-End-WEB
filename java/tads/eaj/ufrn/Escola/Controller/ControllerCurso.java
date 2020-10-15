package tads.eaj.ufrn.Escola.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.Escola.Modelo.Curso;
import tads.eaj.ufrn.Escola.Service.ServiceCurso;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
@RestController
@RequestMapping("/Curso") //url do control principal
@Api(value = "API REST Curso")
public class ControllerCurso {


    private ServiceCurso serviceCurso;


    @Autowired
    public void setServiceCurso(ServiceCurso serviceCurso){
        this.serviceCurso = serviceCurso;
    }



    @ApiOperation(value = "cadastra um Aluno")                                                    //insere um aluno!
    @PostMapping

    public Curso cursoInsert(@RequestBody Curso curso)
    {
        return serviceCurso.cursoInsert( curso);
    }


    @ApiOperation(value = "Retorna uma lista de Alunos")                                           //retorna todos os alunos da tabela
    @GetMapping
    public List<Curso> listAll() {
        return serviceCurso.getAll();
    }


    @ApiOperation(value = "Retorna um Aluno especifico")                                                    //retorna um aluno especifico passado por id
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Curso> getOne(@PathVariable Long id){
                                                                                                //return serviceAluno.fyndBy(id).orElse(null); // se caso não existir o aluno retorna noll ao inves de erro
        Optional<Curso> CursoOpitional= serviceCurso.fyndBy(id);

        if(CursoOpitional.isPresent()){
            return ResponseEntity.ok().body(CursoOpitional.get()); //SE FOR PRESENT MANDA UM OK E O  CORPO MANDA UM OBJ O ALUNO
        }else {
            return  ResponseEntity.notFound().build(); //diz que é notfound e manda ela prA RESPOSTA UM ERRO 404.
        }
    }


    @ApiOperation(value = "atualiza um aluno da lista")                                                                        //atualizar
    @PutMapping(path = "/{id}")
    public ResponseEntity<Curso> update(@PathVariable long id,@RequestBody Curso curso){
        return serviceCurso
                .fyndBy(id)
                .map(record -> {
                    serviceCurso.saveAndFlush(curso);
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
    }


    @ApiOperation(value = "retira ou deleta um  da lista")                                                                //api deletar
    @DeleteMapping(path ="/{id}" )
    public  ResponseEntity<?>  delete(@PathVariable Long id){ // retorna um tipo generico

        return serviceCurso
                .fyndBy(id)
                .map(record -> {
                    serviceCurso.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
