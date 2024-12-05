package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.inject.Inject;
import org.jboss.resteasy.reactive.RestQuery;
import org.json.JSONObject;
import java.util.ArrayList;

@Path("/user") 
@Produces(MediaType.APPLICATION_JSON) 
public class GreetingResource {
    
    @Inject
    private User user;
    private static ArrayList<String> userList = new ArrayList<String>();

    @POST
    @Path("/create")
    public JSONObject create() {
        JSONObject JsonResponse = new JSONObject();
        String userID;
        user = new User();

        userID = user.getUserID();
        userList.add(userID);
        JsonResponse.put("userID", userID);

        return JsonResponse;
    }

    @GET
    @Path("/check")
    public JSONObject checkUser(@QueryParam("id") String id){
        JSONObject JsonResponse = new JSONObject();
        if(userList.contains(id)) {
            JsonResponse.put("result", "User exists");
        }
        else{
            JsonResponse.put("result", "User does not exist");
        }

        return JsonResponse;
    }

    @DELETE
    @Path("/delete/{id}")
    public JSONObject deleteUser(String id){
        JSONObject JsonResponse = new JSONObject();
        if(userList.contains(id)) {
            userList.remove(id);
            JsonResponse.put("result", "User deleted");
        }
        else{
            JsonResponse.put("result", "User does not exist");
        }
        return JsonResponse;
    }

    // @GET
    // public JSONObject hello(@QueryParam("param") String param){
    //     JSONObject JsonResponse = new JSONObject();
    //     if(param == null) {
    //         JsonResponse.put("result", "no value");
    //     }
    //     else{
    //         JsonResponse.put("result", param);
    //     }

    //     return JsonResponse;
    // }

}
