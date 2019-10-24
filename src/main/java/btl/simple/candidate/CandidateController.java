package btl.simple.candidate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidateController {

  @PostMapping
  public ModelAndView uploadCandidates() {
    return null;
  }
}
