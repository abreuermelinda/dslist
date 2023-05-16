package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//A annotation @Component ou @Service serve para registrar que essa classe GameService é um componente do sistema,
// já que ela é uma classe comum e não está herdando de nada, diferente da interface GameRepository que está herdando do JpaRepository,
// ela tem que ser registrada como um pomponente do sistema pois o spring vai gerenciar esses componentes, instanciá-los e reaproveitá-los.
@Service
public class GameService {

    //A annotation @Autowired serve para injetar o GameRepository dentro do GameService.
    //Isso faz com que o GameService chame o GameRepository através da instância gameRepository.
    @Autowired
    private GameRepository gameRepository;

    //Criando um método para buscar os objetos do banco por id:
    //Annotation que serve para que o Service fique transacional, ou seja, para que seja garatida que a operação
    // com o banco de dados vai acontecer obedecendo o princípio das transações (ACID - Atômica, Consistente, Isolada e Durável).
    //O argumento readyOnly = true vai assegurar que não será feita nenhuma operação de escrita, logo naõ vai bloquear o banco pra escrita ficando mais rápida a transação.
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get(); //Como o finById do Repository retorna um tipo optional, logo, tem que colocar o método get() para pegar o game que está dentro desse optional.
        GameDTO dto = new GameDTO(result); //Convertendo um objeto Game para um objeto GameDTO.
        return dto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        //Abaixo é chamado o GameRepository e busca todos os objetos do banco através do método findAll e devolve uma lista de objetos.
        List<Game> result = gameRepository.findAll();
        //Abaixo é convertido cada objeto Game para um GameMinDTO.
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //O stream é uma lib do Java que permite fazer operções com sequências de dados. Assim vai transformar a lista de Game para uma lista GameMinDTO.
        return dto;
    }

    //Pegando a lista de projection:
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
