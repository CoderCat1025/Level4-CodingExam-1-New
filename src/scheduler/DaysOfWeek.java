package scheduler;

public enum DaysOfWeek {
MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	LinkedList<Event> Events = new LinkedList<Event>();
	
	
	public void sort() {
		Node<Event> head = Events.getHead();
		for (int i=0; i<Events.size(); i++) {
			head.getValue().getTime();
			for (int e=0; e<i; e++) {

			}
		}
	}
}
