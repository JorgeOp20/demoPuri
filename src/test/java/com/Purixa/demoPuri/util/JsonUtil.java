package com.Purixa.demoPuri.util;

import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonUtil {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().findAndRegisterModules().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
