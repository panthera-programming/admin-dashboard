package com.SpringBoot.admindashboard.SecurityConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    SimpleUrlAuthenticationSuccessHandler staffSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/home?staff=true");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/admin");

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    )throws ServletException, IOException
    {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities)
        {
            String authorityName = grantedAuthority.getAuthority();
            if (authorityName.equals("Admin"))
            {
                this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                return;
            }
            this.staffSuccessHandler.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
