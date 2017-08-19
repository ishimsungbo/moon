package com.moon;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.nio.charset.Charset;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("config.properties")
@MapperScan(value = {"com.moon.*.mapper"})
public class BootAppSetting {

    //Mybatis
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(res);
        return sessionFactory.getObject();
    }

    //한글처리
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("EUC-KR"));
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("EUC-KR");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

}
