package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//A anotation @Component ou @Service serve para registrar que essa classe GameService é um componente do sistema,
// já que ela é uma classe comum e não está herdando de nada, diferente da interface GameRepository que está herdando do JpaRepository,
// ela tem que ser registrada como um pomponente do sistema pois o spring vai gerenciar esses componentes, instanciá-los e reaproveitá-los.
@Service
public class GameService {

    //A anotation @Autowired serve para injetar o GameRepository dentro do GameService.
    //Isso faz com que o GameService chame o GameRepository através da instância gameRepository.
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //O stream é uma lib do Java que permite fazer operções com sequências de dados. Assim vai transformar a lista de Game para uma lista GameMinDTO.
        return dto;
    }
}
