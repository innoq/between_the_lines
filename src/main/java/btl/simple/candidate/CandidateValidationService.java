package btl.simple.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CandidateValidationService {

  @Autowired
  List<CandidateFilter> filters;

  public CandidateValidationService() {
  }

  public Map<Candidate, CandidateFilterResult> validateCandidates(List<Candidate> candidates) {
    return null;
  }

  public List<CandidateFilterResult> validateCandidate(Candidate candidate) {
    ArrayList<CandidateFilterResult> results = new ArrayList<>(filters.size());
    filters.stream().forEach( filter -> results.add(filter.validateCandidate(candidate)));
    return results;
  }

}
