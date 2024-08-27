package net.javaguides.oms.service.user;

import net.javaguides.oms.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByEmail(String userEmail);

}
