package springbootstudy.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springbootstudy.controller.CrudController;
import springbootstudy.model.entity.Partner;
import springbootstudy.model.network.request.PartnerApiRequest;
import springbootstudy.model.network.response.PartnerApiResponse;

@Slf4j
@RestController
@RequestMapping("/api/partner")
public class PartnerApiController
    extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

}
