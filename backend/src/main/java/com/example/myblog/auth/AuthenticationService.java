package com.example.myblog.auth;

import com.example.myblog.Jwt.JwtService;
import com.example.myblog.enity.Role;
import com.example.myblog.enity.RoleName;
import com.example.myblog.enity.User;
import com.example.myblog.repository.RoleRepository;
import com.example.myblog.repository.UserRepository;
import com.example.myblog.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    public AuthenticationResponse register(RegisterRequest request){
        User user = new User();
        //Lấy role trong database
        Role roleUser = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò ROLE_USER"));

        //thêm user từ request
        user.setUserName(request.getUserName());
        user.setPassWord(passwordEncoder.encode(request.getPassword()));
        user.setFullname(request.getFullName());
        user.setRoles( Collections.singleton(roleUser));
        var savedUser = userRepository.save(user);
        //build JWT từ user
        UserDetails customUserDetails = CustomUserDetails.mapUserToUserDetail(user);
        var jwtToken = jwtService.generateToken(customUserDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUserName(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        User user = userRepository.findByUserName(request.getUserName());


        UserDetails customUserDetails = CustomUserDetails.mapUserToUserDetail(user);
        var jwtToken = jwtService.generateToken(customUserDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
