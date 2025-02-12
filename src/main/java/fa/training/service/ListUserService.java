package fa.training.service;

import fa.training.dto.response.UserPageResponseDTO;
import fa.training.dto.response.UserResponseDTO;
import fa.training.mapper.UserMapper;
import fa.training.model.User;
import fa.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

//    public List<UserResponseDTO> Paging (Integer size, Integer page) {
//        if (size == null || page == null) {
//            size = 1;
//            page = 1;
//        }
//        Pageable pageable = PageRequest.of(page - 1, size);
//        return userRepository.findAll(pageable).getContent().stream()
//                .map(a -> userMapper.toUserResponse(a)).collect(Collectors.toList());
//    }
public UserPageResponseDTO Paging(Integer size, Integer page) {
    if (size == null || page == null) {
            size = 1;
            page = 1;
        }

    Pageable pageable = PageRequest.of(page - 1, size);
    Page<User> userPage = userRepository.findAll(pageable);

    List<UserResponseDTO> userDTOs = userPage.getContent().stream()
            .map(userMapper::toUserResponse)
            .collect(Collectors.toList());

    return UserPageResponseDTO.builder()
            .users(userDTOs)
            .totalUsers(userPage.getTotalElements())
            .currentPage(page)
            .totalPages(userPage.getTotalPages())
            .build();
}

    public List<UserResponseDTO> findAll() {
        try {
            return userRepository.findAll().stream().map(user -> userMapper.toUserResponse(user))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong",e);
        }
    }
}
