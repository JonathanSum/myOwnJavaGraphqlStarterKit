package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;


public class Mutation implements GraphQLRootResolver {

  private final LinkRepository linkRepository;
  private final UserRepository userRepository;
  public Mutation(LinkRepository linkRepository, UserRepository userRepository) {
    this.linkRepository = linkRepository;
    this.userRepository = userRepository;
  }

 //The way to inject the context is via DataFetchingEnvironment
 public Link createLink(String url, String description, DataFetchingEnvironment env) {
    AuthContext context2 = env.getContext();
    System.out.println("I am here! env.getContext():  "+env.getContext());
    System.out.println("I am here! context2: "+context2.getUser().getName());
         AuthContext context = env.getContext();
    if ( context2.getUser().getId()== null) {
           return null;
    }
      Link newLink = new Link(url, description, context.getUser().getId());

     linkRepository.saveLink(newLink);
     return newLink;
//     return null;
 }
  public User createUser(String name, AuthData auth){
    User newUser = new User(name, auth.getEmail(), auth.getPassword());
    return userRepository.saveUser(newUser);
  }
  public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
    User user = userRepository.findByEmail(auth.getEmail());
    if (user.getPassword().equals(auth.getPassword())) {
        return new SigninPayload(user.getId(), user);
    }
    throw new GraphQLException("Invalid credentials or your password is wrong?");
}
}