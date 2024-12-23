package com.xworkz.app.service;

import com.xworkz.app.Dto.LoginDto;

import java.util.List;

public interface LoginService {
    boolean validation(LoginDto loginDto);

    String getlastNameByName(String name);

    int getlastNameById(int loginId);

    List<LoginDto> getnameByPhone(long phone);
}
