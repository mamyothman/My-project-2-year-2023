package todoApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import todoApp.model.UserInfomation;
import todoApp.services.UserInfo_Services;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("api/User")
public class UserController {

    private final UserInfo_Services userService;

    @Autowired
    public UserController(UserInfo_Services userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserInfomation>> getAllUsers() {
        List<UserInfomation> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserInfomation> getUserById(@PathVariable("id") int id) {
        Optional<UserInfomation> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserInfomation> createUser(@RequestBody UserInfomation user) {
        UserInfomation createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser{id}")
    public ResponseEntity<UserInfomation> updateUser(@PathVariable("id") int id, @RequestBody UserInfomation updatedUser) {
        try {
            UserInfomation user = userService.updateUser(id, updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
