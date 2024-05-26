package org.fast_food.product;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

public class ProductKeyDeserializer extends KeyDeserializer {
    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        // Get all enums implementing the Product interface
        Reflections reflections = new Reflections("org.fast_food.product");
        Set<Class<? extends Product>> classes = reflections.getSubTypesOf(Product.class);

        // Iterate through each enum class
        for (Class<?> enumClass : classes) {
            try {
                // Use valueOf method to deserialize the key string into enum instance
                Method valueOfMethod = enumClass.getMethod("valueOf", String.class);
                return valueOfMethod.invoke(null, key.toUpperCase());
            } catch (Exception e) {
                // If deserialization fails, continue to the next enum class
                continue;
            }
        }

        // If key doesn't match any enum, throw an exception
        throw new IllegalArgumentException("Unknown product: " + key);
    }
}
