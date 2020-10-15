package tads.eaj.ufrn.Escola.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.Escola.Modelo.Aluno;
import tads.eaj.ufrn.Escola.Service.ServiceAluno;

import java.util.List;
import java.util.Optional;

@RestController //@ResponseBody
@RequestMapping("/Aluno") //url do control principal
@Api(value = "API REST ALUNO")   //http://localhost:8080/swagger-ui.html

//libera os dominios da api para todas as aplicaçoes
@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
public class ControllerAluno {


    private ServiceAluno serviceAluno;


    @Autowired
    public void setServiceAluno(ServiceAluno serviceAluno){
        this.serviceAluno=serviceAluno;
    }



    @ApiOperation(value = "cadastra um Aluno")                                                    //insere um aluno!
    @PostMapping
    public Aluno alunoInsert(@RequestBody Aluno aluno)
    {
        return serviceAluno.alunoInsert( aluno);
    }


    @ApiOperation(value = "Retorna uma lista de Alunos")                                           //retorna todos os alunos da tabela
    @GetMapping
    public List<Aluno> listAll() {
        return serviceAluno.getAll();
    }

    @ApiOperation(value = "Retorna um Aluno especifico")                                                    //retorna um aluno especifico passado por id
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Aluno> getOne(@PathVariable Long id){
        //return serviceAluno.fyndBy(id).orElse(null); // se caso não existir o aluno retorna noll ao inves de erro
        Optional<Aluno> AlunoOpitional= serviceAluno.fyndBy(id);

        if(AlunoOpitional.isPresent()){
            return ResponseEntity.ok().body(AlunoOpitional.get()); //SE FOR PRESENT MANDA UM OK E O  CORPO MANDA UM OBJ O ALUNO
        }else {
            return  ResponseEntity.notFound().build(); //diz que é notfound e manda ela prA RESPOSTA UM ERRO 404.
        }
    }

    @ApiOperation(value = "atualiza um aluno da lista")                                                                        //atualizar
    @PutMapping(path = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable long id,@RequestBody Aluno aluno){
        return serviceAluno
                .fyndBy(id)
                .map(record -> {
                    serviceAluno.saveAndFlush(aluno);
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
    }
    @ApiOperation(value = "retira ou deleta um aluno da lista")                                                                //api deletar
    @DeleteMapping(path ="/{id}" )
    public  ResponseEntity<?>  delete(@PathVariable Long id){ // retorna um tipo generico
        //serviceAluno.delete();
        return serviceAluno
                .fyndBy(id)
                .map(record -> {
                    serviceAluno.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
