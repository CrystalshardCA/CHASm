package ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3;

import ca.crystalshard.chasm.BaseTest;
import ca.crystalshard.chasm.crawler.adapter.httpclient.HttpResponse;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class OkHttp3HttpClientTest extends BaseTest {

    private OkHttp3Wrapper okHttp3Wrapper;
    private OkHttp3ResponseWrapper okHttp3ResponseWrapper;
    private OkHttp3HttpClient okHttp3HttpClient;

    @Before
    public void setUp() {
        okHttp3ResponseWrapper = mock(OkHttp3ResponseWrapper.class);
        okHttp3Wrapper = mock(OkHttp3Wrapper.class);
        okHttp3HttpClient = new OkHttp3HttpClient(okHttp3Wrapper, new Gson());
    }

    @Test
    public void getRawContent_shouldReturnRawContent() throws IOException {
        URL url = anonUrl();
        String expected = anonString();
        doReturn(expected).when(okHttp3ResponseWrapper).getBody();
        doReturn(200).when(okHttp3ResponseWrapper).getCode();
        doReturn(okHttp3ResponseWrapper).when(okHttp3Wrapper).getResponse(url);

        HttpResponse<String> content = okHttp3HttpClient.getRawContent(url);

        assertEquals(expected, content.getBody());
    }

    @Test
    public void getContent_shouldReturnContent() throws IOException {
        URL url = anonUrl();
        TestObject test = new TestObject();
        test.test1 = anonInt();
        test.test2 = anonString();
        String body = new Gson().toJson(test);
        doReturn(body).when(okHttp3ResponseWrapper).getBody();
        doReturn(200).when(okHttp3ResponseWrapper).getCode();
        doReturn(okHttp3ResponseWrapper).when(okHttp3Wrapper).getResponse(url);

        HttpResponse<TestObject> response = okHttp3HttpClient.getContent(url, TestObject.class);

        assertEquals(test.test1, response.getBody().test1);
        assertEquals(test.test2, response.getBody().test2);
    }


    private class TestObject {
        int test1;
        String test2;
    }

}

