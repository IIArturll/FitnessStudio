package fitness.web.controllers;

import fitness.core.dtos.UserCreateDTO;
import fitness.core.dtos.UserDTO;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.services.api.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/users")
public class UserController {
    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateDTO user) throws MultipleErrorResponse {
        service.create(user);
        return ResponseEntity.status(201).build();
    }

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<UserDTO> get(@PathVariable("uuid") UUID uuid) {
        return ResponseEntity.status(200).body(new UserDTO());
    }

    @PutMapping(path = "{uuid}/dt_update/{dt_update}")
    public ResponseEntity<?> update(@PathVariable("uuid") UUID uuid,
                                    @PathVariable("dt_update") Long dt_update,
                                    @RequestBody UserCreateDTO user) {
        return ResponseEntity.status(200).build();
    }


}
