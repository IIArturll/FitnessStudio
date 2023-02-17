package web.controllers;

import core.dtos.BaseEssence;
import core.dtos.UserDTO;
import core.dtos.UserRegistrationDTO;
import core.dtos.enums.UserRole;
import core.dtos.enums.UserStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

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
    public ResponseEntity<?> login() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserDTO> get() {
        return ResponseEntity.status(200).body(
                new UserDTO(
                        new BaseEssence(UUID.randomUUID(), new Date(), new Date()),
                        "mail@mail.ru",
                        "fio",
                        UserRole.USER,
                        UserStatus.ACTIVATED));
    }
}
