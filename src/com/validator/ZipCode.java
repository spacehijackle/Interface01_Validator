package com.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 郵便番号を表すアノテーション
 *
 * @author t.yoshida
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface ZipCode { }
