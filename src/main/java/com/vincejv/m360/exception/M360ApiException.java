package com.vincejv.m360.exception;


import java.io.Serial;

public class M360ApiException extends Exception {

  @Serial
  private static final long serialVersionUID = -1344669069042045795L;

  public M360ApiException(Throwable cause) {
    super(cause);
  }

}
