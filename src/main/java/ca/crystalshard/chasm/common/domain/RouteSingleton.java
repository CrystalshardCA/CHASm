package ca.crystalshard.chasm.common.domain;

import java.util.ArrayList;
import java.util.List;

public class RouteSingleton {
    private static RouteSingleton instance;
    private List<RouteDescription> routes;

    private RouteSingleton() {
        routes = new ArrayList<>();
    }

    public static RouteSingleton getInstance() {
        if (instance == null) {
            instance = new RouteSingleton();
        }
        return instance;
    }

    public void addRoute(RouteDescription route) {
        routes.add(route);
    }

    public List<RouteDescription> getRoutes() {
        return routes;
    }

}
