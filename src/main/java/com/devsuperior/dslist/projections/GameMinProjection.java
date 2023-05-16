package com.devsuperior.dslist.projections;

public interface GameMinProjection {
// Nesta interface projection tem que ser implementados todos os getters que são atributos do objeto Game.
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
