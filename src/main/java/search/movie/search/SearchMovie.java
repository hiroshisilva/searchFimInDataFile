package search.movie.search;


import java.util.*;
import java.util.stream.Collectors;


public class SearchMovie {


    public Set<String> find(Map<String, Set<String>> dataSet,String... filterString){
        List<String> filter = Arrays.asList(filterString);

        return dataSet.entrySet().parallelStream().filter(p -> p.getValue().containsAll(filter)).map(k-> k.getKey()).collect(Collectors.toSet());
    }

}
