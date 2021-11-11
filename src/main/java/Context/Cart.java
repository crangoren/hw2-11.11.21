package Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Cart {
    private List<Products> cart;

    public Cart(List<Products> cart) {
        this.cart = cart;
    }

    public List<Products> getCart() {
        return cart;
    }

    public void setCart(List<Products> cart) {
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

    public List<Products> showCart() {
        return cart;
    }

}
