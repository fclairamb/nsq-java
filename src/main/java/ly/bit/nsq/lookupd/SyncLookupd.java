package ly.bit.nsq.lookupd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SyncLookupd extends AbstractLookupd {

	@Override
	public List<String> query(String topic) {
		URL url = null;
		try {
			url = new URL(this.addr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String resp = br.readLine();
			return parseResponseForProducers(resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
