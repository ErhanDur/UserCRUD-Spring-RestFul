package com.erhan.dursun.springbootrestapi.service;

import com.erhan.dursun.springbootrestapi.dto.UserDto;
import com.erhan.dursun.springbootrestapi.entity.User;
import com.erhan.dursun.springbootrestapi.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    public abstract UserDto createUser(UserDto user);

    List<UserDto> getUsers();
    UserDto getUser(Long id);
    UserDto updateUser(Long id, UserDto user);
    Boolean deleteUser(Long id);

    Page<User>  pagination( int currentPage,  int pageSize);
    Page<User>  pagination(Pageable pageable);
    Slice<User>  slice(Pageable pageable);
    CustomPage<UserDto>  customPagination(Pageable pageable);
}
