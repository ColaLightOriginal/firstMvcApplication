package com.firstMvcApplication.firstMvcApplication;
import com.firstMvcApplication.firstMvcApplication.Classes.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.beans.Customizer;
import java.sql.*;

@SpringBootApplication
public class FirstMvcApplication {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(FirstMvcApplication.class, args);

	}
}