package search.movie.reader;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileReaderTest {

    private Reader reader;

    @Before
    public void setUp() throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();

        this.reader = new FileReader(classLoader.getResource("data").getPath());
    }

    @Test
    public void readTest() throws IOException {
        Map<String, Set<String>> data = reader.readData();
        assertThat(data.isEmpty(), is(false));
    }


}
