/*
Logger Rate Limiter
Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true;

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;

Using a map. If the map already has the key, return false. Otherwise add key or update time
 */
package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
public class Logger {
    private Map<String, Integer> messages;
    /** Initialize your data structure here. */
    public Logger() {
        messages = new HashMap<>();
    }
 
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messages.containsKey(message)) {
            messages.put(message, timestamp);
            return true;
        } else {
            int lastTime = messages.get(message);
            if (timestamp - lastTime < 10) {
         //         Ideally i should be updadating map with latest timestamp !!
                //       messages.put(message, timestamp);

                return false;
            } else {
                // update time stamp but timestamp is not getting updated in case i am trying to print with in ten secondss
                //
                messages.put(message, timestamp);
                return true;
            }
        }
    }
 
 
}