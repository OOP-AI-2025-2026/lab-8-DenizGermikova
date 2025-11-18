package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    // Метод обчислення рейтингу
    public double getRating() {
        if (reviews == 0) return 0.0;
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BookData other) {

        double thisRating = this.getRating();
        double otherRating = other.getRating();

        // 1) Порівняння за рейтингом (вищий рейтинг → "менше")
        if (thisRating > otherRating) return -1;
        if (thisRating < otherRating) return 1;

        // 2) Якщо рейтинги однакові, порівнюємо за назвою
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                ", total=" + total +
                ", rating=" + getRating() +
                '}';
    }
}
