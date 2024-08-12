public class Book {

    private String name;
    private String author;
    private int score;

    public Book(String name, String author, int score) {
        this.name = name;
        this.author = author;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + name + '\'' +
                ", author='" + author + '\'' +
                ", score=" + score +
                '}';
    }
}
