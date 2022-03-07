import java.util.Stack;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int solution1(String s) {
        // 时间复杂度 O（n） 空间复杂度 O(1)
        int length = s.length();
        int start = 0;
        int end = length - 1;

        // 去除首尾的空格
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            if (ch == ' ')
                continue;
            else {
                start = i;
                break;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == ' ')
                continue;
            else {
                end = i;
                break;
            }
        }

        // 至少存在一个单词，所以此处必有end > start, 不做检查
        int res = 0;
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                res = 0;
            else
                res++;

        }

        return res;
    }

    public int solution2(String s) {
        // 时间复杂度 O（n） 空间复杂度 O(n)
        // 强制stack最后为空
        s = s + " ";
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for(char ch: s.toCharArray()) {
            if (ch == ' ') {
                if (stack.size() > 0) res = stack.size();
                stack.removeAllElements();
            } else stack.push(ch);
        }

        return res;
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        return solution2(s);
    }
}
// @lc code=end
