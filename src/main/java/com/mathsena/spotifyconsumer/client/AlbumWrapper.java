package com.mathsena.spotifyconsumer.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlbumWrapper {

  private List<Album> items;

  public AlbumWrapper() {}

  public AlbumWrapper(List<Album> items) {
    this.items = items;
  }

  public List<Album> getItems() {
    return items;
  }

  public void setAlbums(List<Album> items) {
    this.items = items;
  }
}
