package info.yalamanchili.google;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class GoogleServiceTest {
	/** reg id of the device registered with C2DM received as part of reg process*/
	private static final String DEVICE_REG_ID = "APA91bE2msaGs4PKafzm123wD3jhP0oVyeodpsYnqmDSVJPgsKIoA5kE8ZzS3KKClTCcKZjqAW79aA-nPAsi7eZs3cuDF5Er1pr8B0U5eWsMiU6TJgfGsvw";
	// ** email registered with C2DM service*/
	private static final String SENDER_EMAIL = "******";
	private static final String PASSWORD = "*********";
	private static final String SERVICE = "ac2dm";
	private static final String ACCOUNT_TYPE = "HOSTED_OR_GOOGLE";
	private static final String SOURCE_ID = "com.dante.catalog.android-1.0";

	/** run on demand */
	@Test
	@Ignore
	public void testGoogleLogin() {
		String res = GoogleService.login(SENDER_EMAIL, PASSWORD, ACCOUNT_TYPE,
				SERVICE, SOURCE_ID, null, null);
		System.out.println(res);
	}

	/** run on demand */
	@Test
	@Ignore
	public void testC2DMSend() {
		try {
			String authKey = GoogleService.login(SENDER_EMAIL, PASSWORD,
					ACCOUNT_TYPE, SERVICE, SOURCE_ID, null, null);
			GoogleService.sendC2DMMessage("test message", authKey.trim(),
					DEVICE_REG_ID, "q3");
		} catch (Exception e) {
			fail();
		}
	}
}
