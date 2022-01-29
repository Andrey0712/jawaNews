package program;

import Utils.DB_Context;
import crud.Product_CRUD;
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

//Category_CRUD category =new Category_CRUD();
//category.search_Category(context);
//        category.create_Category(context);
//        category.search_Category(context);
//        category.update_Category(context);
//        category.search_Category(context);
//        category.delete_Category(context);
//        category.search_Category(context);

        Product_CRUD product_crud =new Product_CRUD();
        product_crud.create_Product(context);
        product_crud.search_Product(context);
        product_crud.update_Product(context);
        product_crud.search_Product(context);
        product_crud.delete_Product(context);
        product_crud.search_Product(context);



//

        context.close();
    }
}
