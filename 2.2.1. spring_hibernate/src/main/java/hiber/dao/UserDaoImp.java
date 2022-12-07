package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
   public List<User> usersByCar(String carName, int carSeries) {
      Query<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User user where userCar.model = :carModel and userCar.series = :carSeries");
      query.setParameter("carModel", carName).setParameter("carSeries", carSeries);
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      Query<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}