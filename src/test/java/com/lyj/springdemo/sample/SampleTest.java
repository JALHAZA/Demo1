package com.lyj.springdemo.sample;

import com.lyj.springdemo.config.AppConfig;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith({SpringExtension.class})
//@ContextConfiguration(classes = AppConfig.class)  //class 일때
@ContextConfiguration(locations = {"/test-context.xml","file:src/main/webapp/WEB-INF/root-context.xml"})  //xml 일때
//@RequiredArgsConstructor  //파이날 변수로 받는다. 생성자 주입
public class SampleTest {

    @Autowired(required = false)
    private SampleService sampleService;

    @Autowired         //파이날 변수가 아닐때 주입받는다
    @Qualifier("sample1")
    private  SampleDTO sampleDTO1;


    @Autowired
    @Qualifier("datasourceMaria")  // MariaDB 데이터소스를 사용
    private DataSource dataSourceMaria;

    @Autowired
    @Qualifier("datasourceMySQL")  // MySQL 데이터소스를 사용
    private DataSource dataSourceMySQL;

    @Autowired
    @Qualifier("datasourceOracle")  // Oracle 데이터소스를 사용
    private DataSource dataSourceOracle;


    @Test
    public void testMariaDBConnection() throws SQLException {
        Connection connection = dataSourceMaria.getConnection();
        log.info(connection);
    }

    @Test
    public void testMySQLConnection() throws SQLException {
        Connection connection = dataSourceMySQL.getConnection();
        log.info(connection);
    }

    @Test
    public void testOracleConnection() throws SQLException {
        Connection connection = dataSourceOracle.getConnection();
        log.info(connection);
    }



    @Test
    public void setSampleServiceTest(){
        log.info(sampleService);
    }

    @Test
    public void testSample1() {
        log.info(sampleDTO1);
    }

    @Test
    public void testSample() {
        SampleDTO dto = new SampleDTO();
        dto.setAge(20);
        dto.setName("손흥민");
        String[] hobbys={"수영","영화감상"};
        dto.setHobby(hobbys);
        log.info(dto);
    }
    @Test
    public void testSample2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/test-context.xml");
        SampleDTO dto1 = (SampleDTO) context.getBean("sample1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("sample2");
        log.info(dto2);
    }
    @Test
    public void testSample3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SampleDTO dto1 = (SampleDTO) context.getBean("myDTO1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("myDTO2");
        log.info(dto2);
    }

}
