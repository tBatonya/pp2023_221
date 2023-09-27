package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void add(User user, Car car);

    List<User> listUsers();

    void findUser(String model, int series);
}
