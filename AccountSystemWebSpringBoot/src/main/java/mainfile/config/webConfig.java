package mainfile.config;
import Logic.config.LogicConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "mainfile",
       // "za.ac.nwu.ac.web.sb.exception"
})

public class webConfig {
}
