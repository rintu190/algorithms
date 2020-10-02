package com.company.datastructures.arrays;

import java.util.Scanner;

public class Kadane {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        System.out.println("Kadane's Algorithm\n");
        Kadane k= new Kadane();
        System.out.println("Enter Array size:");
        int n= s.nextInt();
        System.out.println("enter"+ n +"numbers");
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int sum = k.maxSumSubarray(a);
        System.out.println("maximum sum =" + sum);
    }

    private int maxSumSubarray(int[] a) {
        int maxSoFar =a[0];
        int maxEndHere = a[0];

        for(int i=1;i<a.length;i++){
            if(maxEndHere < 0)
                maxEndHere =0;
            else
                maxEndHere += a[i];

            if(maxEndHere >= maxSoFar)
                maxSoFar = maxEndHere;
        }
        return maxSoFar;
    }
}
