package scheduler;

public enum DaysOfWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

	LinkedList<Event> Events = new LinkedList<Event>();


	public void sort() {
		for (int i=0; i<Events.size(); i++) {
			Node<Event> curr = Events.getHead();

			while (curr.getNext()!=(null)) {
				if (curr.getNext().getValue().getTime()<curr.getValue().getTime()) {
					Event a = curr.getNext().getValue();

					curr.getNext().setValue(curr.getValue());
					curr.setValue(a);
				}
				curr = curr.getNext();
			}
		}
	}
}
