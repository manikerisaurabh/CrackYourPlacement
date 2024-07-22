import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    class Solution {
        public int minDeletions(String s) {
            Map<Character, Integer> map = new HashMap<>();
            System.out.println(map);

            for (int i = 0; i < s.length(); i++)
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            int result = 0;
            HashSet<Integer> set = new HashSet<>();

            for (Map.Entry<Character, Integer> mapElement : map.entrySet()) {
                int currentVal = mapElement.getValue();
                if (!set.contains(currentVal))
                    set.add(currentVal);
                else {
                    while (set.contains(currentVal) && currentVal > 0) {
                        currentVal--;
                        result++;
                    }
                    if (currentVal > 0)
                        set.add(currentVal);
                }
            }
            return result;
        }
    }
}
