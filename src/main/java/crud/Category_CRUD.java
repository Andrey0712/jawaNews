package crud;

import Utils.DB_Context;
import entities.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;

public class Category_CRUD {
    //Session context = DB_Context.getSessionFactory().openSession();
    Scanner in = new Scanner(System.in);

    public void create_Category(Session session) {

        System.out.println("Введите новую категорию:");
        Category category = new Category();
        category.setName(in.nextLine());
        session.save(category);
        System.out.println("Категория id = "+ category.getId());
    }
    public void search_Category(Session session) {
        Query query = session.createQuery("FROM Category");
        List<Category> category_list = query.list();
          for (Category category : category_list) {
            System.out.println("Категория №: "+ category.getId()+" "+category.getName());
        }
    }
    public void update_Category(Session session) {
        System.out.println("Введите номер категории для обновления : ");
        try {
            session.beginTransaction();
            int id = in.nextInt();
            Category category = session.find(Category.class, id);
            System.out.println("Введите новую категорию: ");
            String new_name = in.next();
            category.setName(new_name);
            session.update(category);
            System.out.println("Обновлена категория №: " + category.getId());
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error update:" + ex.getMessage());
        }
    }

    public void delete_Category(Session session){
        System.out.println("Введите номер категории для удаления : ");
        try {
            session.beginTransaction();
            int id = in.nextInt();
            Category category = session.find(Category.class, id);
            session.delete(category);
            System.out.println("Удалена категория №: " + category.getId());
            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Error update:" + ex.getMessage());
        }
    }
}
