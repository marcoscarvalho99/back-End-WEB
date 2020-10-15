package tads.eaj.ufrn.Escola.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @JoinTable(
            name = "disciplina_curso",
            joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    List <Disciplina> disciplina;
}
