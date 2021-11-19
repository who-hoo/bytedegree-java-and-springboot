package springbootstudy.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springbootstudy.controller.CrudController;
import springbootstudy.model.entity.Item;
import springbootstudy.model.network.request.ItemApiRequest;
import springbootstudy.model.network.response.ItemApiResponse;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController
    extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
