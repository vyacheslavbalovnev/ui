package ru.vbalovnev.steam.ui.service.imp;

import org.springframework.stereotype.Service;
import ru.vbalovnev.steam.ui.service.GameService;
import ru.vbalovnev.steam.ui.service.model.Game;
import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Override
    public List<Game> select(GameGenre query) {
        List<Game> list = new ArrayList<>();
        list.add(new Game("nameOfGame", 1999, "Dev", "Publ"));
        list.add(new Game("nameOfGame1", 2000, "ev", "Publ1"));
        return list;
    }
}
