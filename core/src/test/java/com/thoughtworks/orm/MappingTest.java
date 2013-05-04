package com.thoughtworks.orm;

import com.example.Pet;
import com.example.dao.PetDao;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MappingTest {

    private static Connection connection;
    private static String databaseUrl = "jdbc:mysql://localhost:3306/orm?user=root";
    private static PetDao petDao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        connection = getConnection(databaseUrl);
        petDao = new PetDao();
        petDao.setDatabaseUrl(databaseUrl);
    }


    @Test
    public void should_find_object_by_id() throws SQLException {
        String insertSQL = "INSERT INTO pets values(%d,'%s', '%s', %d)";
        connection.createStatement().executeUpdate(String.format(insertSQL, 1, "Doudou", "Female", 2));

        Pet pet = petDao.findById(1);

        assertThat(pet.getName(), equalTo("Doudou"));
        assertThat(pet.getGender(), equalTo("Female"));
        assertThat(pet.getAge(), equalTo(2));
    }

    @Test
    public void should_update_object_by_id() throws SQLException {
        String insertSQL = "INSERT INTO pets values(%d,'%s', '%s', %d)";
        connection.createStatement().executeUpdate(String.format(insertSQL, 1, "Doudou", "Female", 2));

        Pet pet = petDao.findById(1);
        assertThat(pet.getName(), equalTo("Doudou"));

        petDao.update(1, "name", "James");
        Pet pet1 = petDao.findById(1);
        assertThat(pet1.getName(), equalTo("James"));

    }

    @Test
    public void should_delete_record_by_id() throws SQLException {
        String insertSQL = "INSERT INTO pets values(%d,'%s', '%s', %d)";
        connection.createStatement().executeUpdate(String.format(insertSQL, 1, "Doudou", "Female", 2));

        Pet pet = petDao.findById(1);
        assertThat(pet.getName(), equalTo("Doudou"));

        petDao.deleteById(1);
        pet = petDao.findById(1);
        assertNull(pet);
    }

    @After
    public void tearDown() throws SQLException {
        connection.createStatement().execute("truncate pets");
    }
}
