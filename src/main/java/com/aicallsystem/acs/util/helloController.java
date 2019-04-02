package com.aicallsystem.acs.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *      hello world 测试工具
 * </p>
 * @author ispong
 * @since 4/2/2019
 * @version 1.0.0
 */
@RestController
public class helloController {

    @GetMapping("hello")
    public ResponseEntity hello(){
        return new ResponseEntity("hello world!", HttpStatus.OK);
    }

}
