package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager = new Manager();
    private Film first = new Film(1, 1, "Бладшот", "боевик");
    private Film second = new Film(2, 2, "Вперёд", "мультфильм");
    private Film third = new Film(3, 3, "Отель 'Белград'", "комедия");
    private Film fourth = new Film(4, 4, "Джентльмены", "боевик");
    private Film fifth = new Film(5, 5, "Человек-невидимка", "ужасы");
    private Film sixth = new Film(6, 6, "Тролли. Мировой тур", "мультфильм");
    private Film seventh = new Film(7, 7, "Номер один", "комедия");
    private Film eighth = new Film(8, 8, "Домовой", "комедия");
    private Film ninth = new Film(9, 9, "Аладин", "приключения");
    private Film tenth = new Film(10, 10, "Дитя робота", "фантастика");
    private Film eleven = new Film(11, 11, "Бизнесмены", "драма");

    @Test
    void shouldAdd() {
        Film[] expected = new Film[]{first};

        manager.add(first);

        assertArrayEquals(expected, manager.getMovies());
    }


    @Test
    void shouldReturnAllMoviesForDefault() {
        Film[] expected = new Film[]{eleven,tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleven);

        assertArrayEquals(expected, manager.getMovies());
    }


    @Test
    void shouldReturnMoviesWithMoviesToReturned() {
        Manager manager = new Manager(5);
        Film[] expected = new Film[]{fifth, fourth, third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        assertArrayEquals(expected, manager.getMovies());
    }


    @Test
    void shouldEmptyArrayMovies() {
        assertArrayEquals(new Film[0], manager.getMovies());
    }


    @Test
    void shouldReturnLastFourIfMoviesToReturnSix() {
        Manager manager = new Manager(6);
        Film[] expected = new Film[]{fourth, third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertArrayEquals(expected, manager.getMovies());
    }


    @Test
    void shouldReturnEmptyArrayIfAddMoviesAndMoviesToReturnZero() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        Manager manager = new Manager(0);
        Film[] expected = new Film[0];

        assertArrayEquals(expected, manager.getMovies());
    }


    @Test
    void shouldReturnDefaultIfLessZero() {
        manager = new Manager(-4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, manager.getMovies());
    }
}