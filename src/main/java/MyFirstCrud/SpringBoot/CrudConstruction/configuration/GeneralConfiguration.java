package MyFirstCrud.SpringBoot.CrudConstruction.configuration;

import MyFirstCrud.SpringBoot.CrudConstruction.pojo.properties.UserProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserProperties.class)
public class GeneralConfiguration {

    //configuramos la base de datos tipo H2
    @Value("${value.name}")
    private String name;

    @Value("${value.random}")
    private String randomValue;

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String userName;
    @Value("${password}")
    private String password;


    //Bean para establecer la configuración y creación de la base de datos
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
