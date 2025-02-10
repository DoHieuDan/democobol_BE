package fa.training.controller;

import fa.training.service.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class ListUserController {
    @Autowired
    private ListUserService listUserService;

    @GetMapping("/{size}/{page}")
    public ResponseEntity<?> findAllUserPage(@PathVariable("size") Integer size, @PathVariable("page") Integer page) {
        return ResponseEntity.ok(listUserService.Paging(size, page));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(listUserService.findAll());
    }
}
