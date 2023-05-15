package com.devsuperior.dslist.dto;


import com.devsuperior.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

//Esta classe GameDTO é criada por dois motivos: 1º) Para padronização de camadas onde é padronizado que o Service vai
// retornar para o Controlador o DTO, não retorna Entidade.
// 2º) Dependendo do relacionamento da Entidade e tiver uma relação cíclica entre as entidades onde aponta pra um e outro aponta para o outro
// e tentar retornar isso na API dará um loop infinito um chamando o outro. Logo é criado esse DTO para evitar esse problemas.
public class GameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {
    }

    //Construtor que recebe a entidade Game:
    public GameDTO(Game entity) {
        //Usando a classe utilitária BeanUtils ao invés de implementar atributo por atributo.
        // Assim o método copyProperties onde é passado como argumentos a origem e o destino,
        // onde através do entity que é a origem serão copiados as propriedades da entidade para o próprio DTO
        // que é refernciado pelo "this" que é o destino/alvo. Assim evita ficar implementando objtos muito grandes que tenham os mesmos nomes dos atributos.
        BeanUtils.copyProperties(entity, this);

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

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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
}
