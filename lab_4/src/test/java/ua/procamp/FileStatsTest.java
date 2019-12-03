package ua.procamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class FileStatsTest {


    @Test
    public void testCreateFileStatsFromExistingFile() {
        FileStats fileStats = FileStats.from("sotl.txt");
    }

    @Test(expected = FileStatsException.class)
    public void testCreateFileStatsFromNonExistingFile() {
        FileStats fileStats = FileStats.from("blahblah.txt");
    }

    @Test
    public void testGetCharCount() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        int aCharCountInLambdaArticle = lambdaArticleFileStats.getCharCount('a');
        int bCharCountInSpringArticle = springCloudArticleFileStats.getCharCount('b');

        assertEquals(2345, aCharCountInLambdaArticle);
        assertEquals(4, bCharCountInSpringArticle);
    }

    @Test
    public void testGetMostPopularCharacter() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        char mostPopularCharacterInLambdaArticle = lambdaArticleFileStats.getMostPopularCharacter();
        char mostPopularCharacterInSpringArticle = springCloudArticleFileStats.getMostPopularCharacter();

        System.out.println(mostPopularCharacterInSpringArticle);

        assertEquals('e', mostPopularCharacterInLambdaArticle);
        assertEquals('e', mostPopularCharacterInSpringArticle);
    }

    @Test
    public void testContainsCharacter() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        boolean lambdaArticleContainsExistingCharacter = lambdaArticleFileStats.containsCharacter('a');
        boolean lambdaArticleContainsWhitespace = lambdaArticleFileStats.containsCharacter(' ');
        boolean springArticleContainsExistingCharacter = springCloudArticleFileStats.containsCharacter('b');
        boolean springArticleContainsWhitespace = springCloudArticleFileStats.containsCharacter(' ');

        assertTrue(lambdaArticleContainsExistingCharacter);
        assertFalse(lambdaArticleContainsWhitespace);
        assertTrue(springArticleContainsExistingCharacter);
        assertFalse(springArticleContainsWhitespace);
    }

    @Test
    public void getMapOfCounterAndStrings() {
        List<String> test = new ArrayList<>();
        test.add("simple");
        test.add("Hello");
        test.add("simple");
        test.add("To");
        test.add("simple");
        test.add("text12");
        test.add("Everyone");

        Map<Integer, List<String>> temp = FileStats.getMapOfCounterAndStrings(test);

        List<String> simple = new ArrayList<>();
        simple.add("simple");
        simple.add("simple");
        simple.add("simple");
        simple.add("text12");

        Assert.assertEquals(simple, temp.get(Integer.valueOf(6)));
    }

    @Test
    public void getMapOfCounterAndStringsFile() {
        List<String> fileContent = FileReaders.readWholeFileList("lines.txt");


        Map<Integer, List<String>> temp = FileStats.getMapOfCounterAndStrings(fileContent);

        List<String> simple = new ArrayList<>();
        simple.add("Hey!");

        Assert.assertEquals(simple, temp.get(Integer.valueOf(4)));
    }

}
