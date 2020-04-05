package Manager;

import repository.ProductRepository;
import ru.netology.domain.Product;

public class ProductMananger {

    private ProductRepository repository;

    public ProductMananger(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
            Product[] result = new Product[0];
            for (Product product: repository.getAll()) {
                if (matches(product, text)) {
                    Product[] tmp = new Product[result.length + 1];
                    System.arraycopy(product, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = product;
                    result = tmp;
                }
            }
            return result;
        }

    public boolean matches(Product product, String search) {


        // ваш код
        return false;
    }

    }


//        if (product instanceof Book) {
//        Book book = (Book) product;
//        if (book.getName().equalsIgnoreCase(search)) {
//        return true;
//        }
//        if (book.getAuthor().equalsIgnoreCase(search)) {
//        return true;
//        }
//        return false;
//        }