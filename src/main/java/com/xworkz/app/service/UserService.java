package com.xworkz.app.service;

import com.xworkz.app.Dto.UserDto;

public interface UserService {
    boolean validationUserData(UserDto userDto);


    UserDto getUserById(int id);


    boolean updataUserData(int useId, String nameOfUser);

     boolean updateUser(UserDto dto);

   String getEmailById(int id);

    Object[] getUserNameAndEmailById(int id);

    Object[] getUserNameAndEmailByAdhar_no(long adherNo);

    boolean updateUserEmailAndUserAadhaarNo(String userEmail, long adharNo);

    boolean deletedUserDataByAdhaar(long adherNo);
}
