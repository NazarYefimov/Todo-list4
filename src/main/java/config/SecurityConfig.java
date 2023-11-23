package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Configuration
    protected static class AuthenticationConfiguration {
        // Конфігурація для AuthenticationManager
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter implements config.FormLoginWebSecurityConfigurerAdapter {
        private final SecurityConfig securityConfig;

        public FormLoginWebSecurityConfigurerAdapter(SecurityConfig securityConfig) {
            this.securityConfig = securityConfig;
        }

        @SuppressWarnings("deprecation")
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .dispatcherTypeMatchers(HttpMethod.valueOf("/public/**")).permitAll()
                    .dispatcherTypeMatchers(HttpMethod.valueOf("/private/**")).authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(securityConfig.myAuthenticationSuccessHandler())
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }
    }
}