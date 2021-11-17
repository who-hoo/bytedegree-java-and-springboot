package springbootstudy.service;

import java.time.LocalDateTime;
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
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
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
