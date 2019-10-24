package btl.simple.candidate;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CandidateValidationService {

  public Map<Candidate, ValidationErrors> validateCandidates(List<Candidate> candidates) {
    return null;
  }

  public ValidationErrors validateCandidate(Candidate candidate) {
    return null;
  }

}
