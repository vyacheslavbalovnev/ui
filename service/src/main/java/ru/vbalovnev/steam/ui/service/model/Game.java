package ru.vbalovnev.steam.ui.service.model;

public class Game {

    private String name;
    private int yearOfRelease;
    private String developer;
    private String publisher;

    public Game(String name, int yearOfRelease, String developer, String publisher) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.developer = developer;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }
}
