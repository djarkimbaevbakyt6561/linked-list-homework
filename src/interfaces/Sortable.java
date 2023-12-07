package interfaces;

import models.Movie;

import java.util.List;

public interface Sortable {
    List<Movie> sortByMovieName(String ascOrDesc);
    List<Movie> sortByProducerName(String ascOrDesc);
    List<Movie> sortByYear(String ascOrDesc);
}
