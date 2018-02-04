package search.movie.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileReader implements Reader{

    private String directory;


    public FileReader(String directory) {
        this.directory = directory;
    }

    @Override
    public Map<String, Set<String>> readData() throws IOException {

        Map<String, Set<String>> result = new HashMap<>();

        Files.list(Paths.get(directory)).parallel().forEach(file ->{

            try {
                Set<String> words = readFile(file);
                result.put(file.getFileName().toString(), words);
            } catch (IOException e) {
               System.err.println(e);
            }
        });


        return result;
    }

    private Set<String> readFile(Path file) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(file);

        Set<String> content = new HashSet<String>();
        bufferedReader.lines().forEach(line ->{
            StringTokenizer stringTokenizer = new StringTokenizer(line);

            while (stringTokenizer.hasMoreTokens()){
                content.add(stringTokenizer.nextToken());
            }

        });

        bufferedReader.close();

        return content;
    }




}
