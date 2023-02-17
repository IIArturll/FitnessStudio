package web.controllers;

import core.dtos.UserCreateDTO;
import core.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody UserCreateDTO user){
        return ResponseEntity.status(201).build();
    }

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<UserDTO> get(@PathVariable("uuid")UUID uuid){
        return ResponseEntity.status(200).body(new UserDTO());
    }

    @PutMapping(path = "{uuid}/dt_update/{dt_update}")
    public ResponseEntity<?> update(@PathVariable("uuid") UUID uuid,
                                    @PathVariable("dt_update")Date dt_update){
        return ResponseEntity.status(200).build();
    }
}
