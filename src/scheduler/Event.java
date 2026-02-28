package scheduler;

public class Event {
private int time;
private String event;
public Event(int time, String event) {
	super();
	this.time = time;
	this.event = event;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public String getEvent() {
	return event;
}
public void setEvent(String event) {
	this.event = event;
}
}
