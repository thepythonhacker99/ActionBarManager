package jesse.applesweat.actionbarmanager.Core;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * This is used to organize messages by priority.
 * If a message send request is made with a lower
 * {@code MessagePriority} than the {@code MessagePriority} of
 * the currently displayed message, the message won't be sent,
 * and if the message {@code MessagePriority} of the request is higher,
 * the current message will be overwritten.
 *
 * @see #LOWEST
 * @see #LOW
 * @see #NORMAL
 * @see #HIGH
 * @see #HIGHEST
 * @see #CRITICAL
 */
@SuppressWarnings("unused")
public enum MessagePriority {
    /**
     * Lowest possible message priority
     */
    LOWEST(0),

    /**
     * Second-lowest possible message priority
     */
    LOW(1),

    /**
     * The default message priority.
     * This will be used for messages that are not
     * sent using the {@code ActionBarManager} plugin
     *
     * @see #defaultPriority()
     */
    NORMAL(2),

    /**
     * The second-highest message priority
     */
    HIGH(3),

    /**
     * The highest message priority.
     *
     * @see #CRITICAL
     */
    HIGHEST(4),

    /**
     * This is the actual highest message priority.
     * This should only be used for notifications and stuff like that.
     * You should probably use {@link #HIGHEST}
     *
     * @see #HIGHEST
     */
    CRITICAL(5);

    /**
     * @return The default priority, currently {@link #NORMAL}
     */
    public static @NotNull MessagePriority defaultPriority() {
        return NORMAL;
    }

    /**
     * The {@code int} representation of
     * this {@code MessagePriority}
     */
    @Getter
    private final int asInt;
    MessagePriority(int priority) {
        this.asInt = priority;
    }
}
