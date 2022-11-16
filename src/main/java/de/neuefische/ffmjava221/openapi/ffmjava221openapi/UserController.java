package de.neuefische.ffmjava221.openapi.ffmjava221openapi;

import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    User myUserName() throws ResponseStatusException {
        return new User(1, "Daniel");
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "The resource has successfully been stored.",
                    headers = @Header(name = HttpHeaders.LOCATION, description = "URL of the newly created resource", schema = @Schema(type = "string")),
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error."
            )
    }
    )
    @PostMapping
    User createUser(User user) {
        return user;
    }

    @GetMapping("/all")
    User[] getAllUsers() {
        return new User[]{
                new User(1, "Daniel"),
                new User(2, "Max"),
                new User(3, "Hans")
        };
    }

    @DeleteMapping
    void deleteUser(User user) {
        // delete user
    }
}
