package com.mathsena.spotifyconsumer.controller;

import com.mathsena.spotifyconsumer.client.Album;
import com.mathsena.spotifyconsumer.client.AlbumSpotifyClient;
import com.mathsena.spotifyconsumer.client.AuthSpotifyClient;
import com.mathsena.spotifyconsumer.client.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

  private final AuthSpotifyClient authSpotifyClient;
  private final AlbumSpotifyClient albumSpotifyClient;

  @Value("${spotify.client.id}")
  private String clientId;

  @Value("${spotify.client.secret}")
  private String clientSecret;

  public AlbumController(
      AuthSpotifyClient authSpotifyClient, AlbumSpotifyClient albumSpotifyClient) {
    this.authSpotifyClient = authSpotifyClient;
    this.albumSpotifyClient = albumSpotifyClient;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Album>> getAllAlbums() {
    String token = fetchAccessToken();
    List<Album> albums = fetchAlbums(token);

    return ResponseEntity.ok(albums);
  }

  private String fetchAccessToken() {
    LoginRequest loginRequest = new LoginRequest("client_credentials", clientId, clientSecret);
    return authSpotifyClient.login(loginRequest).getAccessToken();
  }

  private List<Album> fetchAlbums(String token) {
    var response = albumSpotifyClient.getReleases("Bearer " + token);
    return response.getAlbums().getItems();
  }
}
