package product.app;

import static org.mockito.Mockito.*;

public class MockHolder {
	
	private EmailServiceThirdParty es = new EmailServiceThirdParty();// mock(EmailServiceThirdParty.class);
	
	public MockHolder(SearchHomes sh) {
		sh.setService(this.es);
	}
	
	public EmailServiceThirdParty getService() {
		return (this.es);
	}
}
