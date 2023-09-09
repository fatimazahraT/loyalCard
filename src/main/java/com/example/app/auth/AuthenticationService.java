package com.example.app.auth;

import com.example.app.Models.User;
import com.example.app.Repository.UserRepository;
import com.example.app.config.JwtService;
import com.example.app.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    // Track the number of incorrect attempts per email
    private final Map<String, Integer> incorrectAttempts = new HashMap<>();

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType("U") // Assuming the default userType for registered users is "USER"
                .email(request.getEmail())
                .totalPoints(0)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        String email = request.getEmail();

        // Check if the email exists in the repository
        var userOptional = repository.findByEmail(email);
        if (userOptional.isEmpty()) {
            // User not found for the given email
            return AuthenticationResponse.builder()
                    .error("User with the provided email does not exist. Please check the email and try again.")
                    .build();
        }

        // Check if the email is blocked due to max attempts reached
        if (incorrectAttempts.containsKey(email) && incorrectAttempts.get(email) >= 3) {
            return AuthenticationResponse.builder()
                    .error("Maximum number of attempts reached. Your account is temporarily blocked.")
                    .build();
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException exception) {
            // Authentication failed (invalid credentials)
            // Increment the incorrect attempts count for this email
            incorrectAttempts.put(email, incorrectAttempts.getOrDefault(email, 0) + 1);

            // Check if max attempts reached
            if (incorrectAttempts.get(email) >= 3) {
                return AuthenticationResponse.builder()
                        .error("Maximum number of attempts reached. Your account is temporarily blocked.")
                        .build();
            } else {
                return AuthenticationResponse.builder()
                        .error("Incorrect password. Please try again. Remaining attempts: " + (3 - incorrectAttempts.get(email)))
                        .build();
            }
        }

        // Authentication successful
        // Reset the incorrect attempts count for this email on successful login
        incorrectAttempts.remove(email);

        var user = userOptional.get();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }



}
