package ru.vbalovnev.steam.ui.service;

import ru.vbalovnev.steam.ui.service.model.Game;
import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.util.List;

public interface GameService {

    List<Game> select(GameGenre query);
}
