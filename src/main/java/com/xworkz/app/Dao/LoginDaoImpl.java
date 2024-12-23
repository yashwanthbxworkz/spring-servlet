package com.xworkz.app.Dao;

import com.xworkz.app.Dto.LoginDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Component
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(LoginDto loginDto) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(loginDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public List<Character> fectchlastname(String name) {
        return factory.createEntityManager().createQuery("select user.lastname from LoginDto user where user.name=:n").setParameter("n", name).getResultList();

    }

    @Override
    public int fetchlastName(int loginId) {


        return (int) factory.createEntityManager().createQuery("select user.lastname from LoginDto user where user.loginId=:id").setParameter("id", loginId).getSingleResult();

    }

    @Override
    public List<LoginDto> fetchName(long phone) {

        return factory.createEntityManager().createQuery("select user from LoginDto user where user.phoneNumber =:phone ").setParameter("phone", phone).getResultList();

    }


}

