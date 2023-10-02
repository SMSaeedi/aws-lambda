package com.aws.lamda;

import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.aws.lamda.handler.SynchronousLambdaHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;

@SpringBootTest
class SynchronousLambdaAWSLambdaApplicationTests {
    private static final String URL = "/api/users";
    MockLambdaContext context;
    AwsProxyRequest request;
    AwsProxyResponse response;

    @BeforeEach
    void init() {
        context = new MockLambdaContext();
    }

    @Test
    void test_sync_lambda_with_correct_url_then_return_body() {
        SynchronousLambdaHandler handler = new SynchronousLambdaHandler();

        request = new AwsProxyRequestBuilder(URL, HttpMethod.GET.name()).build();
        response = handler.handleRequest(request, context);

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    void test_sync_lambda_with_not_correct_url_then_return_404() {
        SynchronousLambdaHandler handler = new SynchronousLambdaHandler();

        request = new AwsProxyRequestBuilder(URL + "/wrong-path", HttpMethod.GET.name()).build();
        response = handler.handleRequest(request, context);

        Assertions.assertEquals(404, response.getStatusCode());
    }
}
