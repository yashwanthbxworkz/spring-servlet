package com.xworkz.app.Dao;

import com.xworkz.app.Dto.UserDto;

public interface UserDao {

    boolean dataSave(UserDto userDto);

    UserDto getUserById(int id);

    void updataUserData(int userId,String nameOfUser);

    void updataUserData(UserDto dto);

    String fetchEmailById(int id);

    Object[] fetchUserNameAndEmailById(int id);

    Object[] fetchUsernameAndEmailByAdherno(long adherNo);

    boolean editUserEmailAndUserAadhaarNo(String userEmail, long adharNo);

    boolean removeData(long adherNo);
}
