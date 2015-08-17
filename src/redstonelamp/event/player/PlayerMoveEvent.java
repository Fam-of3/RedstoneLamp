package redstonelamp.event.player;

import redstonelamp.Player;
import redstonelamp.event.Cancellable;
import redstonelamp.event.Event;
import redstonelamp.event.Listener;

public class PlayerMoveEvent extends PlayerEvent implements Cancellable {
	private String type = "PlayerMoveEvent";
	private Player player;
	private Event e = this;
	
	private boolean canceled;
	
	public PlayerMoveEvent(Player player) {
		this.player = player;
	}

	public void execute(Listener listener) {
		listener.onEvent(e);
	}
	
	public String getEventName() {
		return type;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
}