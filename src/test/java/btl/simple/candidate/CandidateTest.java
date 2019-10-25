package btl.simple.candidate;

import btl.simple.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CandidateTest {

  @Autowired
  CandidateService candidateService;

  @Test
  public void should_create_customer_from_csv_row() {
    Candidate candidate = candidateService.fromTabCsv("EvaMigrA-Jugendmigrationsdienst Hamburg Langenhorn 	Käkenflur 16d	22419	Hamburg\tHamburg	040/52013600	jan.hamann@evamigra.de	http://www.evamigra.org/");
    Candidate expectedCandidate = candidateService.getCandidate("EvaMigrA-Jugendmigrationsdienst Hamburg Langenhorn ", "Käkenflur 16d", "22419", "Hamburg", "Hamburg", "040/52013600", "jan.hamann@evamigra.de", "http://www.evamigra.org/");
    assertEquals(candidate, expectedCandidate);
  }
}
