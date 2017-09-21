package tutor.spring.DeploySpring.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.URISyntaxException;

@Configuration
public class DataConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {

        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws URISyntaxException {
        return new JdbcTemplate(dataSource());
    }
}
