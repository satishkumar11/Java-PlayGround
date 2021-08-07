package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {

    public static void main(String[] args) {
        String str = "a1b2";
        List<String> ans = new ArrayList<>();
        dfs(str.toCharArray(), ans, 0);
        System.out.println(ans);

        ans = bfs(str.toCharArray());
        System.out.println(ans);
    }

    public static void dfs(char[] chars, List<String> ans, int index) {
        if (index == chars.length - 1) {
            ans.add(new String(chars));
        } else {
            if (Character.isLetter(chars[index])) {
                chars[index] = Character.toLowerCase(chars[index]);
                dfs(chars, ans, index + 1);
                chars[index] = Character.toUpperCase(chars[index]);
            }
            dfs(chars, ans, index + 1);
        }
    }

    public static List<String> bfs(char[] chars) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(new String(chars));

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter((chars[i]))) {
                int size = queue.size();
                while (size-- > 0) {
                    char[] charString = queue.poll().toCharArray();
                    charString[i] = Character.toLowerCase(charString[i]);
                    queue.offer(new String(charString));

                    charString[i] = Character.toUpperCase(charString[i]);
                    queue.offer(new String(charString));
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
