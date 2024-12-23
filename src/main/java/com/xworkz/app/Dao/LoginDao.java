package com.xworkz.app.Dao;

import com.xworkz.app.Dto.LoginDto;

import java.util.List;

public interface LoginDao {
    boolean save(LoginDto loginDto);

    List<Character> fectchlastname(String name);

    int fetchlastName(int loginId);

    List<LoginDto>  fetchName(long phone);
}
