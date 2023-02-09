package id.cogman.auditrail.controllers;

import id.cogman.auditrail.dtos.UserRequest;
import id.cogman.auditrail.entities.User;
import id.cogman.auditrail.mappers.UserMapper;
import id.cogman.auditrail.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserControllers {

  private final UserService userService;

  @GetMapping
  public List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public User findById(@PathVariable("id") String id) {
    return userService.findById(id);
  }

  @PostMapping
  public User create(@RequestBody UserRequest request) {
    return userService.create(request);
  }

  @PutMapping("/{id}")
  public User update(@PathVariable("id") String id, @RequestBody UserRequest request) {
    return userService.update(UserMapper.toUpdateRequest(id, request));
  }

  @DeleteMapping("/{id}")
  public void update(@PathVariable("id") String id) {
    userService.delete(id);
  }

}
