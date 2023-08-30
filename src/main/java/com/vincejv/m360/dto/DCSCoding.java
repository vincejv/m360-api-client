package com.vincejv.m360.dto;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DCSCoding implements IBaseEnum {
  GSM0338(0, "GSM 03.38"),
  ASCII(1, "ASCII"),
  LATIN(3, "Latin 1 (ISO-8859-1)"),
  UCS2(8, "UCS2 (ISO/IEC-10646)"),
  UNKNOWN(-1, "");

  /**
   * Ordinal id to enum mapping
   */
  private static final Map<Integer, IBaseEnum> ENUM_MAP = new HashMap<>();

  static {
    for(IBaseEnum w : EnumSet.allOf(DCSCoding.class))
      ENUM_MAP.put(w.getId(), w);
  }

  /**
   * The enum ordinal id
   */
  private final int id;

  /**
   * The enum value
   */
  private final String value;

  /**
   * Creates an enum based from given string value
   *
   * @param value the string value
   * @return the created enum
   */
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public static DCSCoding fromValue(String value) {
    return (DCSCoding) IBaseEnum.fromValue(value, ENUM_MAP, UNKNOWN);
  }

  /**
   * Creates an enum based from given an ordinal id
   *
   * @param id the ordinal id
   * @return the created enum
   */
  public static DCSCoding fromId(int id) {
    return (DCSCoding) IBaseEnum.fromId(id, ENUM_MAP, UNKNOWN);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @JsonValue
  public String toString() {
    return value;
  }
}
