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
        factoryBean.setPackagesToScan("com.dgs.dgsframework"); // @Entity νμμμΉ
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());   // JPA κ΅¬νμ²΄λ‘λ νμ΄λ²λ€μ΄νΈλ₯Ό μ¬μ©

        // μμΈμ€μ 
        Properties jpaProperties = new Properties();
        jpaProperties.put(AvailableSettings.SHOW_SQL, false);                                        // SQL λ³΄κΈ°
        jpaProperties.put(AvailableSettings.FORMAT_SQL, true);                                      // SQL μ λ ¬ν΄μ λ³΄κΈ°
        jpaProperties.put(AvailableSettings.USE_SQL_COMMENTS, true);                                // SQL μ½λ©νΈ λ³΄κΈ°
//        jpaProperties.put(AvailableSettings.JPA_LOCK_TIMEOUT, 50000);

        /* DDL μλ μμ±
            none : κΈ°λ³Έ κ°μ΄λ©° μλ¬΄ μΌλ μΌμ΄λμ§ μλλ€.
            create-only : λ°μ΄ν°λ² μ΄μ€λ₯Ό μλ‘ μμ±νλ€.
            drop : λ°μ΄ν°λ² μ΄μ€λ₯Ό drop νλ€.
            create : λ°μ΄ν°λ² μ΄μ€λ₯Ό drop ν ν, λ°μ΄ν°λ² μ΄μ€λ₯Ό μλ‘ μμ±νλ€.(κΈ°λ₯μ μΌλ‘λ drop + create-onlyμ κ°λ€)
            create-drop : SessionFactoryκ° μμλ  λ μ€ν€λ§λ₯Ό dropνκ³  μ¬μμ±νλ©°, SessionFactoryκ° μ’λ£λ  λλ μ€ν€λ§λ₯Ό drop νλ€.
            validate : λ°μ΄ν°λ² μ΄μ€ μ€ν€λ§λ₯Ό κ²μ¦ νλ€.
            update : λ°μ΄ν°λ² μ΄μ€ μ€ν€λ§λ₯Ό κ°±μ  νλ€.
         */
        jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");

        /* λ°©μΈ μ€μ  */
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.OracleDialect");
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
        //jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");

        /* λ°©μΈ μ€μ  */

        jpaProperties.put(AvailableSettings.IN_CLAUSE_PARAMETER_PADDING, true);
        jpaProperties.put(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, true);                       // μ λ²μ Όμ IDμμ± μ΅μ
        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        factoryBean.setJpaProperties(jpaProperties);


        return factoryBean;
    }
}
