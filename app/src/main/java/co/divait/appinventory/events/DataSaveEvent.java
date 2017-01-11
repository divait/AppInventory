package co.divait.appinventory.events;

/**
 * Created by divai on 10/01/2017.
 *
 * Event when Data was sussesfully save.
 */

public class DataSaveEvent {

    public final boolean isSave;

    public DataSaveEvent(boolean isSave) {
        this.isSave = isSave;
    }
}
