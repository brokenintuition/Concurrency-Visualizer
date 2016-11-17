package us.mattowens.concurrencyvisualizer.display;

import java.util.ArrayList;

public class EventGroupDisplayPanel {

	private int leftBound, rightBound;
	private Object key;
	private String displayName;
	private ArrayList<DisplayEvent> events;

	public EventGroupDisplayPanel(Object key, String displayName) {
		this.key = key;
		this.displayName = displayName;
		events = new ArrayList<DisplayEvent>();
	}
	
	public Object getKey() {
		return key;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void addEvent(DisplayEvent nextEvent) {
		events.add(nextEvent);
	}
	
	public void setBounds(int left, int right) {
		leftBound = left;
		rightBound = right;
	}
	
	public int getLeftBound() {
		return leftBound;
	}
	
	public int getRightBound() {
		return rightBound;
	}
	
	public int getWidth() {
		return rightBound - leftBound;
	}
	
	/**
	 * Returns the timestamp of the most recent event in this thread. Relies
	 * on the assumption that events are added in the order they occurred.
	 * @return Timestamp of the most recent event occurring in this thread
	 */
	public long getMostRecentTimestamp() {
		if(events.size() == 0) {
			return 0;
		}
		return events.get(events.size()-1).getTimestamp();
	}
	
	public long getFirstTimeStamp() {
		if(events.size() == 0) {
			return 0;
		}
		return events.get(0).getTimestamp();
	}
	
	public DisplayEvent[] getEventsArray() {
		DisplayEvent[] eventsArray = new DisplayEvent[events.size()];
		return events.toArray(eventsArray);
	}
	
	public int getMidPoint() {
		return (leftBound+rightBound)/2;
	}
}
