package springbootstudy.controller.api;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import springbootstudy.controller.CrudController;
import springbootstudy.model.entity.User;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.UserApiRequest;
import springbootstudy.model.network.response.UserApiResponse;
import springbootstudy.service.UserApiLogicService;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController
    extends CrudController<UserApiRequest, UserApiResponse, User> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("")
    public Header<List<UserApiResponse>> search(
        @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return userApiLogicService.search(pageable);
    }
}
