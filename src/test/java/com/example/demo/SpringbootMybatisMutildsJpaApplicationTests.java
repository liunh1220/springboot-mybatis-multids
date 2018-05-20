package com.example.demo;

import com.example.demo.model.po.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisMutildsJpaApplication.class)
@ActiveProfiles(profiles = "dev")
public class SpringbootMybatisMutildsJpaApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void findUserTest() {
		User record = new User();
		record.setId("1");
		User user = userService.findUser(record);
		System.out.println(user);

	}

	@Test
	public void findUserListTest() {
		User record = new User();
		record.setId("1");
		List<User> users = userService.findUserList(record);
		System.out.println(users);

	}

}
