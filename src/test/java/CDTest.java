import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CDTest {

  @Test
  public void CD_InstanceOfCD_True() {
    CD testCD = new CD("Hanson's Greatest Hit");
    assertEquals(true, testCD instanceof CD);
  }

  @Test
  public void CD_ReturnTitle() {
    CD testCD = new CD("Hanson's Greatest Hit");
    String title = "Hanson's Greatest Hit";
    assertEquals(title, testCD.getTitle());
  }

  @Test
  public void CD_returnsAllInstancesOfCD_true() {
    CD firstCD = new CD("Hanson's Greatest Hit");
    CD secondCD = new CD("Michael Jackson's top 40");
    assertTrue(CD.all().contains(firstCD));
    assertTrue(CD.all().contains(secondCD));
  }

  @Test
  public void CD_UpdatesArtistName() {
    CD firstCD = new CD("Hanson's Greatest Hit");
    String artist = "Hanson";
    firstCD.addArtistToCD("Hanson", firstCD.getID());
    assertEquals(artist, firstCD.getArtistName());
  }

  @Test
  public void CD_returnsAllInstancesOfArtist_true() {
    CD firstCD = new CD("Hanson's Greatest Hit");
    CD secondCD = new CD("Michael Jackson's top 40");
    firstCD.addArtistToCD("Hanson", firstCD.getID());
    secondCD.addArtistToCD("MJ", secondCD.getID());
    assertTrue(CD.allArtists().contains("Hanson"));
    assertTrue(CD.allArtists().contains("MJ"));
  }


    @Test
    public void CD_returnsAllCDsOfArtist_true() {
      CD firstCD = new CD("Hanson's Greatest Hit");
      CD secondCD = new CD("Michael Jackson's top 40");
      CD thirdCD = new CD("Hanson is still a band?");
      firstCD.addArtistToCD("Hanson", firstCD.getID());
      secondCD.addArtistToCD("MJ", secondCD.getID());
      thirdCD.addArtistToCD("Hanson", thirdCD.getID());
      CD testingCD = CD.byArtist("Hanson").get(1);
      assertTrue(testingCD.getTitle().equals("Hanson is still a band?"));
    }




}
