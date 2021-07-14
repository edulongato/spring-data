package br.com.alura.spring.data.orm;


import javax.persistence.*;

@Entity//esta classe é uma entidade
@Table(name = "cargos")//notação nome da tabela.
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera os valores do Id automaticamente.
    private Integer id;

    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {

        return "Cargo [ " +
                "id= " + id +
                ", descricao= " + descricao + " ]\n";
    }
}
