package ru.vbalovnev.steam.ui.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vbalovnev.steam.ui.service.GameService;
import ru.vbalovnev.steam.ui.service.dao.XlsReader;
import ru.vbalovnev.steam.ui.service.model.Game;
import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private XlsReader xlsReader;


    @Override
    public List<Game> select(GameGenre query) {

        List<List<String>> data = xlsReader.getData(query);
        List<Game> list = new ArrayList<>();
        for (List<String> row : data) {
            list.add(
                new Game(
                    row.get(0),
                    row.get(1),
                    Integer.valueOf(row.get(2)),
                        row.get(3),
                        row.get(4)
                )
            );

        }

//        list.add(new Game("nameOfGame", 1999, "Dev", "Publ"));
//        list.add(new Game("nameOfGame1", 2000, "ev", "Publ1"));
        return list;
    }
}
