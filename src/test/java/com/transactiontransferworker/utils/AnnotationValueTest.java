package com.transactiontransferworker.utils;

import com.transactiontransferworker.exceptions.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class AnnotationValueTest {

    @Test
    public void shouldBeAbleToGetAnAnnotationValue() {
        Object annotationValue = AnnotationValue.getClassAnnotationValue(UserNotFoundException.class, ResponseStatus.class, "reason");

        assertNotNull(annotationValue);
    }

    @Test
    public void shouldNotBeAbleToGetAnAnnotationValueWhenTheValueDoesNotExist() {
        Object annotationValue = AnnotationValue.getClassAnnotationValue(UserNotFoundException.class, ResponseStatus.class, "notExist");

        assertNull(annotationValue);
    }

}