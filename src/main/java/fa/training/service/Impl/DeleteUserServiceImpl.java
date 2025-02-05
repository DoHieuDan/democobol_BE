package fa.training.service.Impl;

import fa.training.model.User;
import fa.training.repository.UserDeleteReository;
import fa.training.service.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class DeleteUserServiceImpl implements DeleteUserService {
    @Autowired
    UserDeleteReository userRepository;

    @Override
    public List<User> findByUserId(String userId){
        List<User> user = userRepository.findByUserId(userId);
        return userRepository.findByUserId(userId);
    }
    @Override
    public void deleteUserById(String userId) throws NoResourceFoundException {

    }


}
