package btl.simple.candidate;

import btl.simple.candidate.ValidationErrors.ValidationError;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CandidateValidationService {

  private final Scraper scraper;

  @Autowired
  public CandidateValidationService(Scraper scraper) {
    this.scraper = scraper;
  }

  public Map<Candidate, ValidationErrors> validateCandidates(List<Candidate> candidates) {
    return null;
  }

  public ValidationErrors validateCandidate(Candidate candidate) {
    ValidationErrors errors = new ValidationErrors();
    try {
      String text = scraper.getText(candidate.getWebsite());
      System.out.println(text);
    } catch (IOException e) {
      errors.addError("url", new ValidationError("url not reachable"));
    }
    return errors;
  }


}
