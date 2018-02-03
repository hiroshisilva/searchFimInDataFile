package search.movie.reader;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface Reader {

    Map<String, Set<String>> readData() throws IOException;
}
