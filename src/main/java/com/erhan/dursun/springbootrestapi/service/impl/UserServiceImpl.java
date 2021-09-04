package com.erhan.dursun.springbootrestapi.service.impl;

import com.erhan.dursun.springbootrestapi.advice.UserNotFound;
import com.erhan.dursun.springbootrestapi.dto.UserDto;
import com.erhan.dursun.springbootrestapi.entity.User;
import com.erhan.dursun.springbootrestapi.repository.UserRepository;
import com.erhan.dursun.springbootrestapi.service.UserService;
import com.erhan.dursun.springbootrestapi.util.CustomPage;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
//@NoArgsConstructor
public class UserServiceImpl implements UserService {



   private final UserRepository userRepository;
   private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public UserDto createUser(UserDto userDto) {
        User user =modelMapper.map(userDto,User.class);

        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        user.setUpdateBy("Admin");
        user.setUpdateTime(new Date());
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users=userRepository.findAll();
        List<UserDto> userDtos=users.stream().map(user-> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUser(Long id) {

       Optional<User>  user= userRepository.findById(id);
    if(user.isPresent()){
        return    modelMapper.map(user.get(),UserDto.class);
    } else {
        throw new IllegalArgumentException("User not found..") ;
    }


    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {

        Optional<User>  resultUser= userRepository.findById(id);
        if(resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdateTime(new Date());
            resultUser.get().setUpdateBy("Admin");
            return  modelMapper.map( userRepository.save(resultUser.get()),UserDto.class);
        } else {
            return null ;
        }

    }
    @Override
    public Boolean deleteUser(Long id){
        Optional<User>  resultUser= userRepository.findById(id);

        if(resultUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<User> pagination(int currentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currentPage,pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> pagination(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public Slice<User> slice(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public CustomPage<UserDto> customPagination(Pageable pageable) {
    Page<User>  data=userRepository.findAll(pageable);
    UserDto[]  dtos=  modelMapper.map(data.getContent(),UserDto[].class);

        return new CustomPage<UserDto>(data, Arrays.asList(dtos));
    }


}
