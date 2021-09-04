package com.erhan.dursun.springbootrestapi.api;

import com.erhan.dursun.springbootrestapi.dto.UserDto;
import com.erhan.dursun.springbootrestapi.entity.User;
import com.erhan.dursun.springbootrestapi.service.UserService;
import com.erhan.dursun.springbootrestapi.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/message")
    public String message(){
        return "Devtools";
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto resultUser = userService.createUser(user);
    return ResponseEntity.ok(resultUser);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>>  getUsers(){
    List<UserDto> users=userService.getUsers();
    return ResponseEntity.ok(users);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
     UserDto user= userService.getUser(id);
     return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody UserDto user){
        UserDto resultUser=userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);
    }
    @GetMapping("/pagination")
    public ResponseEntity<Page<User>>  pagination(@RequestParam int currentPage,@RequestParam int pageSize){
    return ResponseEntity.ok(userService.pagination(currentPage,currentPage));
    }

    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<User>>  pagination(Pageable pageable){
        return ResponseEntity.ok(userService.pagination(pageable));
    }

    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>>  slice(Pageable pageable){
        return ResponseEntity.ok(userService.slice(pageable));
    }

    @GetMapping("/pagination/v3")
    public ResponseEntity<CustomPage<UserDto>> customPagenation(Pageable pageable){
        return ResponseEntity.ok(userService.customPagination(pageable));
    }



    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id,@RequestBody User user){
        Boolean status=userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }


}
