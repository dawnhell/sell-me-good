package business;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {
    private List<Product> booksList = new ArrayList<>();
    private List<Product> filmsList = new ArrayList<>();
    private List<Product> musicList = new ArrayList<>();

    public ProductServiceImpl () {
        booksList.add(new Product("Book 1", "book1 sku", 10));
        booksList.add(new Product("Book 2", "book2 sku", 20));
        booksList.add(new Product("Book 3", "book3 sku", 30));

        filmsList.add(new Product("Film 1", "film1 sku", 11));
        filmsList.add(new Product("Film 2", "film2 sku", 12));
        filmsList.add(new Product("Film 3", "film3 sku", 13));

        musicList.add(new Product("Music 1", "music1 sku", 21));
        musicList.add(new Product("Music 2", "music2 sku", 22));
        musicList.add(new Product("Music 3", "music3 sku", 23));

    }

    public List<String> getProductCategories () {
        List<String> categories = new ArrayList<>();

        categories.add("Books");
        categories.add("Films");
        categories.add("Music");

        return categories;
    }

    public List<Product> getProductsByCategory (String category) {
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
                booksList.add(new Product(product, "", 0));
                break;

            case "films":
                filmsList.add(new Product(product, "", 0));
                break;

            case "music":
                musicList.add(new Product(product, "", 0));
                break;

            default:
                return false;
        }

        return true;
    }
}
