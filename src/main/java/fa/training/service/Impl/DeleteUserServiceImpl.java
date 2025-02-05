package fa.training.service.Impl;

import fa.training.model.User;
import fa.training.repository.UserDeleteReository;
import fa.training.repository.UserRepository;
import fa.training.service.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Optional;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {
    @Autowired
    UserDeleteReository userRepository;

    @Override
    public Optional<User> findByUserId(String userId){

    }
    @Override
    public void deleteUserById(String userId) throws NoResourceFoundException {
        Optional<User> userOptional = userRepository.findByUserId(userId);
    }


}
