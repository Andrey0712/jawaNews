package crud;

import entities.Category;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Product_CRUD {

    Scanner in = new Scanner(System.in);

    public void create_Product(Session session) {

        System.out.println("Введите название продукта: ");
        String nameProd = in.nextLine();
        System.out.println("Цена товару:");
        int price = Integer.parseInt(in.nextLine());
        System.out.println("Категория id:");
        int category_id = Integer.parseInt(in.nextLine());
        Product product = new Product();
        product.setName(nameProd);
        product.setPrice(price);
        Category category1 = new Category();
        category1.setId(category_id);
        product.setCategory(category1);
        session.save(product);
        System.out.println("Продукт id = "+ product.getId());
    }

    public void search_Product(Session session) {
        Query query = session.createQuery("FROM Product");
        List<Product> products_list = query.list();
        for (Product product : products_list) {
            System.out.println("Продукт №: "+product.getId()+" "+product.getName());
        }
    }
    public void delete_Product(Session session){
        System.out.println("Введите номер продукта для удаления : ");
        try {
            session.beginTransaction();
            int id = in.nextInt();
            Product product = session.find(Product.class, id);
            session.delete(product);
            System.out.println("Удален продукт №: " + product.getId());
            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Error update:" + ex.getMessage());
        }
    }
    public void update_Product(Session session) {
        System.out.println("Введите номер продукта для обновления : ");
        try {
            session.beginTransaction();
            int id = in.nextInt();
            Product product = session.find(Product.class, id);
            System.out.println("Введите новый продукт: ");
            String new_name = in.next();
            product.setName(new_name);
            session.update(product);
            System.out.println("Обновлен продукт №: " + product.getId());
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error update:" + ex.getMessage());
        }
    }

}
