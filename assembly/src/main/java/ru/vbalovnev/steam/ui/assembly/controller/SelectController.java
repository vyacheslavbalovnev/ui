package ru.vbalovnev.steam.ui.assembly.controller;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vbalovnev.steam.ui.assembly.model.GameInfo;
import ru.vbalovnev.steam.ui.assembly.model.Greeting;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SelectController {

    @RequestMapping("/select")
    public List<GameInfo> select(@RequestParam(value="query") String query) {
        List<GameInfo> list = new ArrayList<>();
        list.add(new GameInfo("nameOfGame", 1999, "Dev", "Publ"));
        list.add(new GameInfo("nameOfGame1", 2000, "ev", "Publ1"));
        return list;
    }
}
