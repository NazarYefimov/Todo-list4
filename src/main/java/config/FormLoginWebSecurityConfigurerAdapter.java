package config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface FormLoginWebSecurityConfigurerAdapter {
    @SuppressWarnings("deprecation")
    void configure(HttpSecurity http) throws Exception;
}
