package CIDEPack.XMLPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLParser
{
	private String m_xmlFileName;
	private String m_xsdFileName;
	private boolean m_xsdFileGiven;
	
	private DocumentBuilderFactory m_factory;
	private SchemaFactory m_schemaFactory;
	private Schema m_schema;
	private DocumentBuilder m_builder;
	private ErrorHandler m_errorHandler;
	private File m_xmlFile;
	
	public XMLParser(String fileXMLName) throws Exception
	{
		this.setXMLFileName(fileXMLName);
	}
	
	public XMLParser(String fileXMLName, String fileXSDName) throws Exception
	{
		this.setXMLAndXSDFilesName(fileXMLName, fileXSDName);
	}
	
	public String getXMLFileName()
	{
		return m_xmlFileName;
	}
	
	public String getXSDFileName()
	{
		return ((m_xsdFileGiven) ? m_xsdFileName : "");
	}
	
	public void setXMLFileName(String fileXMLName) throws Exception
	{
		m_xmlFileName = fileXMLName;
		m_xsdFileGiven = false;
		
		this.prepareToParsing();
	}
	
	public void setXSDFileName(String fileXSDName) throws Exception
	{
		m_xsdFileName = fileXSDName;
		m_xsdFileGiven = true;
		
		this.prepareToParsing();
	}
	
	public void setXMLAndXSDFilesName(String fileXMLName, String fileXSDName) throws Exception
	{
		m_xmlFileName = fileXMLName;
		m_xsdFileName = fileXSDName;
		m_xsdFileGiven = true;
		
		this.prepareToParsing();
	}
	
	public boolean isXSDFileGiven()
	{
		return m_xsdFileGiven;
	}
	
	public void removeXSDFileName()
	{
		m_xsdFileName = "";
		m_xsdFileGiven = false;
	}
	
	/*public Pair<Document, File> getFileXML(String fileName) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			File XMLFile = new File(fileName);
			
			Document xml = builder.parse(fileXML);
			
			return new Pair<Document, File>(xml, XMLFile);
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		catch(IOException errIO)
		{
			errIO.printStackTrace();
		}

		throw new Exception("A parsing error appeared.");
	}*/
	
	static public void truc()
	{
		// Nous récupérons une instance de factory qui se chargera de nous fournir
		// un parseur
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			// Création de notre parseur via la factory
			DocumentBuilder builder = factory.newDocumentBuilder();
			File fileXML = new File("test.xml");
			
			// parsing de notre fichier via un objet File et récupération d'un
			// objet Document
			// Ce dernier représente la hiérarchie d'objet créée pendant le parsing
			Document xml = builder.parse(fileXML);
			
			// Via notre objet Document, nous pouvons récupérer un objet Element
			// Ce dernier représente un élément XML mais, avec la méthode ci-dessous,
			// cet élément sera la racine du document
			Element root = xml.getDocumentElement();
			System.out.println(root.getNodeName());
			
			// Parsing d'un XML via une URL
			String uri = "http://www.w3schools.com/xml/note.xml";
			xml = builder.parse(uri);
			root = xml.getDocumentElement();
			System.out.println(root.getNodeName());
			
			// Parsing d'un XML via un flux
			InputStream is = new FileInputStream(fileXML);
			xml = builder.parse(is);
			root = xml.getDocumentElement();
			System.out.println(root.getNodeName());
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		catch(IOException errIO)
		{
			errIO.printStackTrace();
		}
	}
	
	static public void machin()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			ErrorHandler errHandler = new XMLErrorHandler();
			builder.setErrorHandler(errHandler);
			File fileXML = new File("test.xml");
			
			try
			{
				Document xml = builder.parse(fileXML);
				Element root = xml.getDocumentElement();
				System.out.println(root.getNodeName());
			}
			catch(SAXParseException errParseExcept)
			{
				
			}
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		catch(IOException errIO)
		{
			errIO.printStackTrace();
		}
	}
	
	static public void chouette()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			Schema schema = sfactory.newSchema(new File("test.xsd"));
			
			factory.setSchema(schema);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			ErrorHandler errHandler = new XMLErrorHandler();
			
			builder.setErrorHandler(errHandler);
			File fileXML = new File("test.xml");
			
			try
			{
				Document xml = builder.parse(fileXML);
				Element root = xml.getDocumentElement();
				System.out.println(root.getNodeName());
			}
			catch(SAXParseException errParseExcept)
			{
				
			}
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		catch(IOException errIO)
		{
			errIO.printStackTrace();
		}
	}
	
	static public void lectureXML()
	{
		
	}
	
	static public boolean yourFileIsWithDTD(String fileName) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			ErrorHandler errHandler = new XMLErrorHandler();
			builder.setErrorHandler(errHandler);
			File fileXML = new File(fileName);
			
			try
			{
				Document xml = builder.parse(fileXML);
				Element root = xml.getDocumentElement();
			}
			catch(SAXParseException errParseExcept)
			{
				return false;
			}
			
			return true;
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		catch(IOException errIO)
		{
			errIO.printStackTrace();
		}
		
		throw new Exception("A parsing error appeared.");
	}
	
	static public boolean yourFileIsWithXSD(String fileXMLName, String fileXSDName) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sfactory.newSchema(new File(fileXSDName));
			factory.setSchema(schema);
			DocumentBuilder builder = factory.newDocumentBuilder();
			ErrorHandler errHandler = new XMLErrorHandler();
			builder.setErrorHandler(errHandler);
			File fileXML = new File(fileXMLName);
			
			try
			{
				Document xml = builder.parse(fileXML);
				Element root = xml.getDocumentElement();
			}
			catch(SAXParseException errParseExcept)
			{
				return false;
			}
			
			return true;
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		catch(IOException errIO)
		{
			errIO.printStackTrace();
		}
		
		throw new Exception("A parsing error appeared.");
	}
	
	static public boolean yourFileIsValid(String fileXMLName, String fileXSDName) throws Exception
	{
		return ((yourFileIsWithDTD(fileXMLName)) || (yourFileIsWithXSD(fileXMLName, fileXSDName)));
	}
	
	
	
	
	private void prepareToParsing() throws Exception
	{
		m_factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			if(m_xsdFileGiven)
			{
				m_schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				m_schema = m_schemaFactory.newSchema(new File(m_xsdFileName));
				m_factory.setSchema(m_schema);
			}
			
			m_builder = m_factory.newDocumentBuilder();
			m_errorHandler = new XMLErrorHandler();
			m_builder.setErrorHandler(m_errorHandler);
			m_xmlFile = new File(m_xmlFileName);
		}
		catch(ParserConfigurationException errParseConfig)
		{
			errParseConfig.printStackTrace();
		}
		catch(SAXException errSAX)
		{
			errSAX.printStackTrace();
		}
		
		throw new Exception("An error during parsing configuration appeared.");
	}
}