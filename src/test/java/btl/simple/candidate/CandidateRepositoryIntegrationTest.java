package btl.simple.candidate;

import btl.simple.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CandidateRepositoryIntegrationTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @Test
    public void shouldCreateCandidate() {
        Candidate candidate = new Candidate();
        candidate.setAddress("Testaddress");
        candidate.setLocation("Testlocation");
        candidate.setMail("test@example.com");
        candidate.setName("testorganisationname");
        candidate.setPhoneNumbers("testphonenumber");
        candidate.setPostalCode("testpostalcode");
        candidate.setWebsite("testwebsite");
        Candidate save = candidateRepository.save(candidate);


        assertThat(candidateRepository.findById(save.getId()).get().getName())
                .isEqualTo(candidate.getName());
    }

}