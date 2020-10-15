package tads.eaj.ufrn.Escola.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.Escola.Modelo.Credencial;
import tads.eaj.ufrn.Escola.Service.ServiceCredencial;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Credencial") //url do control principal
@Api(value = "API REST credencial")   //http://localhost:8080/swagger-ui.html
@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count") //libera os dominios da api para todas as aplicaçoes
public class ControllerCredencial {


    private ServiceCredencial serviceCredencial;


    @Autowired
    public void setServiceCredencial(ServiceCredencial serviceCredencial){
        this.serviceCredencial = serviceCredencial;
    }



    @ApiOperation(value = "cadastra um Aluno")                                                    //insere um aluno!
    @PostMapping
    public Credencial alunoInsert(@RequestBody Credencial credencial)
    {
        return serviceCredencial.credencialInsert( credencial);
    }


    @ApiOperation(value = "Retorna uma lista de Alunos")                                           //retorna todos os alunos da tabela
    @GetMapping
    public List<Credencial> listAll() {
        return serviceCredencial.getAll();
    }


    @ApiOperation(value = "Retorna um Aluno especifico")                                                    //retorna um aluno especifico passado por id
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Credencial> getOne(@PathVariable Long id){
        //return serviceAluno.fyndBy(id).orElse(null); // se caso não existir o aluno retorna noll ao inves de erro
        Optional<Credencial> CredencialOpitional= serviceCredencial.fyndBy(id);

        if(CredencialOpitional.isPresent()){
            return ResponseEntity.ok().body(CredencialOpitional.get()); //SE FOR PRESENT MANDA UM OK E O  CORPO MANDA UM OBJ O ALUNO
        }else {
            return  ResponseEntity.notFound().build(); //diz que é notfound e manda ela prA RESPOSTA UM ERRO 404.
        }
    }


    @ApiOperation(value = "atualiza um aluno da lista")                                                                        //atualizar
    @PutMapping(path = "/{id}")
    public ResponseEntity<Credencial> update(@PathVariable long id,@RequestBody Credencial credencial){
        return serviceCredencial
                .fyndBy(id)
                .map(record -> {
                    serviceCredencial.saveAndFlush(credencial);
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
    }


    @ApiOperation(value = "retira ou deleta um aluno da lista")                                                                //api deletar
    @DeleteMapping(path ="/{id}" )
    public  ResponseEntity<?>  delete(@PathVariable Long id){ // retorna um tipo generico

        return serviceCredencial
                .fyndBy(id)
                .map(record -> {
                    serviceCredencial.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
