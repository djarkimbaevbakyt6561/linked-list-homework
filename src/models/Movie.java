package models;

import enums.Genre;

import java.util.ArrayList;

public class Movie {
    public String name;
    public  short year;
    public Genre genre;
    public Producer producer;
    public ArrayList<Actor> actors = new ArrayList<>();

    public Movie(String name, short year, Genre genre, Producer producer, ArrayList<Actor> actors) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.producer = producer;
        this.actors = actors;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", producer=" + producer +
                ", actors=" + actors +
                '}';
    }
}
