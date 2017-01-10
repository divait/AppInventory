package co.divait.appinventory.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by divait on 8/01/2017.
 *
 *  The entity for the data from Json.
 */

public class JsonApp {

    @SerializedName("im:name")
    private Name name;
    @SerializedName("im:image")
    private Img[] imgs;
    private Summary summary;
    @SerializedName("im:price")
    private Price price;
    private Rights rights;
    private Title title;
    private Link link;
    private ID id;
    @SerializedName("im:artist")
    private Artist artist;
    private Category category;
    @SerializedName("im:releaseDate")
    private ReleaseDate releaseDate;

    public JsonApp() {}

    class Name {
        private String label;

        public Name() {}

        String getLabel() {
            return label;
        }
    }

    class Img {
        private String label;

        public Img() {}

        public String getLabel() {
            return label;
        }
    }

    class Summary {
        private String label;

        public Summary() {}

        public String getLabel() {
            return label;
        }
    }

    class Price {
        private String label;
        private Attributes attributes;

        public Price() {}

        class Attributes {
            private String amount;
            private String currency;

            public String getAmount() {
                return amount;
            }

            public String getCurrency() {
                return currency;
            }
        }

        public String getLabel() {
            return label;
        }

        public Attributes getAttributes() {
            return attributes;
        }
    }

    class Rights {
        private String label;

        public Rights() {}

        public String getLabel() {
            return label;
        }
    }

    class Title {
        private String label;

        public Title() {}

        public String getLabel() {
            return label;
        }
    }

    class Link {
        private Attributes attributes;

        public Link() {}

        class Attributes {
            private String rel;
            private String type;
            private String href;

            public Attributes() {}

            public String getRel() {
                return rel;
            }

            public String getType() {
                return type;
            }

            public String getHref() {
                return href;
            }
        }

        public Attributes getAttributes() {
            return attributes;
        }
    }

    class ID {
        private String label;
        private Attributes attributes;

        public ID() {}

        class Attributes {
            @SerializedName("im:id")
            private String id;
            @SerializedName("im:bundleld")
            private String bundleld;

            public Attributes() {}

            String getId() {
                return id;
            }

            public String getBundleld() {
                return bundleld;
            }
        }

        public String getLabel() {
            return label;
        }

        public Attributes getAttributes() {
            return attributes;
        }
    }

    class Artist {
        private String label;

        public Artist() {}

        public String getLabel() {
            return label;
        }
    }

    class Category {

        private Attributes attributes;

        public Category() {}

        class Attributes {
            @SerializedName("im:id")
            private String id;
            private String term;
            private String scheme;
            private String label;

            public Attributes() {}

            public String getId() {
                return id;
            }

            public String getTerm() {
                return term;
            }

            public String getScheme() {
                return scheme;
            }

            public String getLabel() {
                return label;
            }
        }

        public Attributes getAttributes() {
            return attributes;
        }
    }

    class ReleaseDate {
        private String label;
        private Attributes attributes;

        public ReleaseDate() {}

        class Attributes {
            private String label;

            public Attributes() {}

            public String getLabel() {
                return label;
            }
        }

        public String getLabel() {
            return label;
        }

        public Attributes getAttributes() {
            return attributes;
        }
    }

    public Name getName() {
        return name;
    }

    public Img[] getImgs() {
        return imgs;
    }

    public Summary getSummary() {
        return summary;
    }

    public Price getPrice() {
        return price;
    }

    public Rights getRights() {
        return rights;
    }

    public Title getTitle() {
        return title;
    }

    public Link getLink() {
        return link;
    }

    public ID getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public Category getCategory() {
        return category;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }
}
