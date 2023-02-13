import java.util.HashMap;
public class HashMaap {
    public static void main(String args[]) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Pawan");
        map.put(2,"Kajal");
        map.put(3,"Asiya");
        
        // System.out.println(map);

        
        if(map.containsKey((1))) {
            System.out.println("Key is present is the map ");
        }
        else {
            System.out.println("Key is not present in the map");  
        }

        map.remove(1);
        System.out.println(map);
        
     
        
    }
    
}
