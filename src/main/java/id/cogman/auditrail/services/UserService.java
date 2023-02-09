package id.cogman.auditrail.services;

import id.cogman.auditrail.dtos.UserRequest;
import id.cogman.auditrail.dtos.UserUpdateRequest;
import id.cogman.auditrail.entities.User;
import id.cogman.auditrail.mappers.UserMapper;
import id.cogman.auditrail.repositories.UserRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("user not found"));
  }

  public User create(UserRequest request) {
    return userRepository.save(UserMapper.toEntity(request));
  }

  public User update(UserUpdateRequest request) {
    return userRepository.save(UserMapper.toEntity(request));
  }

  public void delete(String id) {
    userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
    userRepository.deleteById(id);
  }

}
