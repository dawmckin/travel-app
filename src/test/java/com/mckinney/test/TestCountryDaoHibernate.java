package com.mckinney.test;

import com.mckinney.data.CountryDaoHibernate;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCountryDaoHibernate {

    CountryDaoHibernate countryDao = new CountryDaoHibernate();

    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception{

    }

    @BeforeEach
    void setUp() throws Exception {

    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    void test() {
        System.out.println(countryDao.getCountryByName("Canada"));
    }
}
