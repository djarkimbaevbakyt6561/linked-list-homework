import db.Database;
import enums.Genre;
import models.Movie;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    1. Все фильмы
                    2. Найти фильм по названию или по фрагменту
                    3. Найти фильм по актеру
                    4. Найти фильм по продюссеру
                    5. Найти фильм по году
                    6. Найти фильм по жанру
                    7. Найти фильм по роли
                    8. Сортировать по название фильма
                    9. Сортировать по году фильма
                    10.Сортировать по имени продюссеров
                    11.Выйти""");
            String num = scanner.nextLine();
            switch (num) {
                case "1" -> {
                    System.out.println("Все фильмы: ");
                    for (Movie movie : database.getAllMovies()) {
                        System.out.println(movie);
                    }
                }
                case "2" -> {
                    System.out.print("Введите название: ");
                    Movie movie = database.findMovieByNameOrPartName(scanner.nextLine());
                    if (movie == null) {
                        System.out.println("Фильм не найден!");
                    } else {
                        System.out.println(movie);
                    }
                }
                case "3" -> {
                    System.out.print("Введите имя актера: ");
                    Movie movie = database.findMovieByActorName(scanner.nextLine());
                    if (movie == null) {
                        System.out.println("Фильм не найден!");
                    } else {
                        System.out.println(movie);
                    }
                }
                case "4" -> {
                    System.out.print("Введите имя продюссера: ");
                    Movie movie = database.findMovieByProducer(scanner.nextLine());
                    if (movie == null) {
                        System.out.println("Фильм не найден!");
                    } else {
                        System.out.println(movie);
                    }
                }
                case "5" -> {
                    try {
                        System.out.print("Введите год: ");
                        Movie movie = database.findMovieByYear(scanner.nextShort());
                        if (movie == null) {
                            System.out.println("Фильм не найден!");
                        } else {
                            System.out.println(movie);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Введите правильный год!");
                    }

                }
                case "6" -> {
                    try {
                        System.out.print("Введите жанр: ");
                        List<Movie> movies = database.findMovieByGenre(Genre.valueOf(scanner.nextLine().toUpperCase()));
                        if (movies == null) {
                            System.out.println("Фильм не найден!");
                        } else {
                            System.out.println("Фильмы: ");
                            for (Movie movie : movies) {
                                System.out.println(movie);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неправильный жанр!");
                    }

                }
                case "7" -> {
                    System.out.print("Введите роль актера: ");
                    Movie movie = database.findMovieByRole(scanner.nextLine());
                    if (movie == null) {
                        System.out.println("Фильм не найден!");
                    } else {
                        System.out.println(movie);
                    }
                }
                case "8" -> {
                    try {
                        System.out.println("Введите по: (1)Возрастанию (2)Убыванию");
                        int number = scanner.nextInt();
                        if (number == 1) {
                            List<Movie> sortedMovies = database.sortByMovieName("Ascending");
                            System.out.println("По возрастанию:");
                            for (Movie movie : sortedMovies) {
                                System.out.println(movie);
                            }
                        } else if (number == 2) {
                            List<Movie> sortedMovies = database.sortByMovieName("Descending");
                            System.out.println("По убыванию:");
                            for (Movie movie : sortedMovies) {
                                System.out.println(movie);
                            }
                        } else {
                            System.out.println("Введите правильное число!");
                        }
                        scanner.nextLine();

                    } catch (InputMismatchException e) {
                        System.out.println("Введите число!");
                    }
                }
                case "9" -> {
                    try {
                        System.out.println("Введите по: (1)Возрастанию (2)Убыванию");
                        int number = scanner.nextInt();
                        if (number == 1) {
                            List<Movie> sortedMovies = database.sortByYear("Ascending");
                            System.out.println("По возрастанию:");
                            for (Movie movie : sortedMovies) {
                                System.out.println(movie);
                            }
                        } else if (number == 2) {
                            List<Movie> sortedMovies = database.sortByYear("Descending");
                            System.out.println("По убыванию:");
                            for (Movie movie : sortedMovies) {
                                System.out.println(movie);
                            }
                        } else {
                            System.out.println("Введите правильное число!");
                        }
                        scanner.nextLine();

                    } catch (InputMismatchException e) {
                        System.out.println("Введите число!");
                    }

                }
                case "10" -> {
                    try {
                        System.out.println("Введите по: (1)Возрастанию (2)Убыванию");
                        int number = scanner.nextInt();
                        if (number == 1) {
                            List<Movie> sortedMovies = database.sortByProducerName("Ascending");
                            System.out.println("По возрастанию:");
                            for (Movie movie : sortedMovies) {
                                System.out.println(movie);
                            }
                        } else if (number == 2) {
                            List<Movie> sortedMovies = database.sortByProducerName("Descending");
                            System.out.println("По убыванию:");
                            for (Movie movie : sortedMovies) {
                                System.out.println(movie);
                            }
                        } else {
                            System.out.println("Введите правильное число!");
                        }
                        scanner.nextLine();

                    } catch (InputMismatchException e) {
                        System.out.println("Введите число!");
                    }

                }
                case "11" -> {
                    exit = true;
                    System.out.println("Вы успешно вышли!");
                }
            }
        }
    }
}