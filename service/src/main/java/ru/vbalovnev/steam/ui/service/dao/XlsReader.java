package ru.vbalovnev.steam.ui.service.dao;

import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.util.List;

public interface XlsReader {

    List<List<String>> getData(GameGenre sheetId);


}
