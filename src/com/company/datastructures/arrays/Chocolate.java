package com.company.datastructures.arrays;

import java.util.Arrays;

public class Chocolate {
    public static void main(String[] args){
        int a[]= {10,2,5,7,1,21,23,39,28,38,26,40,28,42,46,41,48};
        int m =7; //no of students

        int n = a.length;
        System.out.println("minimum is : " + findMinimum(a,n,m));
    }
    static int findMinimum(int a[],int n, int m){

        if(m == 0 || n == 0){
            return 0;
        }
        //first sort the array
        Arrays.sort(a);

        //if no of packets less than students
        if(n < m)
            return -1;

        int min_diff = Integer.MAX_VALUE;

        //find the subarray with min difference
        int first =0; int last =0;
        //we will add m (no of students to i to get the last item of subarray)
        // if the subarray difference comes less from old difference we will replace it
        // and we will get the subaaray with minimum difference
        for(int i=0;i+m-1 <n;i++){
            int diff = a[i+m-1]- a[i];
            if(diff < min_diff){
                min_diff =diff;
                first =i;
                last = i+m-1;
            }
        }
        return (a[last]-a[first]);
    }
}
