package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// Entity - Transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    //@ManyToOne - Um ninja tem uma única missão
    @ManyToOne
    /*Foreign Key - Cria uma chave estrageira na tabela de ninjas com base no ID das missões*/
    @JoinColumn(name = "missoes_id")
    /*O ORM identifica o contexto com base no Objeto Missoes criado a seguir com tipo MissoesModel*/
    private MissoesModel missoes;



}
