package btl.simple.candidate;

import org.junit.Test;

import static btl.simple.candidate.Candidate.fromTabCsv;
import static org.junit.Assert.assertEquals;

public class CandidateTest {

  @Test
  public void should_create_customer_from_csv_row() {
    Candidate candidate = fromTabCsv("EvaMigrA-Jugendmigrationsdienst Hamburg Langenhorn 	Käkenflur 16d	22419	Hamburg\tHamburg	040/52013600	jan.hamann@evamigra.de	http://www.evamigra.org/");
    Candidate expectedCandidate = new Candidate("EvaMigrA-Jugendmigrationsdienst Hamburg Langenhorn ", "Käkenflur 16d", "22419", "Hamburg", "Hamburg", "040/52013600", "jan.hamann@evamigra.de", "http://www.evamigra.org/");
    assertEquals(candidate, expectedCandidate);
  }
}
