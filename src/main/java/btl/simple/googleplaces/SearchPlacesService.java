package btl.simple.googleplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
public class SearchPlacesService {

  private final Environment environment;


  @Autowired
  public SearchPlacesService(Environment environment) {
    this.environment = environment;
  }


  public List<PlacesTextSearchResult> searchByCity(String cityName) {
    System.out.println("search for city '" + cityName + "'");
    List<PlacesTextSearchResult> results = new ArrayList<>();
    RestTemplate restTemplate = new RestTemplate();
    String key = environment.getRequiredProperty("API_KEY");
    String searchKeyWord = "jugendhilfe";
    String uri = fromHttpUrl("https://maps.googleapis.com/maps/api/place/textsearch/json")
        .queryParam("query", searchKeyWord + "+" + cityName)
        .queryParam("key", key)
        .toUriString();
    ResponseEntity<PlacesTextSearchResults> response = restTemplate.getForEntity(uri, PlacesTextSearchResults.class);
    PlacesTextSearchResults body = response.getBody();
    results.addAll(body.getResults());
    while (body.getNextPageToken() != null) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      String nextPageUri = fromHttpUrl("https://maps.googleapis.com/maps/api/place/textsearch/json")
          .queryParam("pagetoken", body.getNextPageToken())
          .queryParam("key", key)
          .toUriString();
      ResponseEntity<PlacesTextSearchResults> nextPageResponse = restTemplate.getForEntity(nextPageUri, PlacesTextSearchResults.class);
      body = nextPageResponse.getBody();
      results.addAll(body.getResults());
    }

    System.out.println("found " + results.size() + " results for city " + cityName);
    return results;
  }
}
