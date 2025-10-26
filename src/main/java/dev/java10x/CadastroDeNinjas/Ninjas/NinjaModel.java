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

    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, int idade, String imgUrl, MissoesModel missoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.imgUrl = imgUrl;
        this.missoes = missoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
