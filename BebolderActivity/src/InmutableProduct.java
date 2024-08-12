import java.util.LinkedList;
import java.util.List;

public final class InmutableProduct {

    private final String name;
    private final String description;
    private final List<String> categories;

    public InmutableProduct(String name, String description, List<String> categories) {
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCategories() {
        return new LinkedList<>(categories);
    }

    @Override
    public String toString() {
        return "InmutableProduct{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                '}';
    }
}
