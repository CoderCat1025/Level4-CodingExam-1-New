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
		week[6].Events.add(new Event(12, "going to the zoo"));
		week[0].Events.add(new Event(3, "calling the EVIL number 666 challenge!1!!!!1"));

		//uhh so im doing this like console store...
		boolean done = false;
		Scanner scan = new Scanner(System.in);

		OUTER: do {
			System.out.println("Input a day. (0-6, 0 is Monday and 6 is Sunday.)");

			int day = Integer.parseInt(scan.nextLine());

			if (day<7 && -1<day) {

				System.out.println("Would you like to add, view, or remove events? (ADD/VIEW/REMOVE)");

				String ans = scan.nextLine();

				switch (ans) {
				case "ADD":
					System.out.println("What time is your event? (military time)");
					int t = Integer.parseInt(scan.nextLine());
					if (t<25&&t>-1) {
						Node<Event> nod = week[day].Events.getHead();
						for (int i = 0; i<week[day].Events.size(); i++) {
							try {
								checkTime(t, week[day].Events);
							} catch (SchedulingConflictException e) {
								System.err.println("You already have an event planned for this time.");
								continue OUTER;
							}
							nod=nod.getNext();
						}
						System.out.println("Enter a description of your event.");
						String desc = scan.nextLine();

						week[day].Events.add(new Event(t, desc));

						System.out.println("Event: " + desc + " at " + t + "o'clock added!");
						week[day].sort();
					} else {
						System.err.println(" invalid time");
					}
					
					week[day].sort();
					break;

				case "VIEW": {
					if (week[day].Events.size() == 0) {
						System.out.println("No events for " + week[day] + ".");
					}else {
						Node<Event> head = week[day].Events.getHead();
						for (int i=0; i<week[day].Events.size(); i++) {
							//it was NOT that hard lolol
							System.out.println("Event: " + head.getValue().getEvent() + " at " + head.getValue().getTime() + "o'clock.");
							head = head.getNext();
						}
					}
					break;}

				case "REMOVE": {
					System.out.println("What number event would you like to remove?");
					int num = Integer.parseInt(scan.nextLine());
					if (num<week[day].Events.size() && num>-1) {
						//IT WAS THAT EASY
						week[day].Events.remove(num);


						System.out.println("Event removed!");
					} else {
						System.err.println(" invalid number");
					}
					break;}
				default:{
					System.err.println(" huh (make sure to input in all caps!)");
					break;
				}
				}


			} else {
				System.err.println(" dawg that is NOT what i asked for :skull:");
			}
		} while (done==false);
		scan.close();
	}

	static void checkTime(int i, LinkedList<Event> list) throws SchedulingConflictException {
		Node<Event> nod = list.getHead();
		for (int e = 0; e<list.size(); e++) {
			if (i==nod.getValue().getTime()) {
				throw new SchedulingConflictException();
			}
			nod=nod.getNext();
		}
	}
}