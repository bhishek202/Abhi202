package com.API.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String msg)
    {
        super(msg);

    }
}
