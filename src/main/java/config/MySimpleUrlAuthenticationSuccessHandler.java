package config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Отримайте деталі користувача з аутентифікації
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        System.out.println("User " + userDetails.getUsername() + " has logged in");

        // Можна додати власні дії після успішної аутентифікації

        // Перенаправте користувача на деяку сторінку
        response.sendRedirect("/home");
    }

    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) {

    }
}