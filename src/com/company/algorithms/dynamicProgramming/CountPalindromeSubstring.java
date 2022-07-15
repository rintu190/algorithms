package com.company.algorithms.dynamicProgramming;

import java.util.Arrays;

public class CountPalindromeSubstring {
    static int dp[][]= new int[1000][1000];
    public static void main(String args[]){
        String s = "abbaeae";
        System.out.println((countSubStrings(s)));
    }
    public static int countSubStrings(String s){
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPal(s,i,j)!=0){
                    count++;
                }
            }
        }
        return count;
    }
    public static int isPal(String s,int i,int j){
        if(i>j)
            return 1;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) != s.charAt(j))
            return dp[i][j]=0;
        return dp[i][j]= isPal(s,i+1,j-1);
    }
}
