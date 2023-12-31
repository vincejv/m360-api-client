package com.vincejv.m360.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {

  private boolean success;

  private int code;

  private List<ApiError> errors;

  private T result;

  private int totalPages;

  private int totalRecords;

  private int currentPage;

  private int recordsPerPage;

  private int nextPage;

  private int previousPage;

  public ApiResponse(boolean success, Integer code, List<ApiError> errors) {
    this.success = success;
    this.code = code;
    this.errors = errors;
  }

  public List<ApiError> getErrors() {
    if (null == errors) {
      errors = new ArrayList<>();
    }
    return errors;
  }

  public void setErrors(List<String> errorMsgs, String code) {
    if (null == errors) {
      errors = new ArrayList<>();
    }
    for (var errorMsg : errorMsgs) {
      errors.add(new ApiError(code, errorMsg));
    }
  }

  /**
   * Get page information
   *
   * @return the page information
   */
  public PageInfo getPageInfo() {
    return new PageInfo(totalPages, totalRecords, currentPage, recordsPerPage, nextPage, previousPage);
  }

}