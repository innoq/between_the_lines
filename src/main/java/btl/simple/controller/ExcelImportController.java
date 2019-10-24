package btl.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/excel")
public class ExcelImportController {

    @GetMapping
    public @ResponseBody String getExcel() {

        return "done";
    }

}
