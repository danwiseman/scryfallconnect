package com.github.danwiseman.kafka.connect.scryfall.Validators;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;


public class RateLimitValidator implements ConfigDef.Validator {

    @Override
    public void ensureValid(String name, Object value) {
        Integer rateLimit = (Integer) value;
        if (rateLimit <= 75){
            throw new ConfigException(name, value, "Rate limit must be a positive integer that's greater than 75");
        }
        
    }
    
}
