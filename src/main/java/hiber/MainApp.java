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

     /* userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));*/
     // userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user=new User("Eugene", "Kashitsyn", "user@mail.ru");
      Car car=new Car("BMW",3);
      user.setCar(car); //связывание
      userService.addUser(user);
      userService.addCar(car);

      List<User> users = userService.listUsers();
      for (User usr : users) {
         System.out.println("Id = "+usr.getId());
         System.out.println("First Name = "+usr.getFirstName());
         System.out.println("Last Name = "+usr.getLastName());
         System.out.println("Email = "+usr.getEmail());
         System.out.println("Car:\n"+"model = "+usr.getCar().getModel()+"\nseries = "+usr.getCar().getSeries());
         System.out.println();
      }
      System.out.println(userService.findUserByCar(new Car("BMW",3)));
      context.close();
   }
}
