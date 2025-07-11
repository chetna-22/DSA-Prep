package DP;

import java.util.HashMap;

public class practise {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("HOME", "/data/live/");
        map.put("DATE", "2019/02/01");
        map.put("DATA", "/route/to/%HOME%");

        String input = "%HOME%file_/%DATA%?%DATE%.txt";
        String result = replacePlaceholders(input, map);
        System.out.println(result); // Output: "/data/live/file_/2019/02/01.txt"
    }

    public static String replacePlaceholders(String input, HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder(input);

        for (String key : map.keySet()) {
            String placeholder = "%" + key + "%";
            System.out.println(placeholder);
            String value = map.get(key);

            int index;
            while ((index = sb.indexOf(placeholder)) != -1) {
                sb.replace(index, index + placeholder.length(), map.getOrDefault(value, value));
            }
        }

        return sb.toString();
    }
}