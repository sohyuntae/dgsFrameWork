package com.dgs.dgsframework.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
@EnableTransactionManagement
public class HikariConfig extends com.zaxxer.hikari.HikariConfig {
    @Value("${spring.datasource.hikari.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.hikari.jdbc-url}")
    private String jdbcurl;

    @Value("${spring.datasource.hikari.username}")
    private String username;

    @Value("${spring.datasource.hikari.password}")
    private String password;

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource()
    {
        HikariDataSource hikariDataSource = new HikariDataSource();

        try
        {
            hikariDataSource.setDriverClassName(driverClassName);
            hikariDataSource.setJdbcUrl(jdbcurl);
            hikariDataSource.setUsername(username);
            hikariDataSource.setPassword(password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return hikariDataSource;
    }

    /* JPA */
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.dgs.dgsframework"); // @Entity 탐색위치
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());   // JPA 구현체로는 하이버네이트를 사용

        // 상세설정
        Properties jpaProperties = new Properties();
        jpaProperties.put(AvailableSettings.SHOW_SQL, false);                                        // SQL 보기
        jpaProperties.put(AvailableSettings.FORMAT_SQL, true);                                      // SQL 정렬해서 보기
        jpaProperties.put(AvailableSettings.USE_SQL_COMMENTS, true);                                // SQL 코멘트 보기
//        jpaProperties.put(AvailableSettings.JPA_LOCK_TIMEOUT, 50000);

        /* DDL 자동 생성
            none : 기본 값이며 아무 일도 일어나지 않는다.
            create-only : 데이터베이스를 새로 생성한다.
            drop : 데이터베이스를 drop 한다.
            create : 데이터베이스를 drop 한 후, 데이터베이스를 새로 생성한다.(기능적으로는 drop + create-only와 같다)
            create-drop : SessionFactory가 시작될 때 스키마를 drop하고 재생성하며, SessionFactory가 종료될 때도 스키마를 drop 한다.
            validate : 데이터베이스 스키마를 검증 한다.
            update : 데이터베이스 스키마를 갱신 한다.
         */
        jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");

        /* 방언 설정 */
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.OracleDialect");
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");

        /* 방언 설정 */

        jpaProperties.put(AvailableSettings.IN_CLAUSE_PARAMETER_PADDING, true);
        jpaProperties.put(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, true);                       // 새 버젼의 ID생성 옵션
        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        factoryBean.setJpaProperties(jpaProperties);


        return factoryBean;
    }
}
