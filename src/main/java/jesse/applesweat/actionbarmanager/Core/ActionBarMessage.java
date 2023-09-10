package jesse.applesweat.actionbarmanager.Core;

import net.kyori.adventure.text.ComponentLike;

/**
 * Represents an actionbar message
 */
public class ActionBarMessage {
    ComponentLike message;
    long sendTime = 0;
    long duration = 0;
    MessagePriority priority;

    /**
     * @return The end time of this message
     */
    public long getEndTime() {
        return sendTime + duration;
    }

    /**
     * <strong>THIS METHOD DOESN'T CHECK IF THIS MESSAGE HAS BEEN REPLACED!</strong>
     * @return If this message is currently displayed
     */
    public boolean isDisplayed() {
        return System.currentTimeMillis() < getEndTime();
    }

    /**
     * @param other The message to check
     * @return If the {@code other} message's display time doesn't
     * interfere with this message or if
     * the {@code other} message is of more priority
     */
    public boolean canBeOverwrittenBy(ActionBarMessage other) {
        return other.sendTime > getEndTime() || other.priority.getAsInt() >= priority.getAsInt();
    }
}
