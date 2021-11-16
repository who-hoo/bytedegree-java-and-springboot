package springbootstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springbootstudy.model.SearchParam;
import springbootstudy.model.network.Header;

@RestController
@RequestMapping("/api")
public class GetController {

    // localhost:8080/api/get
    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public String get() {
        return "hello world";
    }

    // localhost:8080/api/getSingleParameter?name=hoo
    @GetMapping("/getSingleParameter")
    public String getSingleParameter(@RequestParam(name = "name") String param) {
        return "request param : " + param;
    }

    // localhost:8080/api/getMultiParameter?account=hoo&email=multi@param.practice&phoneNumber=010-1234-5678
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam param) {
        return param;
    }

    @GetMapping("/header")
    public Header getHeader() {
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
