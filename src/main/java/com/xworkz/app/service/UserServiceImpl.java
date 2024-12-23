package com.xworkz.app.service;

import com.xworkz.app.Dao.UserDao;
import com.xworkz.app.Dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Setter@Getter
@Component
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean validationUserData(UserDto userDto) {
        boolean userValid = false;
        if (userDto != null){
            if (userDto.getUserName() != null && userDto.getUserEmail() != null &&userDto.getPhoneNumber()>0){

            }

         return   userDao.dataSave(userDto);
        }


     return userValid;
    }

    @Override
    public UserDto getUserById(int id) {
        //UserDto userDto = null;
        if (id > 0) {
            System.out.println("id is found");
           // System.out.println( userDao.getUserById(id));
            return  userDao.getUserById(id);

        }else
            System.out.println("id is not found3");

        return null;
        // return userDto;
    }

    @Override
    public boolean updataUserData(int useId, String nameOfUser) {
           if (useId >0 && nameOfUser != null)
               userDao.updataUserData(useId,nameOfUser);
        return true;
    }

    @Override
    public boolean updateUser(UserDto dto) {
        if (dto.getUserId() >0 && dto.getUserName() != null)
            userDao.updataUserData(dto);
        return true;
    }

    @Override
    public String getEmailById(int id) {
        String email = null;
        if(id > 0){
            return userDao.fetchEmailById(id);
        }
        return email;
    }

    @Override
    public Object[] getUserNameAndEmailById(int id) {
        Object[] obj = null;
        if (id>0){
           obj =userDao.fetchUserNameAndEmailById(id);
        }
        return obj;
    }

    @Override
    public Object[] getUserNameAndEmailByAdhar_no(long adherNo) {
        Object[] obj = null;
       String convert =  String.valueOf(adherNo);
       if (convert.length() == 12){
           obj= userDao.fetchUsernameAndEmailByAdherno(adherNo);
           if (obj == null) {
               System.out.println("No record found for Adhar number: " + adherNo);
           }
       } else {
           System.out.println("Invalid Adhar number. Must be 12 digits.");
       }


       return obj;
    }

    @Override
    public boolean updateUserEmailAndUserAadhaarNo(String userEmail, long adharNo) {
        boolean isUpdata = false;
          String converted =      String.valueOf(adharNo);
          if (converted.length()==12 && userEmail!=null && userEmail.isEmpty()){
              isUpdata=true;
              System.out.println("the data is update by using adharNo" +isUpdata);
          }
          isUpdata = userDao.editUserEmailAndUserAadhaarNo( userEmail,  adharNo);
          return isUpdata;
    }

    @Override
    public boolean deletedUserDataByAdhaar(long adherNo) {
        boolean isDeleted = false;
        String converted = String.valueOf(adherNo);
        if (converted.length()==12){
            isDeleted = true;
            System.out.println("data completed deleted");
        }

      isDeleted =  userDao.removeData(adherNo);
        return isDeleted;

    }
}

