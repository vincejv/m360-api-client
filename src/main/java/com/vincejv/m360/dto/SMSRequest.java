/******************************************************************************
 * FPI Application - Abavilla                                                 *
 * Copyright (C) 2022  Vince Jerald Villamora                                 *
 *                                                                            *
 * This program is free software: you can redistribute it and/or modify       *
 * it under the terms of the GNU General Public License as published by       *
 * the Free Software Foundation, either version 3 of the License, or          *
 * (at your option) any later version.                                        *
 *                                                                            *
 * This program is distributed in the hope that it will be useful,            *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 * GNU General Public License for more details.                               *
 *                                                                            *
 * You should have received a copy of the GNU General Public License          *
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.     *
 ******************************************************************************/

package com.vincejv.m360.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vincejv.m360.util.SMSUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
public class SMSRequest extends ApiRequest {

  @JsonProperty("msisdn")
  private String mobileNumber;

  @JsonProperty("content")
  private String content;

  @JsonProperty("is_intl")
  private Boolean isInternational;

  /**
   * 0 - SMSC Default Alphabet
   * 1 - ASCII
   * 3 - Latin 1 (ISO-8859-1)
   * 8 - UCS2 (ISO/IEC-10646)
   */
  @JsonProperty("dcs")
  private DCSCoding dataCodingScheme;

  public SMSRequest() {
    isInternational = false;
    dataCodingScheme = DCSCoding.GSM0338;
  }

  public SMSRequest(String mobileNumber, String content) {
    this();
    this.mobileNumber = mobileNumber;
    this.content = content;
    this.dataCodingScheme = SMSUtil.isEncodeableInGsm0338(content) ? DCSCoding.GSM0338 : DCSCoding.UCS2;
  }
}
