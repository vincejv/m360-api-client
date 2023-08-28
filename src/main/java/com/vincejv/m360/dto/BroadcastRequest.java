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

  /**
   * 0 - SMSC Default Alphabet
   * 1 - ASCII
   * 3 - Latin 1 (ISO-8859-1)
   * 8 - UCS2 (ISO/IEC-10646)
   */
  @JsonProperty("dcs")
  private Integer dataCodingScheme;

  public BroadcastRequest() {
    super();
  }

}
