package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;


public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;



    public GameMinDTO() {
    }

    //Nesse construtor abaixo ao invés de receber todos os argumentos ele recebe a entidade, ou seja, copiando os dados da entidade Game. Logo será instanciado um GameMinDT a partir de um objeto Game copaindo os dados do Game para o DTO. E como não tem mais ambiguidade, ou seja, não tem mais parâmetros com os mesmos nomes dos campos, não é mais necessário o uso do this no construtor.
    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    //Aqui deve ser criado o construtor que vai receber todos os argumentos da interface GameMinProjection
    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
