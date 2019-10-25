package btl.simple.googleplaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PlacesTextSearchResult {

  @JsonProperty("formatted_address")
  private String formattedAddress;

  private String id;

  private String name;

  @JsonProperty("place_id")
  private String placeId;

  public String getFormattedAddress() {
    return formattedAddress;
  }

  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlaceId() {
    return placeId;
  }

  public void setPlaceId(String placeId) {
    this.placeId = placeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlacesTextSearchResult that = (PlacesTextSearchResult) o;
    return Objects.equals(formattedAddress, that.formattedAddress) &&
        Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(placeId, that.placeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formattedAddress, id, name, placeId);
  }
}
