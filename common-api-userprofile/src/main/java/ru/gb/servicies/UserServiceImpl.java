package ru.gb.servicies;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dtos.UserDto;
import ru.gb.entities.User;
import ru.gb.mappers.UserMapper;
import ru.gb.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper = UserMapper.MAPPER;
    private final UserRepository repository;

    @Override
    public UserDto getById(Long id) {
        User user = repository.findById(id).orElse(null);
//        if (user == null) {
//            throw new Exception("User:" + null);
//        }
        return mapper.fromUser(user);
    }

    @Override
    public void save(UserDto userDto) {
        repository.save(mapper.toUser(userDto));
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
