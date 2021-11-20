package springbootstudy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springbootstudy.model.entity.User;
import springbootstudy.model.enumClass.UserStatus;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.UserApiRequest;
import springbootstudy.model.network.response.UserApiResponse;

@Service
public class UserApiLogicService
    extends BaseService<UserApiRequest, UserApiResponse, User> {

    public Header<List<UserApiResponse>> search(Pageable pageable) {
        Page<User> users = baseRepository.findAll(pageable);
        List<UserApiResponse> userApiResponseList = users.stream()
            .map(this::response)
            .collect(Collectors.toList());
        return Header.OK(userApiResponseList);
    }

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        User user = User.builder()
            .account(userApiRequest.getAccount())
            .password(userApiRequest.getPassword())
            .status(UserStatus.REGISTERED)
            .phoneNumber(userApiRequest.getPhoneNumber())
            .email(userApiRequest.getEmail())
            .registeredAt(LocalDateTime.now())
            .build();
        User newUser = baseRepository.save(user);
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        Optional<User> selectedUser = baseRepository.findById(id);
        return selectedUser
            .map(this::response)
            .map(Header::OK)
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        Optional<User> selectedUser = baseRepository.findById(userApiRequest.getId());
        return selectedUser
            .map(user -> {
                user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setEmail(userApiRequest.getEmail())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
                return user;
            })
            .map(user -> baseRepository.save(user))
            .map(this::response)
            .map(Header::OK)
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header delete(Long id) {
        Optional<User> selectedUser = baseRepository.findById(id);
        return selectedUser
            .map(user -> {
                baseRepository.delete(user);
                return Header.OK();
            })
            .orElseGet(() -> Header.ERROR("no data"));
    }

    private UserApiResponse response(User user) {
        return UserApiResponse.builder()
            .id(user.getId())
            .account(user.getAccount())
            .password(user.getPassword()) // TODO : 암호화
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .status(user.getStatus())
            .registeredAt(user.getRegisteredAt())
            .unregisteredAt(user.getUnregisteredAt())
            .build();
    }
}
