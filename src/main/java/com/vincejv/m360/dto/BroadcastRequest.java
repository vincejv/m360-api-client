package com.vincejv.m360.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
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

}
