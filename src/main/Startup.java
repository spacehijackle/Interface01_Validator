package main;

import java.util.List;

import com.validator.CheckResult;
import com.validator.Validator;

import data.PersonalInfo;

/**
 * 入力チェックのサンプル
 *
 * @author t.yoshida
 */
public class Startup
{
	public static void main(String[] args)
	{
		/*
		 * 個人情報の設定
		 */
		PersonalInfo info = new PersonalInfo();
		info.setLastName("");
		info.setFirstName("カンチ");
		info.setPhoneNum("03-1234-5678");
		info.setMailAddr("UMA@@hoge.co.jp");
		info.setZipCode("123-45@7");
		//info.setGender("男");
		info.setGender("♀");

		// 電話番号、メールアドレス、郵便番号のチェック
		System.out.println("Tel: " + Validator.isValidPhoneNum(info) + " " + info.getPhoneNum());
		System.out.println("Add: " + Validator.isValidMailAddr(info) + " " + info.getMailAddr());
		System.out.println("Cod: " + Validator.isValidZipCode(info)  + " " + info.getZipCode());

		// 必須項目のチェック
		List<CheckResult> results = Validator.checkRequired(info);
		for(CheckResult result : results)
		{
			System.out.println("Req: " + result);
		}

		// 性別のチェック
		System.out.println("Sex: " + Validator.isValidGender(info)   + " " + info.getGender());
	}
}
