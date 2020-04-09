package se.anosh.gbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbs.domain.GbsTag;
import se.anosh.gbs.domain.ReadOnlyGbsTag;
import se.anosh.gbs.domain.ReadOnlyLowLevelGbsTag;
import se.anosh.gbs.domain.SimpleGbsTag;
import se.anosh.gbs.service.Gbs;
import se.anosh.gbs.service.GbsFile;

public class TestModelWithData {
	
    public TestModelWithData() {
		super();
	}

	private Gbs gbsFile;
    private SimpleGbsTag tag;
    private ReadOnlyLowLevelGbsTag readOnlyTag;
    private static String FIRST_SAMPLE_FILE = "gbs/sample.gbs"; // Shantae
    private static String SECOND_SAMPLE_FILE = "gbs/sample2.gbs"; // DK Land2
    
    @Before
    public void setup() throws IOException {
        
        gbsFile = new GbsFile(FIRST_SAMPLE_FILE);
        tag = gbsFile.getTag();
        readOnlyTag = gbsFile.getReadOnlyTag();
    }
	
    @Test
    public void testIdenticalHashCodes() throws IOException {
        Gbs cloneFile = new GbsFile(FIRST_SAMPLE_FILE);
        SimpleGbsTag clone = cloneFile.getTag();
        
        System.out.println("tag = " + tag);
        System.out.println("clone = " + clone);
        
        assertNotSame(clone,tag); // don't cheat
        assertEquals(tag.hashCode(),clone.hashCode());
    }
    
    @Test
    public void testNotIdenticalHashCodes() throws IOException {
        
        Gbs different = new GbsFile(SECOND_SAMPLE_FILE);
        SimpleGbsTag differentGbsTag = different.getTag();
        
        assertNotSame(differentGbsTag,tag); // object references
        assertNotEquals(differentGbsTag,tag); // while we're at it
        assertNotEquals(differentGbsTag.hashCode(),tag.hashCode());
    }
    
    @Test
    public void testEqualObjects() throws IOException {
        
        Gbs cloneFile = new GbsFile(FIRST_SAMPLE_FILE);
        SimpleGbsTag clone = cloneFile.getTag();
        
        assertNotSame(clone,tag); // no cheating
        assertEquals(clone.hashCode(),tag.hashCode()); // equal objects *MUST* have equals hashcodes
        assertEquals(clone,tag);
    }
    
    @Test
    public void testNonEqualObjects() throws IOException {
        
         Gbs other = new GbsFile(SECOND_SAMPLE_FILE);
         SimpleGbsTag dkland = other.getTag();
         
         assertNotEquals(dkland,tag);
    }
    
    @Test
    public void testComparableSorting() throws IOException {
        
        Gbs otherFile = new GbsFile(SECOND_SAMPLE_FILE);
        SimpleGbsTag other = otherFile.getTag();
        
        List<SimpleGbsTag> myList = new ArrayList<>();
        myList.add(other);
        myList.add(tag);
        myList.add(other);
        myList.add(tag);
        
        myList.sort(null);
        myList.forEach(System.out::println);
        assertEquals(tag,myList.get(3));
        assertEquals(tag,myList.get(2));
        assertEquals(other,myList.get(1));
        assertEquals(other,myList.get(0));
        
    }
    
    @Test
    public void testComparableWithNullValues() throws IOException {
        
    	Gbs otherFile = new GbsFile(SECOND_SAMPLE_FILE); //accessing using the interface this time
    	SimpleGbsTag other = otherFile.getTag();
        
        other.setTitle(null);
        other.setAuthor(null);
        other.setCopyright(null);
        tag.setTitle(null);
        
        List<SimpleGbsTag> myList = new ArrayList<>();
        myList.add(tag);
        myList.add(other);
        
        myList.sort(null);
        
        assertNull(myList.get(0).getTitle());
        assertNull(myList.get(0).getAuthor());
        assertNull(myList.get(0).getCopyright());
        assertNull(myList.get(1).getTitle());
        assertNotNull(myList.get(1).getAuthor());
        assertNotNull(myList.get(1).getCopyright());
    }
    
    @Test
    public void testFileWithValidHeader() {
        
        // first 3 bytes of string should equal "GBS"
        final String headerWithoutVersionNumber = readOnlyTag.getHeader();
        assertEquals("GBS",headerWithoutVersionNumber); // case sensitive
    }
    
    @Test(expected=IOException.class)
    public void testFileWithInvalidHeader() throws IOException {
        // tests a file that is not a GBS
        gbsFile = new GbsFile("gbs/randomBytes.gbs"); // will throw exception
        
    }
    
	

}
