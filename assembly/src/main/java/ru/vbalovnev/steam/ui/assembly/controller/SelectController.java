package ru.vbalovnev.steam.ui.assembly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vbalovnev.steam.ui.assembly.repository.RepositoryData;
import ru.vbalovnev.steam.ui.service.GameService;
import ru.vbalovnev.steam.ui.service.model.Game;
import ru.vbalovnev.steam.ui.service.model.GameGenre;
import ru.vbalovnev.steam.ui.assembly.model.GameInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class SelectController {

    @Autowired
    private GameService gameService;

    @Autowired
    private RepositoryData repositoryData;

    @RequestMapping("/select")
    public List<GameInfo> select(@RequestParam(value="query") GameGenre query) {

        List<Game> games = gameService.select(query);

        repositoryData.clean();
        games
            .stream()
            .forEach(
                    game -> {
                        repositoryData.add(game.getId(), game);
                }
            );

        return games
            .stream()
            .map(transform)
            .collect(Collectors.toList());
    }

    public Function<Game, GameInfo> transform =
        i -> new GameInfo(i.getId(),i.getName(), i.getYearOfRelease(), i.getDeveloper(), i.getPublisher());
}
