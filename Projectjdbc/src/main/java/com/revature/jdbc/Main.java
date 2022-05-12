package com.revature.jdbc;
import java.util.*; 
import java.lang.*;
import java.io.*;
import java.lang.Math;

public class Main {
        public static int unchangedIndex(int N, int A[]) {
            //this is default OUTPUT. You can change it
            int result=0;
            int[] array = {A.length};
            int temp;
            //WRITE YOUR LOGIC HERE:
            for(int a = 0; a<A.length; a++){
                array[a] = A[a];
            }
            for(int i = 0; i<A.length-1;i++){
                for(int j = i+1; j<A.length-1;j++){
            
                if(A[i]>A[j]){
                    //swap
                    temp= A[i];
                    A[i]= A[j];
                    A[j] = temp;}
            }
            for(int b = 0; b<A.length-1; b++){
                if (array[b] == A[b])
                result += 1;

            }
                            }
            return result;
        }
        public static void main(String[] args) {
            // INPUT [uncomment & modify if required]
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            
            int A [] = new int[N];
            for(int i=0; i<N; i++) {
                A[i] = sc.nextInt();
            }
            
            // OUTPUT [uncomment & modify if required]
            System.out.print(unchangedIndex(N,A));
            sc.close();
        }
}