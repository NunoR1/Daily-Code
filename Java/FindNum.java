import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FindNum {
    public static void main(String[] args) {
        whatsThatNum(generateList());
        
    }

    public static List<Integer> generateList() {
        int listSize = ThreadLocalRandom.current().nextInt(1, 16);
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            numList.add(i + 1);
        }
      
        numList.remove(ThreadLocalRandom.current().nextInt(0, numList.size()));
        
        System.out.println(numList);

        return numList;
    }

    public static void whatsThatNum(List<Integer> theList) {
        boolean found = false;
        for (int i = 1; i < theList.size() + 1; i++) {
            if (theList.get(i - 1) != i) {
                theList.add(i - 1, i);
                found = true;
            }
        }

        if (!found) {
            theList.addLast(theList.size() + 1);
        }

        System.out.println(theList);
    }
}