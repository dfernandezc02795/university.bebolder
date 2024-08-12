import java.util.List;

public class MutableProduct {

    public String name;
    public String description;
    public List<String> categories;

    public MutableProduct(String name, String description, List<String> categories) {
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "MutableProduct{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                '}';
    }
}
