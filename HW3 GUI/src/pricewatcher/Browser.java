/*Ricardo Godoy and Stephanie Callejas.*/
package pricewatcher;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browser {
	

	public static void getURL() throws URISyntaxException, IOException {

        if (Desktop.isDesktopSupported()) {
        	URI uri = new URI("https://www.amazon.com/Sony-SRS-XB41-Portable-Bluetooth-SRSXB41/dp/B079V81NSG/ref=sr_1_acs_osp_osp18-1d0bb696_cov_4_2?s=electronics&ie=UTF8&qid=1549252925&sr=1-4-acs&keywords=bluetooth+speaker&tag=thewire06oa-20&ascsubtag=1d0bb696-435c-4008-a72b-1f50c7c75bc2&linkCode=oas&cv_ct_id=amzn1.osp.1d0bb696-435c-4008-a72b-1f50c7c75bc2&cv_ct_pg=search&cv_ct_wn=osp-search&creativeASIN=B079V81NSG");
        	Desktop.getDesktop().browse(uri);
        	// Windows

        } else {
            // Ubuntu
            Runtime runtime = Runtime.getRuntime();
            String url = ("https://www.amazon.com/Sony-SRS-XB41-Portable-Bluetooth-SRSXB41/dp/B079V81NSG/ref=sr_1_acs_osp_osp18-1d0bb696_cov_4_2?s=electronics&ie=UTF8&qid=1549252925&sr=1-4-acs&keywords=bluetooth+speaker&tag=thewire06oa-20&ascsubtag=1d0bb696-435c-4008-a72b-1f50c7c75bc2&linkCode=oas&cv_ct_id=amzn1.osp.1d0bb696-435c-4008-a72b-1f50c7c75bc2&cv_ct_pg=search&cv_ct_wn=osp-search&creativeASIN=B079V81NSG");;
			runtime.exec("/usr/bin/firefox -new-window " + url );
        }
    }
		
}




