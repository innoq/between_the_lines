package btl.simple.googleplaces;

import btl.simple.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class SearchPlacesServiceIT {

  @Autowired
  private SearchPlacesService placesService;

  @Test
  public void should_find_relevant_places_per_city() throws IOException {
    File file = new ClassPathResource("cities.txt").getFile();
    List<String> cityNames = Files.readAllLines(file.toPath());
    Path resultCsv = Files.createFile(Paths.get("results.csv"));
    List<PlacesTextSearchResult> result = cityNames.stream()
        .map(String::trim)
        .flatMap(name -> placesService.searchByCity(name).stream())
        .collect(toList());
    BufferedWriter writer = new BufferedWriter(new FileWriter(resultCsv.toFile()));
    result.stream()
        .map(r -> r.getName()+"\t"+r.getFormattedAddress()+"\t"+r.getPlaceId()+"\t"+r.getId()+"\n")
        .forEach(csv -> {
          try {
            writer.write(csv);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
  }

}
