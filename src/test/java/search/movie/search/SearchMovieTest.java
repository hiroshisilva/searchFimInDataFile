package search.movie.search;

import org.junit.Before;
import org.junit.Test;
import search.movie.reader.FileReader;
import search.movie.reader.Reader;

import java.io.IOException;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchMovieTest {

    private Reader reader;

    @Before
    public void setup(){
        ClassLoader classLoader = getClass().getClassLoader();
        this.reader = new FileReader(classLoader.getResource("data").getPath());
    }

    @Test
    public void test() throws IOException {

        SearchMovie searchMovie = new SearchMovie();

        Set<String> result = searchMovie.find(this.reader.readData(), "stoneybatter");

        assertThat(result.size(), equalTo(1));
    }

}
