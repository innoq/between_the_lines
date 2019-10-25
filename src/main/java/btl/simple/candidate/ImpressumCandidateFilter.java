package btl.simple.candidate;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ImpressumCandidateFilter implements CandidateFilter {

    private static final String KEY = "Impressum";

    @Override
    public CandidateFilterResult validateCandidate(Candidate candidate) {
        String text = null;
        try {
            text = candidate.getWebcontent();
        } catch (IOException e) {
            return new CandidateFilterResult(false, "Could not retrieve website content: " + e.getMessage());
        }
        if (null != text) {
            boolean contains = text.contains(KEY);
            return new CandidateFilterResult(contains, "Impressum found");
        }
        return new CandidateFilterResult(false, "No website content found");
    }
}
