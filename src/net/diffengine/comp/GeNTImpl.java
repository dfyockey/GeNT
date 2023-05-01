package net.diffengine.comp;

import com.sun.star.uno.Exception;
import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;

import lowriter.*;
import com.sun.star.awt.MessageBoxButtons;
import com.sun.star.awt.MessageBoxType;
import com.sun.star.frame.XModel;

public final class GeNTImpl extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
              com.sun.star.task.XJobExecutor,
              net.diffengine.XGeNT
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = GeNTImpl.class.getName();
    private static final String[] m_serviceNames = {
        "net.diffengine.GeNT" };
    private final XModel DocModel;


    public GeNTImpl( XComponentContext context ) throws Exception
    {
        m_xContext = context;
        Connector oConnector = new Connector(m_xContext);
        DocModel = oConnector.getDocModel();
    };

    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(GeNTImpl.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }
    
    // com.sun.star.task.XJobExecutor:
    public void trigger(String action)
    {
    	loMessageBox msgbox = new loMessageBox();
    	
    	switch (action) {
    	case "actionOne":
            msgbox.show(DocModel, MessageBoxType.INFOBOX, 0, "GeNT msgbox", "Hello World!");
    		break;
    	default:
    		msgbox.show(DocModel, MessageBoxType.ERRORBOX, MessageBoxButtons.BUTTONS_OK, m_implementationName, "Unknown action: " + action);
    		break;
    	}
    }

}
