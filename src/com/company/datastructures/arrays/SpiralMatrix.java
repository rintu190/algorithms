package com.company.datastructures.arrays;

public class SpiralMatrix {
    public static void main(String[] args){
        int row =3;
        int col = 6;
        int[][] arr = {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18}
        };
        printSpiralMatrix(row,col,arr);
    }

    private static void printSpiralMatrix(int row, int col, int[][] arr) {
        int i, k=0, l=0;
        //k = start row index
        // l = start col index
        while(k<row && l<col){
            //first row from remaining
            for(i=0;i<col;i++){
                System.out.println(arr[k][i] + " ");
            }
            k++;
            //last column from remaining
            for(i=k;i<row;++i){
                System.out.println(arr[i][col-1] + " ");
            }
            col--;
            //last row from remaining
            if(k<row){
                for(i=col-1;i>=l;--i){
                    System.out.println(arr[row-1][i] + " ");
                }
                row--;
            }
            //first column from remaining
            if(l<col){
                for(i=row-1;i>=k;--i){
                    System.out.println(arr[i][l] + " ");
                }
                l++;
            }
        }

    }
}
