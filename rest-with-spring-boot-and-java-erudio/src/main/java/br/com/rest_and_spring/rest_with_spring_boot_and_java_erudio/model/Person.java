package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Dublador")
public class Person implements Serializable {

    private static final long serialVersionVID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;
    private int idade;
    private String nacionalidade;

    @Column(length = 8)
    private String gender;

    public Person() {}

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getNome(), person.getNome()) && Objects.equals(getIdade(), person.getIdade()) && Objects.equals(getNacionalidade(), person.getNacionalidade()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getNacionalidade(), getGender());
    }
}
