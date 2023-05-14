package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //Usando essas anotações fazemos o mapeamento ORM - mapear o objeto Game para que ele vire um registron atabela de Games no banco de dados relacional. A @Entity configura a classe Java Game para que ela seja equivalente a uma tabela do banco relacional.
@Table(name = "tb_game") //Essa anotation customiza o nme da tabela no banco.
public class Game {
    @Id //Essa anotation é para configurar o id para ser a chave primária da tebela no banco.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Essa anotation é para que o id seja auto incrementado pelo banco de dados. Ao colocar o strategy como GenerationType.IDENTITY que é uma forma que o @GeneratedValue vai indicar para o banco gerar o id.
    private Long id;
    private String title;
    @Column(name = "game_year") //Essa anotation serve para customizar o nome da coluna no banco. Quando não customiza mantém o nome que está abaixo (year).
    private Integer year;
    private String genre;
    private String platform;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public Game() {
    }

    public Game(Long id, String title, Integer year, String genre, String platform, String imgUrl, String shortDescription, String longDescription) {
        this.id = id; //o this.id é o dado do objeto "private Long id", o id que vem após o sinal de "=" vem do argumento "Long id". Logo, o id que veio do objeto recebe o id que veio do argumento.
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platform = platform;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
