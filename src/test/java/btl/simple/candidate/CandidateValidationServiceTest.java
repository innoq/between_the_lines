package btl.simple.candidate;

import org.junit.Test;

import static btl.simple.candidate.Candidate.fromTabCsv;
import static org.junit.Assert.fail;

public class CandidateValidationServiceTest {

  @Test
  public void should_not_validate_candidate_site_misses_name() {
    Candidate candidate = fromTabCsv("EvaMigrA-Jugendmigrationsdienst Hamburg Langenhorn 	Käkenflur 16d	22419	Hamburg	040/52013600	jan.hamann@evamigra.de	http://www.evamigra.org/");
    fail();
  }


}
