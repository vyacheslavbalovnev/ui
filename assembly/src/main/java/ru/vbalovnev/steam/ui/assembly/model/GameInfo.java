package ru.vbalovnev.steam.ui.assembly.model;

public class GameInfo {

    private String id;
    private String name;
    private int yearOfRelease;
    private String developer;
    private String publisher;
    private String image;

    public GameInfo(String id, String name, int yearOfRelease, String developer, String publisher, String image) {
        this.id = id;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.developer = developer;
        this.publisher = publisher;
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

    public String getImage() {
        return image;
    }
}
