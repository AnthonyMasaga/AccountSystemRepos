package TransConfiguration;


import org.example.repository.config.repositoryConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({repositoryConfig.class})
@Configuration
@ComponentScan(basePackages =
"trans")
public class TransConfig {


}

