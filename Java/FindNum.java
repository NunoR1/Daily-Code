import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FindNum {
    public static void main(String[] args) {
        generateList();
        
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

    public static void whatsThatNum(Integer theList) {
        for (Object i : theList) {
            
        }
    }
}
