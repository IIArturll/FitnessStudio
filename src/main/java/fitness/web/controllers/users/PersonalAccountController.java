package fitness.web.controllers.users;

import fitness.core.user.dtos.UserDTO;
import fitness.core.user.dtos.UserLoginDTO;
import fitness.core.user.dtos.UserRegistrationDTO;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;
import fitness.services.user.api.IPersonalAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/users")
public class PersonalAccountController {
    private final IPersonalAccountService service;

    public PersonalAccountController(IPersonalAccountService service) {
        this.service = service;
    }

    @PostMapping(path = "/registration")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDTO user) throws MultipleErrorResponse {
        service.register(user);
        return ResponseEntity.status(201).build();
    }

    @GetMapping(path = "/verification")
    public ResponseEntity<?> verified(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "mail") String mail) throws SingleErrorResponse {
        service.verified(code,mail);
        return ResponseEntity.status(200).build();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO user) {
        return ResponseEntity.status(200).build();
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserDTO> get() {
        return ResponseEntity.status(200).build();
    }
}
