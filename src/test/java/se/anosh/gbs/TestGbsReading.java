package se.anosh.gbs;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbs.domain.GbsTag;
import se.anosh.gbs.service.Gbs;
import se.anosh.gbs.service.GbsFile;

@Deprecated
public class TestGbsReading {

	    public TestGbsReading() {
			super();
		}

		private Gbs gbs;
	    private GbsTag tags;
	    
	    
	    @Before
	    public void setup() throws IOException {
	        
	        gbs = new GbsFile("gbs/sample.gbs");
	        tags = gbs.getTag();
	    }
		
	    @Test
	    public void TestOpenFile() {
	    	
	    	System.out.println(tags.toString());
	    	System.out.println(tags.equals(tags));
	    	System.out.println(tags.hashCode());
	    	
	    }
	    

}