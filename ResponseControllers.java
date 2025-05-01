package Stafff;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/response")

public class ResponseControllers {
    // Nane : MOhamed alin osmaan , Id:c1220249, class: CA221


    @GetMapping ("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Success!");
        return new ResponseEntity<>("Success!", headers, HttpStatus.OK);

    }
    @GetMapping("/not-found")
    public ResponseEntity<Map<String, String>> notFound() {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Resource not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create")
    public ResponseEntity<String> create() {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand("123") //  replace "123" with the actual ID of the created resource
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>("Resource created", headers, HttpStatus.CREATED);
    }

}
