package web.controllers;

import core.dtos.UserDTO;
import core.dtos.UserLoginDTO;
import core.dtos.UserRegistrationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/users")
public class PersonalAccountController {

    @PostMapping(path = "/registration")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDTO user) {
        return ResponseEntity.status(201).build();
    }

    @GetMapping(path = "/verification")
    public ResponseEntity<?> verified(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "mail") String mail) {
        return ResponseEntity.status(200).build();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO user) {
        return ResponseEntity.status(200).build();
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserDTO> get() {
        return ResponseEntity.status(200).build();
    }
}
