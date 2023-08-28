package com.vincejv.m360;

import java.util.concurrent.CompletableFuture;

import com.vincejv.m360.dto.ApiResponse;
import com.vincejv.m360.dto.BroadcastRequest;
import com.vincejv.m360.dto.BroadcastResponse;
import com.vincejv.m360.dto.SMSRequest;
import com.vincejv.m360.helper.M360ApiClientHelper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class M360ApiClient {

  private final M360ApiClientHelper m360ApiClientHelper;

  public M360ApiClient(String baseApiUrl, String appKey, String appSecret, String senderId) {
    m360ApiClientHelper = new M360ApiClientHelper(baseApiUrl, appKey, appSecret, senderId);
  }

  public CompletableFuture<ApiResponse<BroadcastResponse>> sendBroadcastMessage(BroadcastRequest broadcastRequest) {
    return m360ApiClientHelper.sendBroadcastMessage(broadcastRequest);
  }

  public CompletableFuture<ApiResponse<BroadcastResponse>> sendBroadcastMessage(SMSRequest smsRequest) {
    return m360ApiClientHelper.sendBroadcastMessage(smsRequest);
  }

  public CompletableFuture<ApiResponse<BroadcastResponse>> sendBroadcastMessage(String msisdn, String message) {
    var msgRequest = new SMSRequest();
    msgRequest.setMobileNumber(msisdn);
    msgRequest.setContent(message);
    return m360ApiClientHelper.sendBroadcastMessage(msgRequest);
  }

}
