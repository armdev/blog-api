package app.config;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilder configureObjectMapper() throws Exception{
        return new Jackson2ObjectMapperBuilder()
                .modulesToInstall(Hibernate4Module.class);
    }
}
