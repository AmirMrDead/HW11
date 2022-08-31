package question_3;

import java.util.ArrayList;
import java.util.List;

public class QuestionThree {

    public static void unsuitable(List<Integer> integers) {
        if (integers.size() % 2 == 1)
            integers.remove(integers.size() - 1);

        for (int i = 0; i < integers.size(); i += 2) {
            if (integers.get(i) > integers.get(i + 1)) {
                integers.remove(i);
                integers.remove(i);
                i -= 2;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(7);
        integers.add(9);
        integers.add(2);
        integers.add(5);
        integers.add(5);
        integers.add(8);
        integers.add(5);
        integers.add(6);
        integers.add(3);
        integers.add(4);
        integers.add(7);
        integers.add(3);
        integers.add(1);
//        integers.add(1);
        unsuitable(integers);
        System.out.println(integers);

    }

}
