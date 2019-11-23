package imran.practice.com;

public class Practice {
	
public static void main(String[] args) {
	
	  Practice call = new Practice();
	  call.problemNo2(5);
	  call.problemNo3();
	  call.problemNo4();
	  
	}

	public void problemNo2(int n) {
		int b = n;
		System.out.println("Kaiyom vai's pattern ==> \n");
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("* ");
	
			}
			System.out.print("\t");
			
				if(i == 1 || i == n) {
					for(int k = 1; k <= n; k++) {
						
					   System.out.print("* ");
					   
					}
					
				}else {
					
				
					System.out.print("*");
					space(n);
					System.out.print("*");
					
				}
				System.out.print("\t");
				for(int j = 0; j < i; j++ ) {
					System.out.print(" ");
				}
				
				if(i == 1) {
					for(int k = 0; k < n; k++) {
						System.out.print("* ");
					}
					System.out.println();
					continue;
				}
				if(i == n) {
					System.out.print("*");
					break;
				}
				System.out.print("*");
				for(int l = 0; l < b; l++) {
					System.out.print(" ");
					}
				System.out.print("*");
				b -= 2;
				System.out.println();
			}
	}
	

    public void problemNo3() {
    	int i = 1;
    	
    	System.out.println("\nOdd" + "\t" + "Even");
    	do {
    		
    		if(i % 2 == 0) {
    			System.out.print("   \t");
    			System.out.println(i);
    		}else {
    			System.out.print(i);
    		}
    		
    	}while(i++ < 100);
    }
    
public void problemNo4() {
    	
    	int n = 1234;
    	int divider = 1000;
    	int sum = 0;
    	
    	while(divider != 1) {
    		
    		
  		    sum += n / divider;
  		    n = n % divider;
  		    divider /= 10;
    		}
    	
    	 System.out.println("\nSummation of the digits is : " + (sum + n));
    	
    }

public static void space(int n) {
	
	for(int i = 1; i <= (n-1)+(n-2); i++) {
		System.out.print(" ");
	}
}
}
