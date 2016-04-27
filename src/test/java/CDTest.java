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
    CD.addArtistToCD("Hanson", firstCD.getTitle(), CD.all());
    assertEquals(artist, firstCD.getArtistName());
  }

  @Test
  public void CD_returnsAllInstancesOfArtist_true() {
    CD firstCD = new CD("Hanson's Greatest Hit");
    CD secondCD = new CD("Michael Jackson's top 40");
    CD.addArtistToCD("Hanson", firstCD.getTitle(), CD.all());
    CD.addArtistToCD("MJ", secondCD.getTitle(), CD.all());
    assertTrue(CD.allArtists().contains("Hanson"));
    assertTrue(CD.allArtists().contains("MJ"));
  }


    @Test
    public void CD_returnsAllCDsOfArtist_true() {
      CD firstCD = new CD("Hanson's Greatest Hit");
      CD secondCD = new CD("Michael Jackson's top 40");
      CD thirdCD = new CD("Hanson is still a band?");
      CD.addArtistToCD("Hanson", firstCD.getTitle(), CD.all());
      CD.addArtistToCD("MJ", secondCD.getTitle(), CD.all());
      CD.addArtistToCD("Hanson", thirdCD.getTitle(), CD.all());
      CD testingCD = CD.byArtist("Hanson", CD.all()).get(1);
      assertTrue(testingCD.getTitle().equals("Hanson is still a band?"));
    }
}
