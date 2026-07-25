package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.data.dto;
import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {

    private static final long serialVersionVID = 1L;

    private long id;
    private String nome;
    private int idade;
    private String nacionalidade;
    private String genero;

    public PersonDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO person)) return false;
        return getId() == person.getId() && Objects.equals(getNome(), person.getNome()) && Objects.equals(getIdade(), person.getIdade()) && Objects.equals(getNacionalidade(), person.getNacionalidade()) && Objects.equals(getGenero(), person.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getNacionalidade(), getGenero());
    }
}
