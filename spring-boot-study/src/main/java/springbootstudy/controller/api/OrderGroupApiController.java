package springbootstudy.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springbootstudy.controller.CrudController;
import springbootstudy.model.entity.OrderGroup;
import springbootstudy.model.network.request.OrderGroupApiRequest;
import springbootstudy.model.network.response.OrderGroupApiResponse;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController
    extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
