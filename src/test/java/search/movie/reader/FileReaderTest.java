package search.movie.reader;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileReaderTest {

    private Reader reader;

    @Before
    public void setUp(){
        this.reader = new FileReader("/users/andre/Documents/workspace/cases/data/");
    }

    @Test
    public void readTest() throws IOException {
        Map<String, Set<String>> data = reader.readData();
        assertThat(data.isEmpty(), is(false));
    }


}
