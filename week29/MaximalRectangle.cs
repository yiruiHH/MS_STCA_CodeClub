/*
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */

public class MaximalRectangle {
    public int MaximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.Length == 0 || matrix[0].Length == 0) return 0;
        int row = matrix.Length;
        int col = matrix[0].Length;
        int ans = 0;
        int[,] r = new int[row, col];
        int[,] c = new int[row, col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (i == 0 && j == 0)
                {
                    r[i, j] = matrix[i][j] == '1' ? 1 : 0;
                    c[i, j] = r[i, j];
                }
                else if (i == 0)
                {
                    c[i, j] = matrix[i][j] == '1' ? 1 : 0;
                    r[i, j] = matrix[i][j] == '1' ? r[i, j - 1] + 1 : 0;
                }
                else if (j == 0)
                {
                    r[i, j] = matrix[i][j] == '1' ? 1 : 0;
                    c[i, j] = matrix[i][j] == '1' ? c[i - 1, j] + 1 : 0;
                }
                else
                {
                    if (matrix[i][j] == '1')
                    {
                        r[i, j] = r[i, j - 1] + 1;
                        c[i, j] = c[i - 1, j] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (r[i, j] != 0)
                {
                    int temp = r[i, j];
                    //Console.WriteLine(temp);
                    int w = r[i, j];
                    for (int k = i - 1; k >= 0 && r[k, j] > 0; k--)
                    {
                        w = Math.Min(w, r[k, j]);
                        temp = Math.Max(temp, w * (i - k + 1));
                    }
                    ans = Math.Max(ans, temp);
                }
            }
        }

        return ans;
    }
}
