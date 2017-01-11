package co.divait.appinventory.events;

/**
 * Created by divai on 10/01/2017.
 *
 * Event when Data was sussesfully save.
 */

public class DataSaveEvent {

    public final boolean isSave;
    public final String message;

    public DataSaveEvent(boolean isSave, String message) {
        this.isSave = isSave;
        this.message = message;
    }
}
