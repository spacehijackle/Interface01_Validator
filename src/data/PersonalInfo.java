package data;

import com.validator.Gender;
import com.validator.MailAddr;
import com.validator.Required;
import com.validator.Tel;
import com.validator.ZipCode;

/**
 * 個人情報クラス
 *
 * @author t.yoshida
 */
public class PersonalInfo
{
	// 電話番号
	private String phoneNum;

	// メールアドレス
	private String mailAddr;

	// 姓（氏名）
	private String lastName;

	// 名（氏名）
	private String firstName;

	// 郵便番号
	private String zipCode;

	// 性別
	private String gender;

	/**
	 * 電話番号を返す。
	 *
	 * @return 電話番号
	 */
	@Tel
	public String getPhoneNum()
	{
		return phoneNum;
	}

	/**
	 * メールアドレスを返す。
	 *
	 * @return メールアドレス
	 */
	@MailAddr
	public String getMailAddr()
	{
		return mailAddr;
	}

	/**
	 * 姓（氏名）を返す。
	 *
	 * @return 姓（氏名）
	 */
	@Required(value="姓（氏名）")
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * 名（氏名）を返す。
	 *
	 * @return 名（氏名）
	 */
	@Required("名（氏名）")
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * 郵便番号を返す。
	 *
	 * @return 郵便番号
	 */
	@ZipCode @Required("郵便番号")
	public String getZipCode()
	{
		return zipCode;
	}

	/**
	 * 性別を返す。
	 *
	 * @return 性別
	 */
	@Gender(male="♂", female="♀")
	public String getGender()
	{
		return gender;
	}

	/**
	 * 電話番号を設定する。
	 *
	 * @param phoneNum 電話番号
	 */
	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	/**
	 * メールアドレスを設定する。
	 *
	 * @param mailAddr メールアドレス
	 */
	public void setMailAddr(String mailAddr)
	{
		this.mailAddr = mailAddr;
	}

	/**
	 * 姓（氏名）を設定する。
	 *
	 * @param lastName 姓（氏名）
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * 名（氏名）を設定する。
	 *
	 * @param firstName 名（氏名）
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * 郵便番号を設定する。
	 *
	 * @param zipCode 郵便番号
	 */
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	/**
	 * 性別を設定する。
	 *
	 * @param gender 性別
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
}
