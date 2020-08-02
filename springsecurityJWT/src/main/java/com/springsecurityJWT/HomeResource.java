package com.springsecurityJWT;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.springsecurityJWT.model.AuthenticationRequest;
import com.springsecurityJWT.model.AuthenticationResponse;
import com.springsecurityJWT.service.MyUserDetailsService;
import com.springsecurityJWT.util.JwtUtil;








@RestController

public class HomeResource {

 @Autowired

 private AuthenticationManager authenticationManager;

 @Autowired

 private MyUserDetailsService myUserDetailsService;



 @Autowired

 private JwtUtil jWTUtil;



 @GetMapping("/")

 public String welcome(){



 return "<h1>Home Page<h1>";



 }



 @RequestMapping(value="/authenticate", method=RequestMethod.POST)

 public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

 try{

 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

 }

 catch(BadCredentialsException e){

  throw new Exception("Username,Password incorrect",e);

 }





 final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());



 final String jwt = jWTUtil.generateToken(userDetails);

 return ResponseEntity.ok(new AuthenticationResponse(jwt));



 }





}

