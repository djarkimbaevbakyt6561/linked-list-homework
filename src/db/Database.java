package db;

import enums.Genre;
import interfaces.Findable;
import models.Actor;
import models.Movie;
import models.Producer;

import java.util.ArrayList;
import java.util.List;

public class Database implements Findable {

    private final List<Movie> movies = new ArrayList<>(List.of(new Movie("Avatar", (short) 2014, Genre.FANTASY, new Producer("Baha", "Bahov"), new ArrayList<Actor>(List.of(new Actor("Hi Hiov", "Hey Heyov")))), new Movie("Djumandji", (short) 2018, Genre.FANTASY, new Producer("Bahaha", "Bahahov"), new ArrayList<Actor>(List.of(new Actor("Handjo Handjoev", "Hyu Hyuiv"))))));
    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public Movie findMovieByNameOrPartName(String name) {
        for (Movie movie : movies) {
            if (movie.name.equals(name) || movie.name.contains(name)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : movies) {
            for (Actor actor : movie.actors) {
                if (actor.fullName.equals(actorName)) {
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(int year) {
        for (Movie movie : movies) {
            if (movie.year == year) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerName) {
        for (Movie movie : movies) {
            if (movie.producer.firstName.equals(producerName)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public List<Movie> findMovieByGenre(Genre genre) {
        List<Movie> foundMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.genre == genre) {
                foundMovies.add(movie);
            }
        }
        if (foundMovies.isEmpty()) {
            return null;

        } else {
            return foundMovies;
        }
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : movies) {
            for (Actor actor : movie.actors) {
                if (actor.role.equals(role)) {
                    return movie;
                }
            }
        }
        return null;
    }
}
