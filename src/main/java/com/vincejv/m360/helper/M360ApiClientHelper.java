package com.vincejv.m360.helper;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

import com.vincejv.m360.dto.ApiResponse;
import com.vincejv.m360.dto.BroadcastRequest;
import com.vincejv.m360.dto.BroadcastResponse;
import com.vincejv.m360.dto.SMSRequest;
import com.vincejv.m360.service.M360ApiClientSvc;
import com.vincejv.m360.util.Constants;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;

public class M360ApiClientHelper {

  private final M360ApiClientSvc svc;

  private final String appKey;

  private final String appSecret;

  private final String senderId;

  private final String baseApiUrl;

  public M360ApiClientHelper(String baseApiUrl, String appKey, String appSecret, String senderId) {
    svc = new M360ApiClientSvc();
    this.baseApiUrl = baseApiUrl;
    this.appKey = appKey;
    this.appSecret = appSecret;
    this.senderId = senderId;
  }

  public M360ApiClientHelper(HttpClient httpClient, String baseApiUrl, String appKey, String appSecret, String senderId) {
    svc = new M360ApiClientSvc(httpClient);
    this.baseApiUrl = baseApiUrl;
    this.appKey = appKey;
    this.appSecret = appSecret;
    this.senderId = senderId;
  }

  public CompletableFuture<ApiResponse<BroadcastResponse>> sendBroadcastMessage(BroadcastRequest broadcastRequest) {
    return svc.httpPost(getUrl(Constants.BROADCAST), new ApiResponse<BroadcastResponse>(),
      new TypeReference<BroadcastResponse>() {
      }, broadcastRequest);
  }

  public CompletableFuture<ApiResponse<BroadcastResponse>> sendBroadcastMessage(SMSRequest smsRequest) {
    var broadcastRequest = new BroadcastRequest();
    broadcastRequest.setAppKey(appKey);
    broadcastRequest.setAppSecret(appSecret);
    broadcastRequest.setSenderId(senderId);
    broadcastRequest.setContent(smsRequest.getContent());
    broadcastRequest.setIsInternational(smsRequest.getIsInternational());
    broadcastRequest.setDataCodingScheme(smsRequest.getDataCodingScheme());
    broadcastRequest.setMobileNumber(smsRequest.getMobileNumber());
    return sendBroadcastMessage(broadcastRequest);
  }

  @SneakyThrows
  private String getUrl(String path) {
    StringBuilder sb = new StringBuilder(baseApiUrl);

    sb.append(path);

    return new URI(sb.toString()).normalize().toString();
  }

}
