package tads.eaj.ufrn.Escola.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    String nomeDisciplina;

    //@ManyToMany(mappedBy = "disciplina")
    //List<Curso> cursos;

}
