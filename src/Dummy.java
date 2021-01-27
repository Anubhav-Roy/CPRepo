
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Link :-
 *
 */

public class Dummy {

    public static void main(String[] args){
        List<TestClass> asd = new ArrayList<>();
        Collections.sort(asd);
    }

    public static class TestClass implements Comparable<TestClass> {
        int var;

        @Override
        public int compareTo(TestClass testClass) {
            return 0;
        }
    }


}
