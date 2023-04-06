package com.capgemini.tuto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Class1 {

    public static boolean isValidURL(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }
        try {
            // JENSEC-1938 Restrict href protocol to only allow some https / http schemes
            final String scheme = new URI(url).getScheme();
            return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
        }
        catch (URISyntaxException ex) {
            return false;
        }
    }

    public static void checkNotEmpty(String... values) {
        for (String value : values) {
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<String> split(String value, String separator) {
        if (value != null && !value.isEmpty()) {
            return Arrays
                    .stream(value.split(separator))
                    .map(String::trim)
                    .filter(tag -> !tag.isEmpty())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
