package com.validator;

/**
 * 入力データチェック結果
 *
 * @author t.yoshida
 */
public class CheckResult
{
	// 項目名
	private String item;

	// 入力値
	private String value;

	// チェック結果フラグ
	private boolean isValid;

	/**
	 * {@link CheckResult} を生成する。
	 *
	 * @param item 項目名
	 * @param value 値
	 * @param isValid チェック結果フラグ（チェック結果が正しかった場合、true）
	 */
	CheckResult(String item, String value, boolean isValid)
	{
		this.item = item;
		this.value = value;
		this.isValid = isValid;
	}

	/**
	 * 項目名を返す。
	 *
	 * @return 項目名
	 */
	public String getItem()
	{
		return item;
	}

	/**
	 * 入力値を返す。
	 *
	 * @return 入力値
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * チェック結果を返す。
	 *
	 * @return チェック結果が正しい場合、true
	 */
	public boolean isValid() {
		return isValid;
	}

	@Override
	public String toString()
	{
		return "CheckResult [item=" + item + ", value=" + value + ", isValid=" + isValid + "]";
	}
}
