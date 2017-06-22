

import com.fx.login.controller.LoginController;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by hlwang on 2017/6/6.
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginController loginController;
    @Test
    public void testCheckUser() throws Exception {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("wang");
        userEntity.setPassword("123");
        String s = loginController.checkUser(userEntity);
//        String s =  userService.checkUser(userEntity);
        System.out.println(s);
    }
}