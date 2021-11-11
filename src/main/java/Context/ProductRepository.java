package Context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class ProductRepository {

    private List<Products> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Products(1L, "Bread"),
                new Products(2L, "Milk"),
                new Products(3L, "Apples"),
                new Products(4L, "Butter"),
                new Products(5L, "Soda")
        ));
    }

    public Products findById(long id) {
        return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public List<Products> showProductList() {
        return products;
    }
}
