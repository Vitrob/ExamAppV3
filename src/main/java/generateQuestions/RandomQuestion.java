package generateQuestions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomQuestion {

    List<Integer> idNumbers = new ArrayList<>();

    public List<Integer> get5RandomNumbers() {
        List<Integer> range = IntStream.range(1, 11).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(range);
        System.out.println();
       idNumbers =  range.subList(0, 5);
        return idNumbers;
    }

    public List<Integer> get5RandomNumbersV2() {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int i = 0; i < 5; i++) {

            idNumbers.add(i);
        }

        return idNumbers;
    }

}
