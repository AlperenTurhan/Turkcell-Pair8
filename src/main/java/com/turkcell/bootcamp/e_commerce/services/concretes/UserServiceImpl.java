package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.core.exception.types.BusinessException;
import com.turkcell.bootcamp.e_commerce.core.services.abstracts.MessageService;
import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import com.turkcell.bootcamp.e_commerce.entities.User;
import com.turkcell.bootcamp.e_commerce.repositories.UserRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.UserService;
import com.turkcell.bootcamp.e_commerce.services.dtos.user.requests.AddUserRequest;
import com.turkcell.bootcamp.e_commerce.services.dtos.user.responses.UserListResponse;
import com.turkcell.bootcamp.e_commerce.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MessageService messageService;

    @Override
    public void add(AddUserRequest request) throws Exception {
        usersWithSameEmailShouldNotExist(request.getEmail());

        User user = UserMapper.INSTANCE.userFromAddUserRequest(request);
        userRepository.save(user);
    }

    @Override
    public void delete(int id) throws Exception {
        if(!isIdExist(id)){
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
    }

    @Override
    public void update(User user) throws Exception {

    }

    @Override
    public List<UserListResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserListResponse> response = new ArrayList<>();

        for (User user: users) {
            UserListResponse dto = new UserListResponse(
                    user.getId(),
                    user.getName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhoneNumber());
            response.add(dto);
        }
        return response;
    }

    @Override
    public User getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        return userRepository.findById(id).get();
    }

    public boolean isIdExist(int id) {
        return userRepository.existsById(id);
    }

    private void usersWithSameEmailShouldNotExist(String email) throws Exception {
        Optional<User> userWithSameEmail = userRepository.findByEmail(email);
        if (userWithSameEmail.isPresent()) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.SAME_EMAIL_ERROR, email));
        }
    }
}
