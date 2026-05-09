package dadeAndisheNiroo.authentication.controller;

import dadeAndisheNiroo.authentication.LoginRequest;
import dadeAndisheNiroo.authentication.LoginResponse;
import dadeAndisheNiroo.common.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        try {
            logger.info("before authentication");
            logger.info("request.getPassword="+request.getPassword());
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(),
                                    request.getPassword()
                            )
                    );
            logger.info("after authentication");
            UserDetails user =
                    (UserDetails) authentication.getPrincipal();
            logger.info("user="+ user.getUsername());
            logger.info("pass="+ user.getPassword());
            String token = jwtService.generateToken(user);
            logger.info("token="+ token);
            return ResponseEntity.ok(new LoginResponse(token));
        }catch (Exception e){
            logger.error("Exception happened", e); // 👈 THIS LINE
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }
}
