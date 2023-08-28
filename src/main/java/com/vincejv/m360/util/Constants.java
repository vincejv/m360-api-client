package com.vincejv.m360.util;

public class Constants {

	public static final String M360_API_SDK_VERSION = "M360-ASYNC-CLIENT-SDK/1.0 JAVA";

	private Constants() { }

	// Pagination Response Headers
	public static final String TOTAL_PAGES_HEADER = "X-Total-Pages";
	public static final String TOTAL_RECORDS_HEADER = "X-Total";
	public static final String RECORDS_PER_PAGE_HEADER = "X-Per-Page";
	public static final String CURRENT_PAGE_HEADER = "X-Page";
	public static final String NEXT_PAGE_HEADER = "X-Next-Page";
	public static final String PREVIOUS_PAGE_HEADER = "X-Prev-Page";

	// API Paths
  public static final String BROADCAST = "/v3/api/broadcast";

}
