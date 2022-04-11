package generateQuestions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomQuestion {


    public static void get5RandomNumbers() {
        List<Integer> range = IntStream.range(1, 11).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(range);
        range.subList(0, 5).forEach(System.out::println);
    }

    public static void get5RandomNumbersV2() {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }

}
