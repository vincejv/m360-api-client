# M360 API Java Client

<img src="banner.png" alt="FPI Framework" width="500"/>

[![Maven Central version](https://img.shields.io/maven-central/v/com.vincejv/dvs-apiclient?logo=apache-maven)](https://search.maven.org/artifact/com.vincejv/dtone-dvs-api-java-client-core)
[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/vincejv/dtone-dvs-api-java-client/Maven%20Central%20deployment?label=CI/CD&logo=github)](https://github.com/vincejv/dtone-dvs-api-java-client/actions?query=workflow%3A%22Maven+Central+deployment%22)
[![License](https://img.shields.io/github/license/vincejv/dtone-dvs-api-java-client?logo=apache)](https://github.com/vincejv/dtone-dvs-api-java-client/blob/main/LICENSE)
[![GitHub commit activity](https://img.shields.io/github/commit-activity/m/vincejv/dtone-dvs-api-java-client?label=commits&logo=git)](https://github.com/vincejv/dtone-dvs-api-java-client/pulse)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=alert_status)](https://sonarcloud.io/dashboard?id=vincejv_dtone-dvs-api-java-client)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=vincejv_dtone-dvs-api-java-client)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=vincejv_dtone-dvs-api-java-client)
[![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=bugs)](https://sonarcloud.io/component_measures/metric/reliability_rating/list?id=vincejv_dtone-dvs-api-java-client)
[![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=vulnerabilities)](https://sonarcloud.io/component_measures/metric/security_rating/list?id=vincejv_dtone-dvs-api-java-client)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=security_rating)](https://sonarcloud.io/dashboard?id=vincejv_dtone-dvs-api-java-client)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=vincejv_dtone-dvs-api-java-client&metric=ncloc)](https://sonarcloud.io/dashboard?id=vincejv_dtone-dvs-api-java-client)

Language: Java

An Open Source Client Library for Java applications to integrate and interact with
the M360 Messaging API of [m360 - Globe Business](https://www.globe.com.ph/business/sme/solutions/sms-api.html)

This library takes care of handling the API requests/responses to allow developers to
focus on the business logic offered by the integration with M360's Messaging API. The goal of this
client is to ensure that the integration with M360 is seamless and hassle-free. Drop us a line in
the issue tracker if you feel that it can be improved!

## Features
- Ready-to-use interfaces to consume M360's [Messaging API](https://www.globe.com.ph/business/sme/solutions/sms-api.html)
- Common response object
- ~~Unit and functional testing with mocked responses from the API.~~ TODO
- Asynchronous calls

## Domain Objects
This library deals with the following list of domain objects from the DVS API:
 - BroadcastResponse
 - BroadcastRequest
 - SMSRequest

## Installation & Usage

- Requires Java 17 or later

- The library is available to be installed as a Maven Dependency or Standalone Java Archive.

    1. Maven Dependency

       - Add the following dependency in your `pom.xml`

           ```xml
           <dependency>
               <groupId>com.vincejv</groupId>
               <artifactId>m360-api-client</artifactId>
               <version>1.0.0</version> <!-- replace with latest version -->
           </dependency>
           ```
    2. Standalone JAR
        - Feel free to download the latest JAR with the dependencies directly from maven central [here](https://repo.maven.apache.org/maven2/com/vincejv/m360-api-client/)
        and add the jar to the classpath of your project.
  
- Create an instance from `M360ApiClient` with your basic auth keys and sender id or shortcode mask
    ```java
    import com.vincejv.m360;
    
    var m360Client = new M360ApiClient(String baseApiUrl, 
      String appKey, String appSecret, String senderId)
    ```
- Start calling the M360 API!

## Basic Troubleshooting and frequently asked questions:

- Should an application create more than one `M360ApiClient`?
    
    There should be no need to do that in a single application.
    
- Is it mandatory to set all values in a filter instance?
    
    No

## License
- [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)
