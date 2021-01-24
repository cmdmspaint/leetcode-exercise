package suanfa.playWithAlgorithmInterview.a08LongestSubstringWithoutRepeatingCharacters.Solution3.src;

// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        while( r + 1 < s.length() ){

            while( r + 1 < s.length() && freq[s.charAt(r+1)] == 0 )
                freq[s.charAt(++r)] ++;

            res = Math.max( res , r-l+1);

            if( r + 1 < s.length() ){
                freq[s.charAt(++r)] ++;
                assert( freq[s.charAt(r)] == 2 );
                while( l <= r && freq[s.charAt(r)] == 2 )
                    freq[s.charAt(l++)] --;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution()).lengthOfLongestSubstring( "" ));
    }
}
