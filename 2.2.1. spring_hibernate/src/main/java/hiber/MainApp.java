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

      userService.add(new User("Ivan", "Reithman", "user1@mail.ru", new Car("Tesla", 7)));
      userService.add(new User("Ann", "Fine", "user2@mail.ru", new Car("Lada", 110)));
      userService.add(new User("Tam", "Bulatov", "user3@mail.ru", new Car("Pegeout", 1008)));
      userService.add(new User("Nikolai", "Vasin", "user4@mail.ru", new Car("Audi", 8)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Model = " + user.getCar().getModel());
         System.out.println("Series = " + user.getCar().getSeries());
         System.out.println();
      }

      System.out.println(userService.findUser("Tesla", 7));

      context.close();
   }
}
