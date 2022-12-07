package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Frodo", "Baggins", "MyPRECIOUS@shire.me", new Car("Lada Sedan", 7777777)));
      userService.add(new User("Samwise", "Gamgee", "imJustSam@shire.me", new Car("Hammer", 12345)));
      userService.add(new User("Merry", "Brandybuck", "TallestHobbitEver@shire.me", new Car("Tesla", 98765)));
      userService.add(new User("Pippin", "Took", "BlockheadTook@shire.me", new Car("Porsche", 5553535)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar().toString());
         System.out.println();
      }

      System.out.println(userService.usersByCar("Lada Sedan", 7777777));

      context.close();
   }
}
