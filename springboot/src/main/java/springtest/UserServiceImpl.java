package springtest;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void print() {
        System.out.println("user Service");
    }
}
