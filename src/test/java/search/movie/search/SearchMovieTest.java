package search.movie.search;

import org.junit.Test;
import search.movie.reader.FileReader;
import search.movie.reader.Reader;

import java.io.IOException;
import java.util.Set;

public class SearchMovieTest {

    @Test
    public void test() throws IOException {

        Reader reader = new FileReader("/users/andre/Documents/workspace/cases/data/");

        SearchMovie searchMovie = new SearchMovie();

        Set<String> result = searchMovie.find(reader.readData(), "walt","disney");

        result.stream().forEach(p->{
            System.out.println(p);
        });

        System.out.println("Quantidade encontrada:" + result.size());

    }

}
