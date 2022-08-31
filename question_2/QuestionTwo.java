package question_2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class QuestionTwo {

    public static void union(Set<Character> charactersOne, Set<Character> charactersTwo){
        Set<Character> union = new TreeSet<>();
        union.addAll(charactersOne);
        union.addAll(charactersTwo);
        System.out.println(union);
    }

    public static void subscription(Set<Character> charactersOne, Set<Character> charactersTwo){
        Set<Character> subscription = new TreeSet<>();
        for(Character character : charactersOne)
            if(!charactersTwo.add(character))
                subscription.add(character);
        System.out.println(subscription);
    }

    public static void main(String[] args) {

        Set<Character> charactersOne = new TreeSet<>();
        Set<Character> charactersTwo = new TreeSet<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(97, 123);
            if (!charactersOne.add((char) rand)) {
                i--;
            }
        }
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(97, 123);
            if (!charactersTwo.add((char) rand)) {
                i--;
            }
        }
        System.out.println(charactersOne);
        System.out.println(charactersTwo);
        union(charactersOne,charactersTwo);
        subscription(charactersOne,charactersTwo);
    }
}
