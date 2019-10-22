package com.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 必須項目を表すアノテーション
 *
 * @author t.yoshida
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Required
{
	/**
	 * 項目名を返す。
	 *
	 * @return 項目名
	 */
	String value();
}
