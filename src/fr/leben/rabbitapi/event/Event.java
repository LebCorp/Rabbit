package fr.leben.rabbitapi.event;

public abstract class Event {

	boolean cancelled = false;
	
	public Event() {
	}
	
	public boolean isCancelled() {
		return cancelled;
	}
	
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public void call() {
		if(!isCancelled()) {
			
		}
	}
}
