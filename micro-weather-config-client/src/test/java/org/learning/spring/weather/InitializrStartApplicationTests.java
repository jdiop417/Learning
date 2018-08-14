package org.learning.spring.weather;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitializrStartApplicationTests {
	@Value("${server.port}")
	private String auther;

	@Test
	public void contextLoads() {
		Assert.assertEquals("Life is short,use Python!",auther);
	}

}
