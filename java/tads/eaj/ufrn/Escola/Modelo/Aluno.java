package tads.eaj.ufrn.Escola.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String nome;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "credencial_id")
    Credencial credencial;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id" )
    Curso curso;


//    @JoinColumn(name = "curso_id")
  // @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //Curso curso;



















    //    Curso curos
}
