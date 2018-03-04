package com.howtographql.hackernews;

/**
 * Created by JonathanSum on 2/19/2018.
 */
import com.coxautodev.graphql.tools.GraphQLResolver;

/**
 * Contains SigninPayload sub-queries
 */
public class SigninResolver implements GraphQLResolver<SigninPayload> {

    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}
