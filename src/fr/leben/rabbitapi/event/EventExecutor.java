package fr.leben.rabbitapi.event;

public interface EventExecutor {

	public void execute(Listener listener, Event event);
}
