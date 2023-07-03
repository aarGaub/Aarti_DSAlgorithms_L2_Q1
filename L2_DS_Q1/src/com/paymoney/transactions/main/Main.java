package com.paymoney.transactions.main;

import java.util.Scanner;

import com.paymoney.transactions.services.TransactionServiceImpl;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter the size of transaction array ");
		
        int noOfTransactions = sc.nextInt();
        
        // Get the values of transactions as type long, as each transaction can be in crores.
        long[] transactions = new long[noOfTransactions];
        		
        System.out.println("Enter the values of array ");
       
        for(int i=0; i<noOfTransactions; i++)
        	transactions[i] = sc.nextLong();
        
        
        System.out.println("Enter the total no. of targets that needs to be achieved");
        int totalTargets = sc.nextInt();
        
        // Get the target value as type long as total target value can be in crores.
        long targetValue;
        
        /*find the cumulative sum for each transaction in same order,store in an array 
         * once and use it to avoid calculating the sum 'totalTargets' times. 
         * for input {20,12,31} cumulative sum array will be {20,32,63}
         */
        
        long[] cumulativeSumOfTrasactions = new long[noOfTransactions];
        cumulativeSumOfTrasactions[0] = transactions[0];
        
        for( int i=1; i<noOfTransactions; i++) 
        	cumulativeSumOfTrasactions[i]= cumulativeSumOfTrasactions[i-1]+ transactions[i];
        	
          
        while(totalTargets-- > 0) {
        	System.out.println("Enter the value of target ");
        	targetValue = sc.nextLong();
        	
        	TransactionServiceImpl transactionService = new TransactionServiceImpl();
        	transactionService.findTransactionForTarget(cumulativeSumOfTrasactions, targetValue);
        
        }
        
        sc.close();
	}

}
