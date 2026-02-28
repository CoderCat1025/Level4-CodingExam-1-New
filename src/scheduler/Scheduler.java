package scheduler;

import java.io.InputStream;
import java.util.Scanner;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler {

    public static void main(String[] args) {
    	DaysOfWeek[] week = DaysOfWeek.values();

    	//preset events for testing and such
    	week[4].Events.add(new Event(15, "coding class"));
    	week[3].Events.add(new Event(13, "counselor meeting"));
    	week[6].Events.add(new Event(12, "zoo"));
    	
    	System.out.println("Input a day. (0-6, 0 is Monday and 6 is Sunday.)");
    	
    	Scanner scan = new Scanner(System.in);
    	int day = Integer.parseInt(scan.nextLine());

    	if (day<7 && -1<day) {
    		System.out.println("Would you like to add, view, or remove events? (ADD/VIEW/REMOVE)");
    		
    		String ans = scan.nextLine();
    		
    		if (ans.equals("ADD")) {
    			System.out.println("What time is your event?");
    			int t = Integer.parseInt(scan.nextLine());
    			if (t<25&&t>-1) {
    			
    			System.out.println("Enter a description of your event.");
    			String desc = scan.nextLine();
    			
    			week[day].Events.add(new Event(t, desc));
    			
    			System.out.println("Event: " + desc + " at " + t + "o'clock added!");
    			
    			//sort the events after this (not coded yet lol)
    			} else {
    				System.out.println("invalid time");
    			}
    			
    		} else if (ans.equals("VIEW")) {
        		for (int i=0; i<week[day].Events.size(); i++) {
        			week[day].Events.print();
        			//it was NOT that easy
        		}
    		} else if (ans.equals("REMOVE")) {
    			System.out.println("What number event would you like to remove?");
    			int num = Integer.parseInt(scan.nextLine());
    			if (num<week[day].Events.size() && num>-1) {
    				//similar to sort, find the event
    				
    				for (int i = 0; i <num+1; i++) {
    					
    				}
    				
    				System.out.println("Event removed!");
    			} else {
    				System.out.println("invalid number");
    			}
    		} else {
    			System.out.println("huh");
    		}
    		

    	} else {
    		System.out.println("dawg that is NOT what i asked for :skull:");
    	}
    }
}
