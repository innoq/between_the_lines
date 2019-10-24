package btl.simple.crawler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crawler")
public class CrawlerController {

    @GetMapping
    public String get() {
        return "crawler";
    }

}
