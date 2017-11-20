package ca.crystalshard.chasm.common.domain;

public class RouteDescription {
    private String name;
    private String path;
    private HttpMethod method;
    private String exampleResponse;
    private String examplePost;

    public RouteDescription(String name, String path, HttpMethod method, String exampleResponse) {
        this(name, path, method, exampleResponse, "");
    }

    private RouteDescription(String name, String path, HttpMethod method, String exampleResponse, String examplePost) {
        this.name = name;
        this.path = path;
        this.method = method;
        this.exampleResponse = exampleResponse;
        this.examplePost = examplePost;
    }

    public String getName() {
        return name;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getExampleResponse() {
        return exampleResponse;
    }

    public String getExamplePost() {
        return examplePost;
    }
}

