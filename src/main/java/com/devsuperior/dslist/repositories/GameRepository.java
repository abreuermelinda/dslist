package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//O Repository é o objeto responsável por fazer consultas ao banco de dados. Como está sendo usado um desenvolvimento orientado por domínio,
// logo como tem uma entidade Game o repository que for trabalhar com Game será chamado de GameRepository e esse repository vai acessar os dados de Game.
// E para acessar esses dados e ser capaz de manipular esses dados deve-se estender essa interface para o JpaRepository e nele tem que colocar
// o tipo da entidade (Game) e o tipo do id da entidade (Long).
public interface GameRepository extends JpaRepository<Game, Long> {
}
