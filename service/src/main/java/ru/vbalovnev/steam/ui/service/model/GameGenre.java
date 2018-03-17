package ru.vbalovnev.steam.ui.service.model;

public enum GameGenre {

    FPS(1),
    TPA(2),
    SURVIVAL_HORROR(3),
    RPG(4),
    Adventure(5),
    STORY(6),
    OTHER(7);

    private final int sheetId;

    GameGenre(int sheetId) {
        this.sheetId = sheetId;
    }

    public int getSheetId() {
        return sheetId;
    }
}
