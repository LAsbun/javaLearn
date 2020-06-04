package springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    UserService userService;

    @Override
    public String getMessage() {
        userService.print();
        return "helloWorld";
    }
}
