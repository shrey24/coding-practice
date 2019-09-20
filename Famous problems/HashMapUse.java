import java.util.*;

class HashMapUse{

    
    public List<String> fizzBuzz(int n) {
    
        // ans list
        List<String> ans = new ArrayList<String>();
        
        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict =
            new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
            };
    
        for (int num = 1; num <= n; num++) {
    
        String numAnsStr = "";
    
        for (Integer key : fizzBizzDict.keySet()) {
    
            // If the num is divisible by key,
            // then add the corresponding string mapping to current numAnsStr
            if (num % key == 0) {
            numAnsStr += fizzBizzDict.get(key);
            }
        }
    
        if (numAnsStr.equals("")) {
            // Not divisible by 3 or 5, add the number
            numAnsStr += Integer.toString(num);
        }
    
        // Append the current answer str to the ans list
        ans.add(numAnsStr);
        }
    
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println("run");

        /**    Linked Hash Map (Ordered HM implemented with linked list) */
        int cap = 3;
        Float defaultLoadFactor = 0.75F;
        boolean accessOrder = true;
        LinkedHashMap<Integer, Integer> LRU = 
        new LinkedHashMap<Integer, Integer>(cap, defaultLoadFactor, accessOrder){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cap; 
            }
        };

        LRU.put(1, 1);
        LRU.put(2, 2);
        LRU.put(3, 3);
        LRU.put(4, 4);
        System.out.println(LRU.get(2));    
        System.out.println(LRU);
        System.out.println(LRU.get(1));

    }

}