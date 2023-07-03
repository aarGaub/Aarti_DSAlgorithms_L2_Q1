package com.paymoney.transactions.services;

public class TransactionServiceImpl {
	
	public void findTransactionForTarget(long[] cumulativeSumOfTrasactions, long targetValue) {
		
		boolean flag=true;
		
		/*Since the array is cumulative sum of transactions, we need to just perform 
		 * linear search of index where targetValue is equal or less than 
		 * cumulativeSumOfTrasactions */
		for(int i=0; i<cumulativeSumOfTrasactions.length; i++) {
			
			if(targetValue <= cumulativeSumOfTrasactions[i]) 
			{
				flag=false;
				System.out.println("Target achieved after "+(i+1)+" transactions");
				break;
			}
			
		}
		if(flag==true) 
			System.out.println("Given target is not achieved");
		
	}

}
