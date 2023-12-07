package interfaces;

import enums.Genre;
import models.Movie;

import java.util.List;

public interface Findable {
    List<Movie> getAllMovies();
    Movie findMovieByNameOrPartName(String name);
    Movie findMovieByActorName(String actorName);
    Movie findMovieByYear(int year);
    Movie findMovieByProducer(String producerName);
    List<Movie> findMovieByGenre(Genre genre);
    Movie findMovieByRole(String role);

}
