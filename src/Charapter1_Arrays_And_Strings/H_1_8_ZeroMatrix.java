package Charapter1_Arrays_And_Strings;

import java.util.HashSet;

public class H_1_8_ZeroMatrix {

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
     * and col are set to 0.
     */

    public static void main(String[] args) {
        H_1_8_ZeroMatrix zeroMatrix = new H_1_8_ZeroMatrix();
        int[][][] matrixes = new int[][][]{
                {
                    {1,0},
                    {4,3}
                },
                {
                    {1,3,2},
                    {2,9,5},
                    {4,0,3}
                },
                {
                    {0,3,3,2},
                    {2,1,2,4},
                    {2,0,3,4},
                    {4,5,5,3}

                },
                {
                    {1,3,3,3,0,1,1},
                    {2,0,3,2,4,1,2},
                    {2,6,1,4,4,1,3},
                    {2,4,5,3,4,1,4},
                    {4,5,5,0,3,1,5}
                }
        };

        for(int i=0; i<matrixes.length; i++){
            matrixes[i] = zeroMatrix.solution(matrixes[i]);
            zeroMatrix.print(matrixes[i]);
        }
    }

    /*
        Time Complexity: O(n^2)
        Space Complexity: O(n)
     */
    private int[][] solution(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        HashSet<Integer> iToSetToZero = new HashSet<>();
        HashSet<Integer> jToSetToZero = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    iToSetToZero.add(i);
                    jToSetToZero.add(j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(iToSetToZero.contains(i) || jToSetToZero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    private void print(int[][] matrix){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                stringBuilder.append(matrix[i][j]);
                stringBuilder.append(", ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("_________________________\n");
        System.out.print(stringBuilder);
    }

}
