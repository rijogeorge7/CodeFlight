package dayily_challenges;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rijogeorge on 6/26/18.
 */
public class JobMatchingScoreTest {
    JobMatchingScore jobMatchingScore;
    @Before
    public void setUp() throws Exception {
        jobMatchingScore = new JobMatchingScore();
    }

    @After
    public void tearDown() throws Exception {
        jobMatchingScore = null;
    }

    @Test
    public void jobMatchingScore() throws Exception {
        String[] locations = new String[] {"San Francisco, California, United States",
                "San Mateo, California, United States",
                "Columbia, South Carolina, United States",
                "Columbia, California, United States"};
        String criteria = "Columbia, South Carolina, United States";
        int result = jobMatchingScore.jobMatchingScore(locations, criteria);
        assertEquals(1,result);
    }

}