package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//O Repository é o objeto responsável por fazer consultas ao banco de dados. Como está sendo usado um desenvolvimento orientado por domínio,
// logo como tem uma entidade Game o repository que for trabalhar com Game será chamado de GameRepository e esse repository vai acessar os dados de Game.
// E para acessar esses dados e ser capaz de manipular esses dados deve-se estender essa interface para o JpaRepository e nele tem que colocar
// o tipo da entidade (Game) e o tipo do id da entidade (Long).
public interface GameRepository extends JpaRepository<Game, Long> {
    //O argumento nativeQuery da anotação @Query é uma condição para fazer funcionar a consulta SQL.
	//Porém quando o nativeQuery é usado o resultado da consulta tem que ser uma interface (Projection).
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
	List<GameMinProjection> searchByList(Long listId);
}
