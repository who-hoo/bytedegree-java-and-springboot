package springbootstudy.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootstudy.model.entity.OrderGroup;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.OrderGroupApiRequest;
import springbootstudy.model.network.response.OrderGroupApiResponse;
import springbootstudy.repository.UserRepository;

@Service
public class OrderGroupApiLogicService
    extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest req = request.getData();
        OrderGroup orderGroup = OrderGroup.builder()
            .status(req.getStatus())
            .orderType(req.getOrderType())
            .revAddress(req.getRevAddress())
            .revName(req.getRevName())
            .paymentType(req.getPaymentType())
            .totalPrice(req.getTotalPrice())
            .totalQuantity(req.getTotalQuantity())
            .orderAt(LocalDateTime.now())
            .user(userRepository.getById(req.getUserId()))
            .build();
        OrderGroup newOrderGroup = baseRepository.save(orderGroup);
        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        Optional<OrderGroup> selectedOrderGroup = baseRepository.findById(id);
        return selectedOrderGroup
            .map(orderGroup -> response(orderGroup))
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest req = request.getData();
        Optional<OrderGroup> selectedOrderGroup = baseRepository.findById(req.getId());
        return selectedOrderGroup
            .map(orderGroup -> {
                orderGroup.setStatus(req.getStatus())
                    .setOrderType(req.getOrderType())
                    .setRevAddress(req.getRevAddress())
                    .setRevName(req.getRevName())
                    .setPaymentType(req.getPaymentType())
                    .setTotalPrice(req.getTotalPrice())
                    .setTotalQuantity(req.getTotalQuantity())
                    .setOrderAt(req.getOrderAt())
                    .setArrivalDate(req.getArrivalDate())
                    .setUser(userRepository.getById(req.getUserId()));
                return orderGroup;
            })
            .map(orderGroup -> baseRepository.save(orderGroup))
            .map(updateOrderGroup -> response(updateOrderGroup))
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header delete(Long id) {
        Optional<OrderGroup> selectedOrderGroup = baseRepository.findById(id);
        return selectedOrderGroup
            .map(orderGroup -> {
                baseRepository.delete(orderGroup);
                return Header.OK();
            })
            .orElseGet(() -> Header.ERROR("no data"));
    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup) {
        OrderGroupApiResponse res = OrderGroupApiResponse.builder()
            .id(orderGroup.getId())
            .status(orderGroup.getStatus())
            .orderType(orderGroup.getOrderType())
            .revAddress(orderGroup.getRevAddress())
            .revName(orderGroup.getRevName())
            .paymentType(orderGroup.getPaymentType())
            .totalPrice(orderGroup.getTotalPrice())
            .totalQuantity(orderGroup.getTotalQuantity())
            .orderAt(orderGroup.getOrderAt())
            .arrivalDate(orderGroup.getArrivalDate())
            .userId(orderGroup.getUser().getId())
            .build();
        return Header.OK(res);
    }
}
