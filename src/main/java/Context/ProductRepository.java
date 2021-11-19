package Context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread"),
                new Product(2L, "Milk"),
                new Product(3L, "Apple"),
                new Product(4L, "Butter"),
                new Product(5L, "Soda")
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public List<Product> showProductList() {
        return Collections.unmodifiableList(products);
    }

}
