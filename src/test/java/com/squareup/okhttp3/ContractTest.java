package com.squareup.okhttp3;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;

public class ContractTest {

    private OkHttpClient httpClient;
    private Gson gson;
    private String validUrl = "https://jsonplaceholder.typicode.com/posts/1";

    @Before
    public void setUp() {
        httpClient = new OkHttpClient();
        gson = new Gson();
    }

    @Test
    public void testValidJsonRequest() throws IOException {

        Response response = getResponse(validUrl);

        PostResponse postResponse = gson.fromJson(response.body().string(), PostResponse.class);

        Assert.assertEquals(1, postResponse.userId);
        Assert.assertEquals(1, postResponse.id);
        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", postResponse.title);
        Assert.assertEquals("quia et suscipit\n" +
                "suscipit recusandae consequuntur expedita et cum\n" +
                "reprehenderit molestiae ut ut quas totam\n" +
                "nostrum rerum est autem sunt rem eveniet architecto", postResponse.body);

    }

    @Test(expected = UnknownHostException.class)
    public void testInvalidHost() throws IOException {
        String invalidHost = "https://badurl.bad.bad";

        Response response = getResponse(invalidHost);
    }

    @Test
    public void test404Error() throws IOException {
        String error404 = "https://httpstat.us/404";

        Response response = getResponse(error404);

        Assert.assertEquals(404, response.code());
        Assert.assertEquals("Not Found", response.message());
    }

    @Test
    public void test500Error() throws IOException {
        String error500 = "https://httpstat.us/500";

        Response response = getResponse(error500);

        Assert.assertEquals(500, response.code());
        Assert.assertEquals("Internal Server Error", response.message());
    }

    private Response getResponse(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return httpClient.newCall(request).execute();
    }


    private class PostResponse {
        int userId;
        int id;
        String title;
        String body;
    }

}
