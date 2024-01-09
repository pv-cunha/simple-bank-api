package com.transactiontransferworker.utils;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class AnnotationValue {
    private AnnotationValue() {
    }

    /**
    * Get annotation attributes.
     * @param <T> Attribute to search for.
     * @param classType Class annotated with the parameter you want to find.
     * @param annotationType Annotation that contains the attribute.
     * @param attributeName Searched attribute name.
     * @return Attribute found or null if not found.
     *
    */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> T getClassAnnotationValue(Class classType, Class annotationType, String attributeName) {
        T value = null;
        Annotation annotation = classType.getAnnotation(annotationType);

        if (Objects.nonNull(annotation)) {
            try {
                value = (T) annotation.annotationType().getMethod(attributeName).invoke(annotation);
            } catch (Exception e) {
                System.out.println("Error reflection the annotation !");
            }
        }

        return value;
    }
}
