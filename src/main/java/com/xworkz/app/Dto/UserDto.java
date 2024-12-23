package com.xworkz.app.Dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Table(name= "spring_user")
@Entity
@ToString@Setter@Getter
//@NamedQueries({
//    @NamedQuery(name ="removeData",query = "delete  from UserDto dto where dto.adhar_no=:de "),
//     @NamedQuery(name ="fetchEmailById",query = "select user.userEmail from UserDto user where user.userId=:i")})
@NamedQuery(name ="removeData",query = "delete  from UserDto dto where dto.adhar_no=:de ")
    @NamedQuery(name = "editUserEmailAndUserAadhaarNo",query = "update UserDto dto set dto.userEmail=:email where dto.adhar_no=:aNo")
    @NamedQuery(name="fetchUsernameAndEmailByAdherno",query = "select user.userName , user.userEmail from UserDto user where user.adhar_no =: no")
@NamedQuery(name = "fetchUserNameAndEmailById",query = "select user.userName, user.userEmail from UserDto user where user.userId=:g")
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name="ref" , strategy = "increment")
//    @GeneratedValue(generator = "ref")
    @Column(name = "userId")
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userEmail")
    private String userEmail;

    @Column(name= "phoneNumber")
    private long phoneNumber;

    @Column(name = "adhar_no")
    private  long adhar_no;
}
