package com.vincejv.m360.service;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

import com.vincejv.m360.dto.ApiResponse;
import com.vincejv.m360.dto.ApiRequest;
import com.vincejv.m360.exception.M360ApiException;
import com.vincejv.m360.util.ApiResponseBuilder;
import com.vincejv.m360.util.Constants;
import com.vincejv.m360.util.HttpConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class M360ApiClientSvc {
  
  private final HttpClient httpClient;

  private final ApiResponseBuilder apiResponseBuilder;

  public M360ApiClientSvc() {
    this.apiResponseBuilder = new ApiResponseBuilder();
    this.httpClient = HttpClient.newBuilder().build();
  }

  public M360ApiClientSvc(HttpClient httpClient) {
    this.apiResponseBuilder = new ApiResponseBuilder();
    this.httpClient = httpClient;
  }

  public <T> CompletableFuture<ApiResponse<T>> httpPost(String uri, ApiResponse<T> apiResponse,
                                                        TypeReference<T> typeReference,
                                                        ApiRequest apiRequest) {
    return apiResponseBuilder.prepareResponse(apiResponse, typeReference,
      executePost(uri, apiRequest));
  }

  private HttpRequest.Builder buildBaseRequest(String url) throws URISyntaxException {
    return HttpRequest.newBuilder(new URI(url))
      .header(HttpConstants.CONTENT_TYPE, HttpConstants.APPLICATION_JSON)
      .header(HttpConstants.USER_AGENT, Constants.M360_API_SDK_VERSION);
  }

  private HttpRequest getHttpGet(String url) throws URISyntaxException {
    return buildBaseRequest(url)
      .GET().build();
  }

  private HttpRequest getHttpPost(String url, InputStream stream) throws URISyntaxException {
    return buildBaseRequest(url)
      .POST(HttpRequest.BodyPublishers.ofInputStream(()->
        stream)).build();
  }

  private HttpRequest getHttpPost(String url, byte[] body) throws URISyntaxException {
    return buildBaseRequest(url)
      .POST(HttpRequest.BodyPublishers.ofByteArray(body)).build();
  }

  private HttpRequest getHttpPost(String url) throws URISyntaxException {
    return buildBaseRequest(url)
      .POST(HttpRequest.BodyPublishers.noBody()).build();
  }

  public CompletableFuture<HttpResponse<InputStream>> executeGet(String url) {
    try {
      return httpClient.sendAsync(getHttpGet(url),
        HttpResponse.BodyHandlers.ofInputStream());
    } catch (URISyntaxException e) {
      return CompletableFuture.failedFuture(new M360ApiException(e));
    }
  }

  public CompletableFuture<HttpResponse<InputStream>> executePost(String url, InputStream stream)
    throws URISyntaxException {
    return httpClient.sendAsync(getHttpPost(url, stream),
      HttpResponse.BodyHandlers.ofInputStream());
  }

  public CompletableFuture<HttpResponse<InputStream>> executePost(String url, ApiRequest request)
  {
    try {
      if (request != null) {
        return httpClient.sendAsync(getHttpPost(url,
            ApiResponseBuilder.getObjectMapper().
              writerFor(request.getClass()).writeValueAsBytes(request)),
          HttpResponse.BodyHandlers.ofInputStream());
      } else {
        return httpClient.sendAsync(getHttpPost(url),
          HttpResponse.BodyHandlers.ofInputStream());
      }
    } catch (JsonProcessingException | URISyntaxException ex) {
      return CompletableFuture.failedFuture(new M360ApiException(ex));
    }
  }

  public CompletableFuture<HttpResponse<InputStream>> executePost(String url, String postBody)
    throws URISyntaxException {
    return httpClient.sendAsync(getHttpPost(url,
        postBody.getBytes(StandardCharsets.UTF_8)),
      HttpResponse.BodyHandlers.ofInputStream());
  }


}
