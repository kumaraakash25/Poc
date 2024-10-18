import java.util.HashMap;
import java.util.Map;

public class IsomorphString {
    public boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int wLength = str1.length();

        Map<Character, Character> map = new HashMap<>();

        for (int count = 0; count < wLength; count++) {
            if (map.containsKey(str1.charAt(count))) {
                char complement = map.get(str1.charAt(count));
                if (complement != str2.charAt(count)) {
                    return false;
                }
            } else {
                map.put(str1.charAt(count), str2.charAt(count));
            }
        }
        return true;
    }
}
