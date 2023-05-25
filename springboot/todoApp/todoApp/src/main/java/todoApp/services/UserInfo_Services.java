package todoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoApp.model.UserInfomation;
import todoApp.repository.User_infoRepository;

@Service
public class UserInfo_Services {
    private final User_infoRepository user_infoRepository;

    @Autowired
    public UserInfo_Services(User_infoRepository user_infoRepository){
        this.user_infoRepository = user_infoRepository;
    }
   
    public List<UserInfomation> getAllUsers() {
        return user_infoRepository.findAll();
    }

    public Optional<UserInfomation> getUserById(long id) {
        return user_infoRepository.findById( id);
    }

    public UserInfomation createUser(UserInfomation user) {
        return user_infoRepository.save(user);
    }

    public UserInfomation updateUser(int id, UserInfomation updatedUser) {
        Optional<UserInfomation> existingUser = user_infoRepository.findById((long) id);
        if (existingUser.isPresent()) {
            UserInfomation user = existingUser.get();
            user.setFirst_name(updatedUser.getFirst_name());
            user.setSecond_name(updatedUser.getSecond_name());
            user.setLastname(updatedUser.getLastname());
            user.setPhone(updatedUser.getPhone());
            user.setAddress(updatedUser.getAddress());
            // Update other properties as needed
            return user_infoRepository.save(user);
        } else {
            throw new IllegalArgumentException("User with id " + id + " does not exist.");
        }
    }

    public void deleteUser(long id) {
        user_infoRepository.deleteById( id);
    }
}
