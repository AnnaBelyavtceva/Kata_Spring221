package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Андрей", "Андреев", "dron@mail.ru",
              new Car("Opel", 10)));
      userService.add(new User("Иван", "Иванов", "vanya@mail.ru",
              new Car("Toyota", 20)));
      userService.add(new User("Павел", "Павлов", "pahan@mail.ru",
              new Car("Lada", 30)));
      userService.add(new User("Роман", "Романов", "roma@mail.ru",
              new Car("Honda", 40)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Lada", 30));

      context.close();
   }
}
