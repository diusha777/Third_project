package TransIntoHtml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransIntoHtml {

	public static void main(String args[]){

		try {
        TransformerFactory tFactory=TransformerFactory.newInstance();

        Source xslDoc=new StreamSource("Tariff_sorted.xsl");
        Source xmlDoc=new StreamSource("Tariff.xml");

        String outputFileName="Tariff_sorted.html";

        OutputStream htmlFile=new FileOutputStream(outputFileName);
        Transformer trasform=tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(htmlFile));
        
        System.out.println ("Transformation your xsl to html file completed successfully!");
        System.out.println ("You can find your html file in the workspace directory");
    } 
    catch (FileNotFoundException e) 
    {
        e.printStackTrace();
    }
    catch (TransformerConfigurationException e) 
    {
        e.printStackTrace();
    }
    catch (TransformerFactoryConfigurationError e) 
    {
        e.printStackTrace();
    }
    catch (TransformerException e) 
    {
        e.printStackTrace();
    }
}
}
