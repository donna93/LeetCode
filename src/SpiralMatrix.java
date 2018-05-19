import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
54. Spiral Matrix
DescriptionHintsSubmissionsDiscussSolution
Given a matrix of m x n elements (m rows, n columns), return all elements of
the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0 || matrix[0] == null)
            return res;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd && colBegin <= colEnd){
                for(int i = colEnd; i >= colBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(rowBegin <= rowEnd && colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
    public static void main(String[]args){
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[][] matrix2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        System.out.println(spiralOrder(matrix1).toString());
        System.out.println(spiralOrder(matrix2).toString());
    }
}
