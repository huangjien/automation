package automation.datacachelayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jien.huang on 08/05/2017.
 */
public class MongoDataTest {

    Logger logger = LoggerFactory.getLogger("test");

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        //clear all data
        MongoData.get_instance().deleteAll();
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {
        //clear all data
        MongoData.get_instance().deleteAll();
    }

    @org.testng.annotations.Test
    public void testGet_instance() throws Exception {
        Assert.assertNotNull(MongoData.get_instance());
    }

//    @org.testng.annotations.Test(expectedExceptions = AssertionError.class)
//    public void testInsertWithNoId() throws Exception {
//        String noIdJsonString = "{ }";
//        //TODO
//    }

    @Test
    public void testInsertFindUpdateAndDelete(){
        String jsonString = "{ '_id' : '0010010000001', 'type' : 'test', data : 'data'  }";
        MongoData.get_instance().insert(jsonString);
        String found = MongoData.get_instance().findById("0010010000001");
        Assert.assertTrue(found.contains("test"));
        String secondJsonString = "{ '_id' : '0020020000002', 'type' : 'tag', data : 'datum'  }";
        MongoData.get_instance().insert(secondJsonString);
        found = MongoData.get_instance().find( "type=t.*","data=d.+");
        logger.info(found);
        Assert.assertTrue(found.contains("datum") && found.contains("test"));
        MongoData.get_instance().update("{ '_id' : '0010010000001', 'type' : 'case', data : 'suite'  }");
        found = MongoData.get_instance().findById("0010010000001");
        logger.info(found);
        Assert.assertTrue(found.contains("case"));

        found = MongoData.get_instance().find( "type=(tag|case)");
        logger.info(found);
        Assert.assertTrue(found.contains("case") && found.contains("tag"));
        //delete
        MongoData.get_instance().delete("0010010000001");
        found = MongoData.get_instance().findById("0010010000001");
        logger.info(found);
        Assert.assertFalse(found.contains("case"));
    }

}