package nl.overheid.koop.plooi.aanleveren.validatie.service;

import nl.overheid.koop.plooi.aanlever.api.UsersApi;
import nl.overheid.koop.plooi.aanlever.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserEndpoint implements UsersApi {

    @Override
    public ResponseEntity<Void> createUser(@Valid User body) {
        System.out.println(body.getName());
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getAllUsersInUbrKoop() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserById(String userId) {
        User user = new User();
        user.setEmail(userId);
        user.setName(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> deleteUserById(String userId){

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
