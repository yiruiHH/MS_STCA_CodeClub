/*
 * https://leetcode-cn.com/problems/decoded-string-at-index/
 */

public class DecodeAtIndex {
    public string DecodeAtIndex(string S, int K) {
        long size = 0;
        int length = S.Length;
        foreach(char c in S)
        {
            if (char.IsDigit(c)) size *= (c - '0');
            else size++;
        }

        for(int i = length - 1; i >= 0; i--)
        {
            char c = S[i];
            K = (int)(K % size);
            if(K == 0 && char.IsLetter(c))
            {
                return c.ToString();
            }
            if (char.IsDigit(c)) size /= (c - '0');
            else size--;
        }
        return null;
    }
}
