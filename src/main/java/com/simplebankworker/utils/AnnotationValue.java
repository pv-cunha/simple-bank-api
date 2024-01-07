package com.simplebankworker.utils;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class AnnotationValue {
    private AnnotationValue() {
    }

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
