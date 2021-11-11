package Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.Context;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("Context");
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println("Доступны продукты: " + orderService.showProdList());
        System.out.println("Введите id продукта для добавления в корзину или 222 для выхода");
        System.out.println("Введите 111 чтобы показать корзину");
        System.out.println("Введите 333 для оформления заказа");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            long order = scanner.nextLong();
            if (order > 0 && order <= 5) {
                orderService.createOrderFromProduct(order);
            }
            else if (order == 111) {
                System.out.println("В корзине: " + orderService.showProdCart().toString());
            } else if (order == 333){
                System.out.println("Спасибо за заказ!");
                break;
            } else if (order == 222) {
                System.out.println("Вы отменили заказ");
                break;
            }
            else if (order > 5) {
                System.out.println("Введите id доступного товара");
            }
        }
    }
}
