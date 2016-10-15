import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DifferenceInDays {

	public static void main(String[] args) throws ParseException {
		
		//Understand the format of the date
		SimpleDateFormat format1 = new SimpleDateFormat("MM dd yyyy");
		
		//Take the input
		Scanner value = new Scanner(System.in);
		
		System.out.print("Enter the first date ('MM dd yyyy'): ");
		
		String firstDateStr = value.nextLine();
		
		System.out.print("Enter the second date ('MM dd yyyy'): ");
		
		String secondDateStr = value.nextLine();
		
		String earlierDateStr = firstDateStr;
		String laterDateStr = secondDateStr;
		
		
		//Convert the input into dates
		Date firstDate = format1.parse(firstDateStr);
		Date secondDate = format1.parse(secondDateStr);
		
		//Find the difference in the two dates
		long daysDifferent = secondDate.getTime() - firstDate.getTime();
		
		Date earlierDate = firstDate;
		Date laterDate = secondDate;
		
		//Used to make sure the difference is a positive number
		if (daysDifferent > 0){
			 earlierDate = firstDate;
			 laterDate = secondDate;
		}else{
			 earlierDate = secondDate;
			 laterDate = firstDate;
			daysDifferent = daysDifferent * -1;
			earlierDateStr = secondDateStr;
			laterDateStr = firstDateStr;
		}
		
		//Print out the two dates and the difference
		System.out.println("First Date: " + earlierDate);
		System.out.println("Second Date: " + laterDate);
		System.out.println(TimeUnit.DAYS.convert(daysDifferent , TimeUnit.MILLISECONDS) 
							+ " days before " + laterDateStr + " from date "+ earlierDateStr);
		
		//To make sure there is no leaks 
		value.close();
	}

}
