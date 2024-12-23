package com.xworkz.app.Dao;

import com.xworkz.app.Dto.UserDto;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
@Component


public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public UserDto getUserById(int id) {

        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserDto userDto = entityManager.find(UserDto.class, id);

          //  System.out.println(userDto);
            entityManager.getTransaction().commit();
            return userDto;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updataUserData(int userId,String nameOfUSer) {

        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserDto user = entityManager.find(UserDto.class, userId);
            if (user != null) {
                user.setUserName(nameOfUSer);
                entityManager.merge(user);
            } else {
                System.out.println("User with ID " + userId + " not found.");
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void updataUserData(UserDto dto) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserDto user = entityManager.find(UserDto.class, dto.getUserId());
            if (user != null) {

                entityManager.merge(dto);
            } else {
                System.out.println("User with ID " + dto.getUserId() + " not found.");
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public String fetchEmailById(int id) {
        return (String) factory.createEntityManager()
                .createNamedQuery("fetchEmailById")
                .setParameter("i",id).getSingleResult();

    }

    @Override
    public Object[] fetchUserNameAndEmailById(int id) {
        System.out.println();
        return (Object[]) factory.createEntityManager().
                createNamedQuery("fetchUserNameAndEmailById")
                        .setParameter("g", id).getSingleResult();
    }

    @Override
    public Object[] fetchUsernameAndEmailByAdherno(long adherNo) {
        return (Object[]) factory.createEntityManager().createNamedQuery("fetchUsernameAndEmailByAdherno").
                setParameter("no",adherNo).getSingleResult();

    }

    @Override
    public boolean editUserEmailAndUserAadhaarNo(String userEmail, long adharNo) {
        boolean addemail = false;
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
     Query query=   entityManager.createNamedQuery("editUserEmailAndUserAadhaarNo");
    query.setParameter("email",userEmail);
    query.setParameter("aNo",adharNo);

    int noOfRows=query.executeUpdate();
        entityManager.getTransaction().commit();
    if (noOfRows>0){
        addemail = true;

    }
return addemail;
    }

    @Override
    public boolean removeData(long adherNo) {
       boolean isdeleted=false;
        String converted = String.valueOf(adherNo);
       EntityManager entityManager = factory.createEntityManager();
       entityManager.getTransaction().begin();
        if (converted.length()==12){
            isdeleted=true;
        }
      Query query= entityManager.createNamedQuery("removeData ");
       query.setParameter("de",adherNo);
       query.executeUpdate();
       entityManager.getTransaction().commit();

       return isdeleted;

    }


    @Override
    public boolean dataSave(UserDto userDto) {
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(userDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;








    }

}
