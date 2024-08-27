package net.javaguides.oms.service.user;

import lombok.AllArgsConstructor;
import net.javaguides.oms.dto.UserDto;
import net.javaguides.oms.entity.User;
import net.javaguides.oms.exception.ResourceNotFoundException;
import net.javaguides.oms.mapper.UserMapper;
import net.javaguides.oms.repository.UserRepository;
import net.javaguides.oms.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserByEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User is not exists with given email: " + userEmail));

        return UserMapper.mapToUserDto(user);
    }
}
