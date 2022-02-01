package com.go.sports.config.security;

import com.go.sports.entity.User;
import com.go.sports.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = restoreToken(request);
        boolean validated = tokenService.isTokenValidated(token);
        if (validated){
            authenticateClient(token);
        }

        filterChain.doFilter(request,response);
    }

    private void authenticateClient(String token) {
        String userId = tokenService.getUserId(token);
        User user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,
                null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String restoreToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
