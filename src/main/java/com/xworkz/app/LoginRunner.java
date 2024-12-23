package com.xworkz.app;

import com.xworkz.app.Dto.LoginDto;
import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class LoginRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Scanner scanner = new Scanner(System.in);
        LoginDto loginDto = new LoginDto();


//        System.out.print("enter user LoginId:");
//        int loginId = scanner.nextInt();
//        loginDto.setLoginId(loginId);

//        System.out.println("enter the name:");
//        String name = scanner.next();
//        loginDto.setName(name);

//        System.out.print("Enter any one letter from the name: ");
//        String lastName = scanner.next();
//        char character = lastName.charAt(0);

       //  Convert char to String
//        loginDto.setLastname(character);
//
        System.out.println("enter the phone number:");
        long phone = scanner.nextLong();
        loginDto.setPhoneNumber(phone);
//
//        System.out.println("enter the address :");
//        String address = scanner.next();
//        loginDto.setAddress(address);
//
//        System.out.println("enter the price:");
//        double price = scanner.nextDouble();
//        loginDto.setPrice(price);
            LoginService service = applicationContext.getBean(LoginService.class);
       //  boolean boo =   service.validation(loginDto);
      //  System.out.println(boo);
//        System.out.print("enter the name:");
//        String name = scanner.next();
//     String str =   service.getlastNameByName(name);
//        System.out.println(str);

//     int id=   service.getlastNameById(loginId);
//        System.out.println(id);

        List<LoginDto> ref= service.getnameByPhone(phone);
        ref.forEach(System.out::println);
//        System.out.println(bboo);
    }
}
