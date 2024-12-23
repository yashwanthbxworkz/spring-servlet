package com.xworkz.app.service;

import com.xworkz.app.Dao.LoginDao;
import com.xworkz.app.Dto.LoginDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@Component
public class LoginServiceImpl implements LoginService{
    @Autowired
   private LoginDao loginDao;

    @Override
    public boolean validation(LoginDto loginDto) {
        boolean isValid = false;
        if (loginDto != null) {
            if (loginDto.getName() != null && !loginDto.getName().isEmpty() && loginDto.getPhoneNumber() > 0 &&
                    loginDto.getAddress() != null && !loginDto.getAddress().isEmpty() && loginDto.getPrice() > 0) {
                isValid = true;

                    char letter = loginDto.getLastname();
                        if (Character.isLetter(letter)) {
                            isValid = true;
                            System.out.println("is validation" + isValid);
                        } else {
                            System.out.println("Invalid character: Must be a letter.");
                    }

                }else
                    System.out.println(" invalidation");

            }else
                System.out.println("invalid data");
            if (isValid==true){
                isValid = loginDao.save(loginDto);

            }

        return isValid;
    }

    @Override
    public String getlastNameByName(String name) {

        if (name != null && !name.isEmpty())
                loginDao.fectchlastname(name);
       return null;
    }

    @Override
    public int getlastNameById(int loginId) {
       // Character cov = Character.valueOf(loginId);
        if (loginId>0){

        }
        return  loginDao.fetchlastName(loginId);
    }

    @Override
    public List<LoginDto> getnameByPhone(long phone) {
        List<LoginDto> isNames = null;
        String converted = String.valueOf(phone);
        if (converted.length()==10){
            isNames= loginDao.fetchName(phone);

            }
        return isNames;
    }
}
