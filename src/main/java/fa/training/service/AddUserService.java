package fa.training.service;

import fa.training.accessor.SecUserData_Accessor;
import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.response.UserResponseDTO;
import fa.training.lib.constants.ValueConst;
import fa.training.lib.file.FileAccessBase;
import fa.training.lib.file.FileOpenMode;
import fa.training.lib.util.FieldFormat;
import fa.training.mapper.UserMapper;
import fa.training.model.*;
import fa.training.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddUserService {
    UserRepository userRepository;
    UserMapper userMapper;

    String userSecFilePath = "src/main/java/fa/training/data/user_security.txt";

    public UserResponseDTO addUserSecFile(UserRequestDTO userRequestDTO) {

        if(checkUserIdExists(userRequestDTO.getUserId()))
            throw new DataIntegrityViolationException("User ID already exist...");

        SecUserData secUserData = userMapper.toSecUser(userRequestDTO);

        secUserData.setSecUsrId(userRequestDTO.getUserId());
        secUserData.setSecUsrFname(FieldFormat.format(20, userRequestDTO.getFirstName()));
        secUserData.setSecUsrLname(FieldFormat.format(20, userRequestDTO.getLastName()));
        secUserData.setSecUsrPwd(userRequestDTO.getPassword());
        secUserData.setSecUsrType(userRequestDTO.getRole());
        secUserData.setSecUsrFiller(FieldFormat.format(23, ValueConst.SPACE));


        FileAccessBase userSecFile = new FileAccessBase(userSecFilePath);
        userSecFile.open(FileOpenMode.OUT);
        userSecFile.write(SecUserData_Accessor.getSecUserData(secUserData));
        userSecFile.close();

        return userMapper.toUserResponse(secUserData);
    }

    private boolean checkUserIdExists(String userId) {
        FileAccessBase userSecFile = new FileAccessBase(userSecFilePath);
        userSecFile.open(FileOpenMode.IN);

        while(!userSecFile.isEOF()) {
            userSecFile.readLine();
            if (userSecFile.getCurrentLine().substring(0,8).equals(userId)) {
                userSecFile.close();
                return true;
            }
        }

        userSecFile.close();
        return false;
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if(userRepository.existsByUserId(userRequestDTO.getUserId()))
            throw new DataIntegrityViolationException("User ID already exist...");

        User user = userMapper.toUser(userRequestDTO);

        user.setFirstName(FieldFormat.format(20, user.getFirstName()));
        user.setLastName(FieldFormat.format(20, user.getLastName()));

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
