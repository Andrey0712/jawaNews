package program;

import Utils.DB_Context;
import entities.Category;
import entities.Product;
import org.hibernate.Session;
import crud.Category_CRUD;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Session context = DB_Context.getSessionFactory().openSession();
        System.out.println("Connection is good!");

Category_CRUD category =new Category_CRUD();
category.search_Category(context);
        category.create_Category(context);
        category.search_Category(context);
        category.update_Category(context);
        category.search_Category(context);
        category.delete_Category(context);
        category.search_Category(context);

//        System.out.println("Назва категории:");
//        String name = in.nextLine();
//        Category category = new Category();
//        category.setName(name);
//        context.save(category);
//        System.out.println("Author id = "+ category.getId());

//        System.out.println("Назва товару:");
//        String nameProd = in.nextLine();
//        System.out.println("Ціна товару:");
//        int price = Integer.parseInt(in.nextLine());
//        System.out.println("Категория id:");
//        int category_id = Integer.parseInt(in.nextLine());
//        Product product = new Product();
//        product.setName(nameProd);
//        product.setPrice(price);
//        Category category1 = new Category();
//        category1.setId(category_id);
//        product.setCategory(category1);
//        context.save(product);
//        System.out.println("Product id = "+ product.getId());

        context.close();
    }
}
