package springbootstudy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springbootstudy.model.entity.Item;
import springbootstudy.model.entity.OrderDetail;
import springbootstudy.model.entity.OrderGroup;
import springbootstudy.model.entity.User;
import springbootstudy.model.enumClass.UserStatus;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.UserApiRequest;
import springbootstudy.model.network.response.ItemApiResponse;
import springbootstudy.model.network.response.OrderGroupApiResponse;
import springbootstudy.model.network.response.UserApiResponse;
import springbootstudy.model.network.response.UserOrderInfoApiResponse;

@Service
public class UserApiLogicService
    extends BaseService<UserApiRequest, UserApiResponse, User> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    public Header<List<UserApiResponse>> search(Pageable pageable) {
        Page<User> users = baseRepository.findAll(pageable);
        List<UserApiResponse> userApiResponseList = users.stream()
            .map(this::response)
            .collect(Collectors.toList());
        return Header.OK(userApiResponseList);
    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {
        User user = baseRepository.getOne(id);
        UserApiResponse userApiResponse = response(user);

        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
            .map(orderGroup -> {
                OrderGroupApiResponse orderGroupApiResponse = orderGroupApiLogicService
                    .response(orderGroup).getData();
                List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                    .map(OrderDetail::getItem)
                    .map(item -> itemApiLogicService.response(item).getData())
                    .collect(Collectors.toList());
                orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                return orderGroupApiResponse;
            })
            .collect(Collectors.toList());

        userApiResponse.setOrderGroupApiResponseList(orderGroupApiResponseList);

        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder()
            .userApiResponse(userApiResponse)
            .build();

        return Header.OK(userOrderInfoApiResponse);
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
