package springbootstudy.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootstudy.interfaces.CrudInterface;
import springbootstudy.model.entity.User;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.UserApiRequest;
import springbootstudy.model.network.response.UserApiResponse;
import springbootstudy.repository.UserRepository;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        User user = User.builder()
            .account(userApiRequest.getAccount())
            .password(userApiRequest.getPassword())
            .status("REGISTERED")
            .phoneNumber(userApiRequest.getPhoneNumber())
            .email(userApiRequest.getEmail())
            .registeredAt(LocalDateTime.now())
            .build();
        User newUser = userRepository.save(user);
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        Optional<User> selectedUser = userRepository.findById(id);
        return selectedUser
            .map(user -> response(user))
            .orElseGet(()-> Header.ERROR("no data"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        Optional<User> selectedUser = userRepository.findById(userApiRequest.getId());
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
            .map(user -> userRepository.save(user))
            .map(updatedUser -> response(updatedUser))
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
            .id(user.getId())
            .account(user.getAccount())
            .password(user.getPassword()) // TODO : 암호화
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .status(user.getStatus())
            .registeredAt(user.getRegisteredAt())
            .unregisteredAt(user.getUnregisteredAt())
            .build();
        return Header.OK(userApiResponse);
    }
}
