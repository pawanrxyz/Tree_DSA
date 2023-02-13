import java.util.*;
public class Queee {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(null);
        Integer CurrData = q.remove();
        System.out.println(CurrData);
    }
    
}
