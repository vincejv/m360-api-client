package com.vincejv.m360.dto;

import java.io.IOException;
import java.io.Serial;
import java.util.Collections;
import java.util.List;

import com.vincejv.m360.util.ApiResponseBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BroadcastResponseDeserializer extends StdDeserializer<BroadcastResponse> {

  @Serial
  private static final long serialVersionUID = -3988028000625898184L;

  private static final ObjectMapper mapper = ApiResponseBuilder.getObjectMapper();

  public static final String JSON_KEY_MSG = "message";

  public BroadcastResponseDeserializer() {
    this(null);
  }

  public BroadcastResponseDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public BroadcastResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    var broadcastResponse = new BroadcastResponse();
    JsonNode node = jp.getCodec().readTree(jp);
    if (node.get(JSON_KEY_MSG) != null) {
      boolean isMessageArray = node.get(JSON_KEY_MSG).isArray();

      if (isMessageArray) {
        var messages = mapper.convertValue(node.get(JSON_KEY_MSG), new TypeReference<List<String>>() {
        });
        broadcastResponse.setMessage(messages);
      } else {
        broadcastResponse.setMessage(Collections.singletonList(node.get(JSON_KEY_MSG).asText()));
      }
    }

    setCommonProperties(node, broadcastResponse);

    return broadcastResponse;
  }

  private void setCommonProperties(JsonNode node, BroadcastResponse broadcastResponse) {
    if (node.get("code") != null)
      broadcastResponse.setCode(node.get("code").asInt());

    if (node.get("name") != null)
      broadcastResponse.setName(node.get("name").asText());

    if (node.get("timestamp") != null)
      broadcastResponse.setTimestamp(node.get("timestamp").asText());

    if (node.get("msgcount") != null)
      broadcastResponse.setMsgCount(node.get("msgcount").asInt());

    if (node.get("telco_id") != null)
      broadcastResponse.setTelcoId(node.get("telco_id").asInt());

    if (node.get("messageId") != null)
      broadcastResponse.setMessageId(node.get("messageId").asText());

    if (node.get("transid") != null)
      broadcastResponse.setTransId(node.get("transid").asText());
  }

}
