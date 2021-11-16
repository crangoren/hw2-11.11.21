package Context;

public class Product {
    private long id;
    private String title;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product(long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
}
