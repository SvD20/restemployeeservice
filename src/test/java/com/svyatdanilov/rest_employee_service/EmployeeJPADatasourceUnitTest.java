package com.svyatdanilov.rest_employee_service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJPADatasourceUnitTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void givenDataSourceAvailableWhenAccessDetailsThenExpectDetails() throws SQLException {
		assertThat(dataSource.getClass().getName()).isEqualTo("com.zaxxer.hikari.HikariDataSource");
		assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).isEqualTo("MySQL");
	}

}
