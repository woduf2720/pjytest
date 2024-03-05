package org.zerock.pjytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootTest
class PjytestApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		try (
				Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select now()");
				ResultSet resultSet = preparedStatement.executeQuery();
		){
			resultSet.next();

			System.out.println(resultSet.getString(1));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
