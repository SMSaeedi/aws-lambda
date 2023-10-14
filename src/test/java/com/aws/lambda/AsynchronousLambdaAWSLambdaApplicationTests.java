//package com.aws.lamda;
//
//import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
//import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
//import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
//import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
//import com.aws.lamda.handler.AsynchronousLambdaHandler;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpMethod;
//
//@SpringBootTest
//class AsynchronousLambdaAWSLambdaApplicationTests {
//    private static final String URL = "/api/users";
//    MockLambdaContext context;
//    AsynchronousLambdaHandler handler;
//    AwsProxyRequest request;
//    AwsProxyResponse response;
//
//    @SneakyThrows
//    @BeforeEach
//    void init() {
//        context = new MockLambdaContext();
//        handler = new AsynchronousLambdaHandler();
//    }
//
//    @Test
//    void test_async_lambda_with_correct_url_then_return_body() {
//        request = new AwsProxyRequestBuilder(URL, HttpMethod.GET.name()).build();
//        response = handler.handleRequest(request, context);
//
//        Assertions.assertNotNull(response.getBody());
//        Assertions.assertEquals(200, response.getStatusCode());
//    }
//
//    @Test
//    void test_async_lambda_with_not_correct_url_then_return_404() {
//        request = new AwsProxyRequestBuilder(URL + "/wrong-path", HttpMethod.GET.name()).build();
//        response = handler.handleRequest(request, context);
//
//        Assertions.assertEquals(404, response.getStatusCode());
//    }
//}
