package com.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 入力データチェック
 *
 * @author t.yoshida
 */
public class Validator
{
	/**
	 * 指定されたクラスの電話番号が正しいかチェックする。
	 *
	 * @param target ゲッターにアノテーション {@link Tel} があるオブジェクト
	 * @return 結果が正しい場合、true
	 */
	public static boolean isValidPhoneNum(Object target)
	{
		// 電話番号フォーマットチェック用正規表現
		String format = "^[0-9]{2,4}-[0-9]{2,4}-[0-9]{3,4}$";
		return isValid(target, Tel.class, format);
	}

	/**
	 * 指定されたクラスのメールアドレスが正しいかチェックする。
	 *
	 * @param target ゲッターにアノテーション {@link MailAddr} があるオブジェクト
	 * @return 結果が正しい場合、true
	 */
	public static boolean isValidMailAddr(Object target)
	{
		// メールアドレスフォーマットチェック用正規表現
		String format = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		return (isValid(target, MailAddr.class, format));
	}

	/**
	 * 指定されたクラスの郵便番号が正しいかチェックする。
	 *
	 * @param target ゲッターにアノテーション {@link ZipCode} があるオブジェクト
	 * @return 結果が正しい場合、true
	 */
	public static boolean isValidZipCode(Object target)
	{
		// 郵便番号フォーマットチェック用正規表現
		String format = "^\\d{3}\\-\\d{4}$";
		return (isValid(target, ZipCode.class, format));
	}

	/**
	 * 指定されたクラスの値が正しいかチェックする。
	 *
	 * @param target ゲッターに特定のアノテーションがあるオブジェクト
	 * @param annotationClass アノテーションクラス
	 * @param format 正しいフォーマット（正規表現）
	 * @return 結果が正しい場合、true
	 */
	private static boolean isValid(Object target, Class<? extends Annotation> annotationClass, String format)
	{
		/*
		 * メソッドを列挙し、指定アノテーションに合致するメソッドの抜き出し
		 */
		Method[] methods = target.getClass().getMethods();
		for(Method m : methods)
		{
			if(!m.isAnnotationPresent(annotationClass)) continue;

			// 抜き出したメソッド（引数無しで返り値があるメソッド）を実行し、入力値を取得
			String value;
			try
			{
				value = (String)m.invoke(target);
			}
			catch(Exception ex)
			{
				throw new RuntimeException(ex);
			}

			// 入力値が無い場合、次のチェックへ
			if(value == null || value.isEmpty())
			{
				continue;
			}

			// 入力値とフォーマットの比較結果が不正な場合、エラー
			boolean isValid = (value.matches(format));
			if(!isValid)
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * 指定されたクラスの必須項目メソッドをチェックする。
	 *
	 * @param target ゲッターにアノテーション {@link Required} があるオブジェクト
	 * @return 入力データチェック結果のリスト
	 */
	public static List<CheckResult> checkRequired(Object target)
	{
		List<CheckResult> results = new ArrayList<>();

		/*
		 * メソッドを列挙し、必須アノテーションに合致するメソッドの抜き出し
		 */
		Method[] methods = target.getClass().getMethods();
		for(Method m : methods)
		{
			if(!m.isAnnotationPresent(Required.class)) continue;

			// 抜き出したメソッド（引数無しで返り値があるメソッド）を実行し、入力値を取得
			String value;
			try
			{
				value = (String)m.invoke(target);
			}
			catch(Exception ex)
			{
				throw new RuntimeException(ex);
			}

			// 必須項目の名称の取得
			Required required = m.getAnnotation(Required.class);
			String item = required.value();

			// 結果の判定
			boolean isValid;
			if(value == null || value.isEmpty())
			{
				// 入力値が無い場合、エラー
				isValid = false;
			}
			else
			{
				// 入力値がある場合、ＯＫ
				isValid = true;
			}

			// 結果をリストに追加
			results.add(new CheckResult(item, value, isValid));
		}

		return results;
	}

	/**
	 * 指定されたクラスの性別が正しいかチェックする。
	 *
	 * @param target ゲッターにアノテーション {@link Gender} があるオブジェクト
	 * @return 結果が正しい場合、true
	 */
	public static boolean isValidGender(Object target)
	{
		/*
		 * メソッドを列挙し、性別アノテーションに合致するメソッドの抜き出し
		 */
		Method[] methods = target.getClass().getMethods();
		for(Method m : methods)
		{
			if(!m.isAnnotationPresent(Gender.class)) continue;

			// 正しい性別表記の取得
			Gender annotation = m.getAnnotation(Gender.class);
			String validMale = annotation.male();
			String validFemale = annotation.female();

			// 抜き出したメソッド（引数無しで返り値があるメソッド）を実行し、入力値を取得
			String value;
			try
			{
				value = (String)m.invoke(target);
			}
			catch(Exception ex)
			{
				throw new RuntimeException(ex);
			}

			// 入力値が無い場合、次のチェックへ
			if(value == null || value.isEmpty())
			{
				continue;
			}

			// 性別の表記が男女いづれの正しい表記に当てはまらない場合、エラー
			if(!value.equals(validMale) && !value.equals(validFemale))
			{
				return false;
			}
		}

		return true;
	}
}
