package Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    private ProductService productService;
    private Cart cart;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void createOrderFromProduct(long productId) {

        cart.fillCart(productId);
        System.out.println("Заказ создан");
        System.out.println("Доступны продукты: " + productService.getProductList());

    }
    public List<Products> showProdList() {
        return productService.getProductList();
    }

    public List<Products> showProdCart() {
        return cart.showCart();
    }

}
