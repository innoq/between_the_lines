package btl.simple.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    Scraper scraper;

    public Candidate getCandidate() {
        CandidateImpl ret = new CandidateImpl();
        ret.setScraper(this.scraper);
        return ret;
    }

    public Candidate getCandidate(String name,
                                  String address,
                                  String postalCode,
                                  String location,
                                  String state,
                                  String phoneNumbers,
                                  String mail,
                                  String website) {
        CandidateImpl ret = new CandidateImpl(name, address, postalCode, location, state, phoneNumbers, mail, website);
        ret.setScraper(this.scraper);
        return ret;
    }

    public Candidate fromTabCsv(String candidateAsCsv) {
        CandidateImpl ret = CandidateImpl.fromTabCsv(candidateAsCsv);
        ret.setScraper(this.scraper);
        return ret;
    }

}
