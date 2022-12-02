package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = entityManager.createQuery("from User", User.class)
                .getResultList();
        if(usersList.isEmpty()) return null;
        return usersList;
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
       return entityManager.find(User.class, id);
    }

    @Override
    public void deleteEmployee(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
