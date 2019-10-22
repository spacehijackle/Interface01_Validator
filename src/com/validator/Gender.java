package com.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 性別を表すアノテーション
 *
 * @author t.yoshida
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Gender
{
	/**
	 * 男性を表す文字列を返す。
	 *
	 * @return 男性を表す文字列
	 */
	String male();

	/**
	 * 女性を表す文字列を返す。
	 *
	 * @return 女性を表す文字列
	 */
	String female();
}
