package springbootstudy.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springbootstudy.controller.CrudController;
import springbootstudy.model.entity.User;
import springbootstudy.model.network.request.UserApiRequest;
import springbootstudy.model.network.response.UserApiResponse;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController
    extends CrudController<UserApiRequest, UserApiResponse, User> {

}
