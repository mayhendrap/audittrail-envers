package id.cogman.auditrail.mappers;

import id.cogman.auditrail.dtos.UserRequest;
import id.cogman.auditrail.dtos.UserUpdateRequest;
import id.cogman.auditrail.entities.User;

public class UserMapper {

  public static User toEntity(UserRequest request) {
    return User.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .build();
  }

  public static User toEntity(UserUpdateRequest request) {
    return User.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .build();
  }

  public static UserUpdateRequest toUpdateRequest(String id, UserRequest request) {
    return UserUpdateRequest.builder()
        .id(id)
        .username(request.getUsername())
        .password(request.getPassword())
        .build();
  }

}
