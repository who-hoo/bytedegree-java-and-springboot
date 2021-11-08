package springbootstudy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootstudy.model.SearchParam;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping("/post")
    public SearchParam post(@RequestBody SearchParam param) {
        return param;
    }
}
