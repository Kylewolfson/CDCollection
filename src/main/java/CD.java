import java.util.ArrayList;

public class CD {
  private String mTitle;
  private int mID;
  protected String mArtistName;
  private static ArrayList<CD> CDs = new ArrayList<CD>();
  private static ArrayList<Object> artists = new ArrayList<Object>();

  public CD(String title){
    mTitle = title;
    CDs.add(this);
    mArtistName = "";
    mID = CDs.size();
  }

  public void addArtistToCD(String artist, int id) {
    CDs.get(id).mArtistName = artist;
    addArtistToArtistList(artist);
  }

  private void addArtistToArtistList(String artistName) {
    if (!(artists.indexOf(artistName) >= 0)) {
      artists.add(artistName);
    } else {}
  }

  public static ArrayList<CD> all() {
    return CDs;
  }

  public String getTitle() {
    return mTitle;
  }

  public int getID() {
    return mID - 1;
  }
  public String getArtistName(){
    return mArtistName;
  }
  public static ArrayList<Object> allArtists() {
    return artists;
  }

  public static ArrayList<CD> byArtist(String artist){
    ArrayList<CD> byArtist = new ArrayList<CD>();
    for(CD cd : CDs){
      if(cd.mArtistName.equals(artist)){
        byArtist.add(cd);
      }
    }
    return byArtist;
  }
}
