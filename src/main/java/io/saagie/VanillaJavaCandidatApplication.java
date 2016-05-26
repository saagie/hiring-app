package io.saagie;

import com.google.gson.Gson;
import io.saagie.domain.HumanEntity;

import java.util.Map;

import static io.saagie.configuration.InsertHumanInMongo.initMap;
import static spark.Spark.*;

/**
 * Created by pleresteux on 26/05/16.
 */
public class VanillaJavaCandidatApplication {

    static Map<String, HumanEntity> humans = initMap();

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        port(8080);
        after((request, response) -> {
            response.header("Content-Type", "application/json");
        });

        get("/api/human", (request, response) -> humans.values(), gson::toJson);
        get("/api/human/:id", (request, response) -> humans.get(request.params(":id")), gson::toJson);
        delete("/api/human/:id", (request, response) ->
        {
            HumanEntity human = humans.get(request.params(":id"));
            humans.remove(human);
            return human;
        }, gson::toJson);
        post("/api/human", (request, response) -> {
                 return request.body();
             }, gson::toJson
        );
        put("/api/human/:id", (request, response) -> {
                return request.body();
            }, gson::toJson
        );
    }


}
