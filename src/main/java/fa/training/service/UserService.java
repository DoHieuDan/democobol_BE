package fa.training.service;

import fa.training.accessor.SecUserData_Accessor;
import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.request.UserUpdateRequest;
import fa.training.dto.response.ApiResponse;
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

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    String userSecFilePath = "src/main/java/fa/training/data/user_security.txt";

    public UserResponseDTO addUserSecFile(UserRequestDTO userRequestDTO) {

        if (checkUserIdExists(userRequestDTO.getUserId()))
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

        while (!userSecFile.isEOF()) {
            userSecFile.readLine();
            if (userSecFile.getCurrentLine().substring(0, 8).equals(userId)) {
                userSecFile.close();
                return true;
            }
        }

        userSecFile.close();
        return false;
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByUserId(userRequestDTO.getUserId()))
            throw new DataIntegrityViolationException("User ID already exist...");

        User user = userMapper.toUser(userRequestDTO);

        user.setFirstName(FieldFormat.format(20, user.getFirstName()));
        user.setLastName(FieldFormat.format(20, user.getLastName()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponseDTO updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User ID NOT found..."));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponseDTO updateUserSecFile(String id, UserUpdateRequest request) {
        // Mở file để chỉnh sửa
        FileAccessBase userSecFile = new FileAccessBase(userSecFilePath);
        userSecFile.open(FileOpenMode.IN);

        StringBuilder fileContent = new StringBuilder();
        boolean isUserFound = false;

        // Đọc từng dòng trong file
        while (!userSecFile.isEOF()) {
            userSecFile.readLine();
            String line = userSecFile.getCurrentLine();
            // Kiểm tra nếu dòng này là của người dùng với id tương ứng
            if (line != null && line.length() >= 8 && line.substring(0, 8).trim().equals(id)) {
                SecUserData userData = SecUserData_Accessor.parseSecUserData(line);  // Chuyển đổi dòng thành đối tượng SecUserData

                // Cập nhật thông tin người dùng
                userData.setSecUsrFname(FieldFormat.format(20, request.getFirstName()));
                userData.setSecUsrLname(FieldFormat.format(20, request.getLastName()));
                userData.setSecUsrPwd(request.getPassword());
                userData.setSecUsrType(request.getRole());

                // Thay đổi dòng dữ liệu
                line = SecUserData_Accessor.getSecUserData(userData);
                isUserFound = true;
            }

            // Ghi lại dòng vào StringBuilder
            if (line != null) {
                fileContent.append(line).append(System.lineSeparator());
            }
        }

        userSecFile.close();

        if (!isUserFound) {
            throw new RuntimeException("User ID not found...");
        }

        // Mở lại file để ghi dữ liệu đã cập nhật
        userSecFile.open(FileOpenMode.OUT);
        userSecFile.write(fileContent.toString());
        userSecFile.close();

        // Trả về thông tin người dùng đã cập nhật
        SecUserData updatedUserData = SecUserData_Accessor.parseSecUserData(fileContent.toString());
        return userMapper.toUserResponse(updatedUserData);
    }

    public UserResponseDTO getUserById(String userId) {
        return userMapper.toUserResponse(userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User ID NOT found...")));
    }

    public List<UserResponseDTO> getUserList() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    public ApiResponse<Void> deleteUserById(String userId) {
//        User user = userRepository.findUserByUserId(userId);
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User ID NOT found..."));
        if (user == null) {
            return new ApiResponse<>(404, "User not found", null);
        }
        user.setBlock(true);
        userRepository.save(user);
        return new ApiResponse<>(200, "User successfully blocked", null);
    }

    public ApiResponse<UserResponseDTO> findByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        if (user.isEmpty() || user.get().isBlock()) {
            return new ApiResponse<>(404, "User not found", null);
        }
        UserResponseDTO userResponseDTO = userMapper.toUserResponse(user.orElse(null));
        return new ApiResponse<>(200, "User found", userResponseDTO);
    }
}
