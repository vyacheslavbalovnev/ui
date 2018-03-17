package ru.vbalovnev.steam.ui.assembly.repository;

import org.springframework.stereotype.Repository;
import ru.vbalovnev.steam.ui.service.model.Game;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryData {

    private Map<String, Game>  map = new HashMap<>();

    public Game get(String id){
        return map.get(id);
    }

    public void clean(){
        map.clear();
    }

    public void add(String id, Game game){
        map.put(id, game);
    }
}
