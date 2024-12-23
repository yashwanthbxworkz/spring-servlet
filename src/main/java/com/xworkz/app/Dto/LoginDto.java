package com.xworkz.app.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter@Setter

@Entity
@Table(name = "spring2_user_info")
@ToString
public class LoginDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId")
    private int loginId;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private char lastname;
    @Column(name = "phoneNumber")
    private long phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private double price ;

}
