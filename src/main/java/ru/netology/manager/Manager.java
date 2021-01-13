package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor
public class Manager {
    private Film[] movies = new Film[0];
    private int moviesToReturn;
    private int moviesToReturnDefault = 10;

    public Manager(int moviesToReturn) {
        this.moviesToReturn = moviesToReturn;
    }

    public void add(Film movieItem) {

        Film[] tmp = new Film[movies.length + 1];

        System.arraycopy ( movies, 0, tmp, 0, movies.length );

        tmp[tmp.length - 1] = movieItem;

        movies = tmp;
    }

    public Film[] getMovies() {
        int arrayLength;//

        if ( moviesToReturn <= 0 ) moviesToReturn=moviesToReturnDefault;
        arrayLength = moviesToReturn;

        if ( moviesToReturn > movies.length ) {
            arrayLength = movies.length;
        }


        Film[] result = new Film[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }
}