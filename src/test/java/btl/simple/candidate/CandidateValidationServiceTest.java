package btl.simple.candidate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidateValidationServiceTest {

  private static final String VALID_WEBSITE_TEXT = "EvaMigrA e.V. – beraten – begleiten – bilden Fragen? +49(0)40 291513 info@evamigra.org Über uns Jugendmigrationsdienste Historisches Unsere Arbeit Unsere Angebote Helfen Sie Helfern Geschäftsstelle Links Herzlich willkommen auf der Webseite der Evangelischen Migrationsjugendsozialarbeit in Hamburg und Brandenburg ©EvaMigrA e.V. Impressum / Haftungsausschluss / Datenschutzerklärung Verantw. i. S. P. für EvaMigrA e.V. ist der Vorstand: Witold Lopacki (1. Vorsitzender) ©2018 / EvaMigrA e.V., Foorthkamp 42, 22419 Hamburg, Tel. +49(0)40 291513";

  private static final String INVALID_WEBSITE_TEXT = "evamigra.de Diese Domain kaufen. evamigra.de 2019 Copyright. All Rights Reserved. Die hier angezeigten Sponsored Listings werden von dritter Seite automatisch generiert und stehen weder mit dem Domaininhaber noch mit dem Dienstanbieter in irgendeiner Beziehung. Sollten markenrechtliche Probleme auftreten, wenden Sie sich bitte direkt an den Domaininhaber, welcher aus dem Whois ersichtlich wird. Privacy Policy";

  @Test
  public void should_find_no_errors_on_valid_site() {

    CandidateValidationService service = new CandidateValidationService(new Scraper() {
      @Override
      String getText(String url) {
        return VALID_WEBSITE_TEXT;
      }
    });
    Candidate candidate = new Candidate();
    candidate.setWebsite("fine url");
    ValidationErrors errors = service.validateCandidate(candidate);

    assertThat(errors.isEmpty()).isTrue();
  }

  @Test
  public void should_find_invalid_url_if_site_does_not_match() {
    CandidateValidationService service = new CandidateValidationService(new Scraper() {
      @Override
      String getText(String url) {
        return INVALID_WEBSITE_TEXT;
      }
    });
    Candidate candidate = new Candidate();
    candidate.setWebsite("http://www.evamigra.de/");
    ValidationErrors errors = service.validateCandidate(candidate);

    assertThat(errors.isEmpty()).isFalse();
  }

}
