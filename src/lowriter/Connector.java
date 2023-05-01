package lowriter;

import com.sun.star.uno.XComponentContext;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XModel;
import com.sun.star.lang.XMultiComponentFactory;

public class Connector {
	private XComponentContext xContext;
	
	public Connector (XComponentContext xcc) {
		xContext = xcc;
	}
	
	public XModel getDocModel() throws Exception {
		// Get an instance of the desktop object containing the current document
    	XMultiComponentFactory mcFactory = xContext.getServiceManager();
    	Object oDesktop = mcFactory.createInstanceWithContext("com.sun.star.frame.Desktop", xContext);
    	
    	// Get the component which has the UI focus (i.e. the current document)
    	XDesktop xDesktop = UnoRuntime.queryInterface(XDesktop.class, oDesktop);
    	return UnoRuntime.queryInterface(XModel.class, xDesktop.getCurrentComponent());
	}
}
