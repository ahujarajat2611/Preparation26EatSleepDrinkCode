package WeekendSystemDesign.ReactorPattern.reactornio;

import java.nio.channels.SelectionKey;

public interface EventHandler {

    public void handleEvent(SelectionKey handle) throws Exception;
}