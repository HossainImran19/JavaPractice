package imran.practice.com;

public class Practice {
	
public static void main(String[] args) {
		
		Practice.problemNo1(8);
		Practice.problemNo2();
		Practice.problemNo3(24,45);
		Practice.problemNo4();
		
	}
	
	public static void problemNo1(int dayNo) {
		switch(dayNo) {
		case 1:
			System.out.println("Saturday");
			break;
		case 2:
			System.out.println("Sunday");
			break;
		case 3:
			System.out.println("Monday");
			break;
		case 4:
			System.out.println("Tuesday");
			break;
		case 5:
			System.out.println("Wednesday");
			break;
		case 6:
			System.out.println("Thursday");
			break;
		case 7:
			System.out.println("Friday");
			break;
		default:
			System.out.println("Invalide Day");
			
		}
	}

	public static void problemNo2() {
		int a = 2, b = 3;
		char op = '/';
		switch (op) {
		case '+':
			System.out.println(a + b);
			break;
		case '-':
			System.out.println(a - b);
			break;
		case '*':
			System.out.println(a * b);
			break;
		default:
			System.out.println(a / b);
		}
	}
	
	public static void problemNo3(int a, int b) {
		System.out.println(a == b? 'a' + " = " + 'b' : a<b? 'a' + " != " + 'b' + "\n" + 'a' + " < " + 'b' + "\n" + 'a' + " <= " + 'b' : 'a' + " != " + 'b' + "\n" + 'a' + " > " + 'b' + "\n" + 'a' + " >= " + 'b');
//		if(a == b) {
//			System.out.println(a + " = " + b);
//		}else {
//			System.out.println(a + " != " + b);
//			if(a < b) {
//				System.out.println(a + " < " + b);
//				System.out.println(a + " <= " + b);
//			}else if(a > b) {
//				System.out.println(a + " > " + b);
//				System.out.println(a + " >= " + b);
//			}
//		}
		
	}
	
	public static void problemNo4() {
		int n = 15;
		System.out.println(n/10+n%10);
	}
	
}
