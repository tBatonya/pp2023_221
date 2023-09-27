package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(User user, Car car) {
//override method for IDE
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void findUser(String model, int series) {
      Session session = sessionFactory.openSession();
try(session){
      Car car = session.createQuery("from User where car.model = :model and car.series = :series", Car.class)
              .setParameter("model", model).setParameter("series", series).getSingleResult();
   System.out.println(car.getUser());
   } catch (RuntimeException e) {
   System.out.println("User with car " + model + " " + series + " is not found");;
   }
}}
