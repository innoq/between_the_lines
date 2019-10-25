package btl.simple.candidate;

import btl.simple.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CandidateValidationServiceTest {

  private static final String VALID_WEBSITE_TEXT = "EvaMigrA e.V. – beraten – begleiten – bilden Fragen? +49(0)40 291513 info@evamigra.org Über uns Jugendmigrationsdienste Historisches Unsere Arbeit Unsere Angebote Helfen Sie Helfern Geschäftsstelle Links Herzlich willkommen auf der Webseite der Evangelischen Migrationsjugendsozialarbeit in Hamburg und Brandenburg ©EvaMigrA e.V. Impressum / Haftungsausschluss / Datenschutzerklärung Verantw. i. S. P. für EvaMigrA e.V. ist der Vorstand: Witold Lopacki (1. Vorsitzender) ©2018 / EvaMigrA e.V., Foorthkamp 42, 22419 Hamburg, Tel. +49(0)40 291513";

  private static final String INVALID_WEBSITE_TEXT = "evamigra.de Diese Domain kaufen. evamigra.de 2019 Copyright. All Rights Reserved. Die hier angezeigten Sponsored Listings werden von dritter Seite automatisch generiert und stehen weder mit dem Domaininhaber noch mit dem Dienstanbieter in irgendeiner Beziehung. Sollten markenrechtliche Probleme auftreten, wenden Sie sich bitte direkt an den Domaininhaber, welcher aus dem Whois ersichtlich wird. Privacy Policy";

  @Autowired
  CandidateValidationService service;

  @Autowired
  CandidateService candidateService;

  @Test
  public void should_find_no_errors_on_valid_site() {
    Candidate candidate = candidateService.getCandidate();
    candidate.setWebsite("fine url");
    candidate.setWebcontent(VALID_WEBSITE_TEXT);
    List<CandidateFilterResult> results = service.validateCandidate(candidate);

    assertThat(results.stream().allMatch( r -> r.isResult()));
  }

  @Test
  public void should_find_error_if_no_impressum() {
    Candidate candidate = candidateService.getCandidate();
    candidate.setWebsite("fine url");
    candidate.setWebcontent(INVALID_WEBSITE_TEXT);
    List<CandidateFilterResult> results = service.validateCandidate(candidate);
    assertThat(results.stream().noneMatch( r -> r.isResult()));  }

}
