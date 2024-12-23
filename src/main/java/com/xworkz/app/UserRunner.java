package com.xworkz.app;

import com.xworkz.app.Dto.UserDto;
import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.service.UserService;
import com.xworkz.app.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class UserRunner {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Scanner scanner = new Scanner(System.in);
        UserDto userDto = new UserDto();

//        System.out.print("Enter an integer for the user ID:");
//        int id = scanner.nextInt();
//        userDto.setUserId(id);

//        System.out.print("Enter the name of user:");
//        String name = scanner.next();
//        userDto.setUserName(name);
//
//        System.out.print("Enter the user email:");
//        String email = scanner.next();
//        userDto.setUserEmail(email);
////
//        System.out.print("Enter the user phone number:");
//        long phoneNumber = scanner.nextLong();
//        userDto.setPhoneNumber(phoneNumber);
//
        System.out.println("Enter the user adher_no");
        long adher_no = scanner.nextLong();
        userDto.setAdhar_no(adher_no);
//
        UserService service = applicationContext.getBean(UserService.class);
//         service.validationUserData(userDto);


        //System.out.println(userService.getUserById(userDto.getUserId()));


      //   System.out.println(service.updataUserData(userDto.getUserId(), userDto.getUserName()));

      //  System.out.println(service.getEmailById(id));

//        Object[] obj = service.getUserNameAndEmailById(id);
//        Arrays.stream(obj).forEach(System.out::println);

//          System.out.println(service.updateUser(userDto));
//        try {
//            Object[] obj1 = service.getUserNameAndEmailByAdhar_no(adher_no);
//
//            Arrays.stream(obj1).forEach(System.out::println);
//        }catch (NullPointerException e){
//
//            e.printStackTrace();
//        }

//      boolean userUpdate=  service.updateUserEmailAndUserAadhaarNo(userDto.getUserEmail(),userDto.getAdhar_no());
//        System.out.println("yes email is update:" +userUpdate);
          boolean  userDeleted =  service.deletedUserDataByAdhaar(adher_no);
        System.out.println(userDeleted);
    }
    }

