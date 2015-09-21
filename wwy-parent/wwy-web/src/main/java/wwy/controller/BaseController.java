package wwy.controller;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;

@Controller
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=600)
public class BaseController {
}
