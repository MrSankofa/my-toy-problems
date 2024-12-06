import java.util.ArrayList;
import java.util.List;

public class RotLeftSolution {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int n = a.size();
        d = d % n;
        List<Integer> rotatedList = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            rotatedList.add(0);
        }
        
        for (int index = 0; index < n; index++) {
            rotatedList.set(index, a.get((index + d) % n));
        }
        
        return rotatedList;
    }
}