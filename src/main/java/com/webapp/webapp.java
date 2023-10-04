package com.webapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("docker-app")
public class webapp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
