package _202108_AugustLeetCodingChallenge;

import java.util.*;
import java.util.stream.Collectors;

public class _49_GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs)
                    .collect(Collectors.groupingBy(str -> {
                        char[] array = str.toCharArray();
                        Arrays.sort(array);
                        return new String(array);
                    })).values());
        }
    }

    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word : strs) {
                char[] keys = new char[26];
                for (char c : word.toCharArray()) {
                    keys[c - 'a']++;
                }

                String key = new String(keys);

                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(word);
            }

            List<List<String>> res = new ArrayList<>();
            res.addAll(map.values());
            return res;
        }
    }
}
