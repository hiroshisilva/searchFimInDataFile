package search.movie;


import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import search.movie.reader.FileReader;
import search.movie.reader.Reader;
import search.movie.search.SearchMovie;

import java.io.IOException;
import java.util.*;

public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        if(args.length > 0) {


            StringTokenizer tokenizer = new StringTokenizer(args[0]);
            List<String> tokens = new ArrayList<>();
            while(tokenizer.hasMoreTokens()) {
                tokens.add(tokenizer.nextToken().trim());
            }

            Reader reader = new FileReader("data");
            Map<String, Set<String>> dataset;

            StopWatch stopWatchReader = new Log4JStopWatch("load Data");
            dataset = reader.readData();
            stopWatchReader.stop("load Data");

            System.out.println(String.format("Foram carregados %d registros",dataset.size()));

            SearchMovie searchMovie = new SearchMovie();

            StopWatch stopWatchSearch = new Log4JStopWatch("search data");
            Set<String> result = searchMovie.find(dataset, tokens.toArray(new String[0]));
            stopWatchSearch.stop("search data");

            System.out.println(String.format("Foram encontrados %d registros",result.size()));
            result.parallelStream().forEach(System.out::println);


        }else{
            System.out.println("Não foram passados os dados de busca!");
        }

    }

}
