package fitness.web.controllers;

import fitness.core.user.dtos.UserCreateDTO;
import fitness.core.user.dtos.UserDTO;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;
import fitness.services.user.api.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<UserDTO> get(@PathVariable("uuid") UUID uuid) throws SingleErrorResponse {
        return ResponseEntity.status(200).body(service.get(uuid));
    }

    @PutMapping(path = "{uuid}/dt_update/{dt_update}")
    public ResponseEntity<?> update(@PathVariable("uuid") UUID uuid,
                                    @PathVariable("dt_update") Long dt_update,
                                    @RequestBody UserCreateDTO user) throws SingleErrorResponse, MultipleErrorResponse {
        service.update(uuid, dt_update, user);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getPage(Pageable pageable) {
        return ResponseEntity.status(200).body(service.getPage(pageable));
    }

}
