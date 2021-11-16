package Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cart {
    private List<Product> cart;

    public Cart(List<Product> cart) {
        this.cart = cart;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void fillCart(long id) {

        cart.add(productRepository.findById(id));
    }

    public List<Product> showCart() {
        
        return cart;
    }

}
