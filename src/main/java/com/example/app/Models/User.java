package com.example.app.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import org.immutables.encode.Encoding;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type", length = 1)
    private String userType;

    @Column(name = "user_bank_code", length = 5)
    private String userBankCode;

    @Column(name = "user_branch_code", length = 5)
    private String userBranchCode;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "number_of_tries_allowed")
    private Integer numberOfTriesAllowed;

    @Column(name = "ip_address_mang", length = 1)
    private String ipAddressMang;

    @Column(name = "ip_address", length = 20)
    private String ipAddress;

    @Column(name = "connected", length = 1)
    private String connected;

    @Column(name = "first_connection", length = 1)
    private String firstConnection;

    @Column(name = "nbre_session_allowed")
    private Integer nbreSessionAllowed;

    @Column(name = "nbre_session_connected")
    private Integer nbreSessionConnected;

    @Column(name = "length_password")
    private Integer lengthPassword;

    @Column(name = "complexity_flag", length = 1)
    private String complexityFlag;

    @Column(name = "expiration_password")
    private Integer expirationPassword;

    @Column(name = "date_start_pass")
    private Date dateStartPass;

    @Column(name = "date_end_pass")
    private Date dateEndPass;

    @Column(name = "block_access", length = 1)
    private String blockAccess;

    @Column(name = "language_code", length = 3)
    private String languageCode;

    @Column(name = "last_4_pwd", length = 1024)
    private String last4Pwd;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "mobile_number", length = 20)
    private String mobileNumber;

    @Column(name = "forgotpwd_request", length = 1)
    private String forgotPwdRequest;

    @Column(name = "secret_key", length = 100)
    private String secretKey;
    @Column(name="total_Points")
    private double totalPoints;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userType));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
