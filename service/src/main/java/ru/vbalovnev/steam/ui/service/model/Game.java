package ru.vbalovnev.steam.ui.service.model;

public class Game {

    private String id;
    private String name;
    private int yearOfRelease;
    private String developer;
    private String publisher;
    private String description;
    private String image;

    public Game(String id, String name, int yearOfRelease, String developer, String publisher, String description, String image) {
        this.id = id;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.developer = developer;
        this.publisher = publisher;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
