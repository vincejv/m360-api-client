package com.vincejv.m360.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BroadcastRequest extends SMSRequest {

  @JsonProperty("app_key")
  private String appKey;

  @JsonProperty("app_secret")
  private String appSecret;

  @JsonProperty("shortcode_mask")
  private String senderId;

  public BroadcastRequest() {
    super();
  }

  public BroadcastRequest(String mobileNumber, String content, Boolean isInternational, DCSCoding dataCodingScheme, String appKey, String appSecret, String senderId) {
    super(mobileNumber, content, isInternational, dataCodingScheme);
    this.appKey = appKey;
    this.appSecret = appSecret;
    this.senderId = senderId;
  }

  public BroadcastRequest(String mobileNumber, String content, String appKey, String appSecret, String senderId) {
    super(mobileNumber, content);
    this.appKey = appKey;
    this.appSecret = appSecret;
    this.senderId = senderId;
  }
}
