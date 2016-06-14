import java.util.Scanner;

public class StudentInfo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//title
		System.out.println("Welcome to our Java class.");
		
		//arrays of student data
		String[][] students = new String[3][3];
		students[0][0] = "Jon";
		students[0][1] = "Huntington, NY";
		students[0][2] = "pizza";
		
		students[1][0] = "Henry";
		students[1][1] = "San Francisco, CA";
		students[1][2] = "sushi";
		
		students[2][0] = "Lexi";
		students[2][1] = "Homer Glenn, IL";
		students[2][2] = "chicken cordon bleu";
		
		//loop for running the entire program again
		boolean cont = true;
		while (cont) {
			
			int numInput = 0;
			int numInfo = 0;
			String info = "";
			
			//loop for asking the user which student they would like
			System.out.print("\nWhich student would you like to learn more about? ");
			boolean gotStudent = false;
			while (!gotStudent) {
				try {
					numInput = InputCheck.getInt(sc, "(enter a number from 1-3): ");
					System.out.println("Student " + numInput + " is " + students[numInput - 1][0]);
					gotStudent = true;
					
				} catch (IndexOutOfBoundsException e) {
					System.out.print("That student does not exist. Please try again. ");
				}
				String garbg = sc.nextLine();
			} 
			
			//loop for asking the user what info about the student they would like
			System.out.print("\nWhat would you like to know about "+students[numInput-1][0]+"? ");
			boolean gotInfo = false;
			while(!gotInfo){
				try{
					System.out.print("(enter \"hometown\" or \"favorite food\"): ");
					info = sc.nextLine();
					if(info.equals("hometown")){
						numInfo = 1;
						System.out.println(students[numInput-1][0]+" is from "+students[numInput-1][numInfo]);
					}
					else if(info.equals("favorite food")){
						numInfo = 2;
						System.out.println(students[numInput-1][0]+"'s favorite food is "+students[numInput-1][numInfo]);
					}
					else
						throw new IllegalArgumentException();
					gotInfo = true;
						
				} catch (IllegalArgumentException e) {
					System.out.print(
							"That data does not exist. Please try again. ");
				}
			}
			
			cont = InputCheck.cont(sc, "\nWould you like to know more? ");
		}
	}
}
