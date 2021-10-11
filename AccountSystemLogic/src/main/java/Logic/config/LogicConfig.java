package Logic.config;

import TransConfiguration.TransConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({TransConfig.class})
@Configuration
@ComponentScan(basePackages = {"flow"})
public class LogicConfig {


}
