package Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    public ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id) {
        return productRepository.findById(id).getTitle();
    }
    public List<Product> getProductList() {
        return productRepository.showProductList();
    }
}
