package business;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {
    private List<String> booksList = new ArrayList<>();
    private List<String> filmsList = new ArrayList<>();
    private List<String> musicList = new ArrayList<>();

    public ProductServiceImpl () {
        booksList.add("Book 1");
        booksList.add("Book 2");
        booksList.add("Book 3");

        filmsList.add("Film 1");
        filmsList.add("Film 2");
        filmsList.add("Film 3");

        musicList.add("Music 1");
        musicList.add("Music 2");
        musicList.add("Music 3");

    }

    public List<String> getProductCategories () {
        List<String> categories = new ArrayList<>();

        categories.add("Books");
        categories.add("Films");
        categories.add("Music");

        return categories;
    }

    public List<String> getProductsByCategory (String category) {
        switch (category.toLowerCase()) {
            case "books":
                return booksList;

            case "films":
                return filmsList;

            case "music":
                return musicList;
        }

        return null;
    }

    public boolean addProduct (String category, String product) {
        switch (category.toLowerCase()) {
            case "books":
                booksList.add(product);
                break;

            case "films":
                filmsList.add(product);
                break;

            case "music":
                musicList.add(product);
                break;

            default:
                return false;
        }

        return true;
    }
}
