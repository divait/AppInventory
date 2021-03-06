package co.divait.appinventory.entities;


import com.orm.SugarRecord;

/**
 * Created by divait on 9/01/2017.
 *
 * The App element.
 */

public class AppObject extends SugarRecord{

    private Long id;
    private String name;
    private String summary;
    private String image;
    private float price;
    private String currency;
    private String rights;
    private String link;
    private String artist;
    private String category;
    private String release_date;

    public AppObject() {}

    public AppObject(long id, String name, String summary, String image, float price, String currency, String rights, String link, String artist, String category, String release_date) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.image = image;
        this.price = price;
        this.currency = currency;
        this.rights = rights;
        this.link = link;
        this.artist = artist;
        this.category = category;
        this.release_date = release_date;
    }

    public Long getId() {
        return id;
    }

    public static AppObject[] fromJsonAppToAppObject(JsonApp[] jsonApps) {
        AppObject[] objects = new AppObject[jsonApps.length];
        for (int i=0; i<jsonApps.length; i++) {
            objects[i] = fromJsonAppToAppObject(jsonApps[i]);
        }

        return objects;
    }

    public static AppObject fromJsonAppToAppObject(JsonApp jsonApp) {
        return new AppObject(
                Long.valueOf(jsonApp.getId().getAttributes().getId()),
                jsonApp.getName().getLabel(),
                jsonApp.getSummary().getLabel(),
                jsonApp.getImgs()[0].getLabel(),
                Float.valueOf(jsonApp.getPrice().getAttributes().getAmount()),
                jsonApp.getPrice().getAttributes().getCurrency(),
                jsonApp.getRights().getLabel(),
                jsonApp.getLink().getAttributes().getHref(),
                jsonApp.getArtist().getLabel(),
                jsonApp.getCategory().getAttributes().getTerm(),
                jsonApp.getReleaseDate().getAttributes().getLabel()
        );
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRights() {
        return rights;
    }

    public String getLink() {
        return link;
    }

    public String getArtist() {
        return artist;
    }

    public String getCategory() {
        return category;
    }

    public String getRelease_date() {
        return release_date;
    }
}
