package CIDEPack.XMLPack;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLErrorHandler implements ErrorHandler
{
	public void warning(SAXParseException errParseExcept) throws SAXException
	{
		System.out.println("WARNING : " + errParseExcept.getMessage());
	}
	
	public void error(SAXParseException errParseExcept) throws SAXException
	{
		System.out.println("ERROR : " + errParseExcept.getMessage());
		throw errParseExcept;
	}
	
	public void fatalError(SAXParseException errParseExcept) throws SAXException
	{
		System.out.println("FATAL ERROR : " + errParseExcept.getMessage());
		throw errParseExcept;
	}
}