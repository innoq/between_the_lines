package btl.simple.googleplaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class PlacesTextSearchResults {

  @JsonProperty("next_page_token")
  private String nextPageToken;

  private List<PlacesTextSearchResult> results;

  public String getNextPageToken() {
    return nextPageToken;
  }

  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
  }

  public List<PlacesTextSearchResult> getResults() {
    return results;
  }

  public void setResults(List<PlacesTextSearchResult> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlacesTextSearchResults that = (PlacesTextSearchResults) o;
    return Objects.equals(nextPageToken, that.nextPageToken) &&
        Objects.equals(results, that.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextPageToken, results);
  }
}
