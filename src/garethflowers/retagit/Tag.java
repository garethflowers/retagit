package garethflowers.retagit;

/**
 * Tag
 */
public class Tag {

    private String Filename = "";
    private String Artist = "";
    private String Album = "";
    private String AlbumArtist = "";
    private int BPM = 0;
    private String Composer = "";
    private String Comments = "";
    private String Copyright = "";
    private String EncodedBy = "";
    private String Genre = "";
    private String Grouping = "";
    private boolean HD = false;
    private boolean Compilation = false;
    private boolean Gapless = false;
    private boolean Podcast = false;
    private String Name = "";
    private int MediaType = 0;
    private int Rating = 0;
    private int ReleaseDate = 0;
    private int Disc = 0;
    private int DiscTotal = 0;
    private int Track = 0;
    private int TrackTotal = 0;
    private int CnID = 0;
    private String ApID = "";
    private String TvShowName = "";
    private String TvEpisode = "";
    private int TvSeasonNum = 0;
    private int TvEpisodeNum = 0;
    private String Description = "";
    private int Advisory = 0;

    public Tag(String File) {
        this.Filename = File;
    }

    /**
     * @return the MediaType
     */
    public int getMediaType() {
        return this.MediaType;
    }

    /**
     * @param MediaType the MediaType to set
     */
    public void setMediaType(int MediaType) {
        this.MediaType = MediaType;
    }

    /**
     * @return the Artist
     */
    public String getArtist() {
        return this.Artist;
    }

    /**
     * @param Artist the Artist to set
     */
    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    /**
     * @return the Album
     */
    public String getAlbum() {
        return this.Album;
    }

    /**
     * @param Advisory the Advisory to set
     */
    public void setAdvisory(int Advisory) {
        this.Advisory = Advisory;
    }

    /**
     * @return the Advisory
     */
    public int getAdvisory() {
        return this.Advisory;
    }

    /**
     * @param Album the Album to set
     */
    public void setAlbum(String Album) {
        this.Album = Album;
    }

    /**
     * @param EncodedBy the EncodedBy to set
     */
    public void setEncodedBy(String EncodedBy) {
        this.EncodedBy = EncodedBy;
    }

    /**
     * @return the Rating
     */
    public int getRating() {
        return this.Rating;
    }

    /**
     * @return the ReleaseDate
     */
    public int getReleaseDate() {
        return this.ReleaseDate;
    }

    /**
     * @param ReleaseDate the ReleaseDate to set
     */
    public void setReleaseDate(int ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    /**
     * @return the AlbumArtist
     */
    public String getAlbumArtist() {
        return this.AlbumArtist;
    }

    /**
     * @param AlbumArtist the album artist to set
     */
    public void setAlbumArtist(String AlbumArtist) {
        this.AlbumArtist = AlbumArtist;
    }

    /**
     * @return the Filename
     */
    public String getFilename() {
        return this.Filename;
    }

    /**
     * @param Rating the Rating to set
     */
    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    /**
     * @return the Grouping
     */
    public String getGrouping() {
        return this.Grouping;
    }

    /**
     * @param Grouping the Grouping to set
     */
    public void setGrouping(String Grouping) {
        this.Grouping = Grouping;
    }

    /**
     * @return the Composer
     */
    public String getComposer() {
        return this.Composer;
    }

    /**
     * @param Composer the Composer to set
     */
    public void setComposer(String Composer) {
        this.Composer = Composer;
    }

    /**
     * @return the BPM
     */
    public int getBPM() {
        return this.BPM;
    }

    /**
     * @param BPM the BPM to set
     */
    public void setBPM(int BPM) {
        this.BPM = BPM;
    }

    /**
     * @return the Track
     */
    public int getTrack() {
        return this.Track;
    }

    /**
     * @param Track the Track to set
     */
    public void setTrack(int Track) {
        this.Track = Track;
    }

    /**
     * @return the TrackTotal
     */
    public int getTrackTotal() {
        return this.TrackTotal;
    }

    /**
     * @param TrackTotal the TrackTotal to set
     */
    public void setTrackTotal(int TrackTotal) {
        this.TrackTotal = TrackTotal;
    }

    /**
     * @return the TrackInfo
     */
    public String getTrackInfo() {
        String info = "";
        if (this.getTrack() > 0) {
            info += Integer.toString(this.getTrack());
            if (this.getTrackTotal() > 0) {
                info += "/" + Integer.toString(this.getTrackTotal());
            }
        } else {
            info += "\"\"";
        }
        return info;
    }

    /**
     * @return the Disc
     */
    public int getDisc() {
        return this.Disc;
    }

    /**
     * @param Disc the Disc to set
     */
    public void setDisc(int Disc) {
        this.Disc = Disc;
    }

    /**
     * @return the DiscTotal
     */
    public int getDiscTotal() {
        return this.DiscTotal;
    }

    /**
     * @param DiscTotal the DiscTotal to set
     */
    public void setDiscTotal(int DiscTotal) {
        this.DiscTotal = DiscTotal;
    }

    /**
     * @return the TrackInfo
     */
    public String getDiscInfo() {
        String info = "";
        if (this.getDisc() > 0) {
            info += Integer.toString(this.getDisc());
            if (this.getDiscTotal() > 0) {
                info += "/" + Integer.toString(this.getDiscTotal());
            }
        } else {
            info += "\"\"";
        }
        return info;
    }

    /**
     * @return the Genre
     */
    public String getGenre() {
        return this.Genre;
    }

    /**
     * @param Genre the Genre to set
     */
    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    /**
     * @return the Comments
     */
    public String getComments() {
        return this.Comments;
    }

    /**
     * @param Comments the Comments to set
     */
    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    /**
     * @return the EncodedBy
     */
    public String getEncodedBy() {
        return this.EncodedBy;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return this.Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Copyright
     */
    public String getCopyright() {
        return this.Copyright;
    }

    /**
     * @param Copyright the Copyright to set
     */
    public void setCopyright(String Copyright) {
        this.Copyright = Copyright;
    }

    /**
     * @return the TvShowName
     */
    public String getTvShowName() {
        return this.TvShowName;
    }

    /**
     * @param TvShowName the TvShowName to set
     */
    public void setTvShowName(String TvShowName) {
        this.TvShowName = TvShowName;
    }

    /**
     * @return the TvEpisode
     */
    public String getTvEpisode() {
        return this.TvEpisode;
    }

    /**
     * @param TvEpisode the TvEpisode to set
     */
    public void setTvEpisode(String TvEpisode) {
        this.TvEpisode = TvEpisode;
    }

    /**
     * @return the TvSeasonNum
     */
    public int getTvSeasonNum() {
        return this.TvSeasonNum;
    }

    /**
     * @param TvSeasonNum the TvSeasonNum to set
     */
    public void setTvSeasonNum(int TvSeasonNum) {
        this.TvSeasonNum = TvSeasonNum;
    }

    /**
     * @return the TvEpisodeNum
     */
    public int getTvEpisodeNum() {
        return this.TvEpisodeNum;
    }

    /**
     * @param TvEpisodeNum the TvEpisodeNum to set
     */
    public void setTvEpisodeNum(int TvEpisodeNum) {
        this.TvEpisodeNum = TvEpisodeNum;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return this.Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the HD
     */
    public boolean getIsHD() {
        return this.HD;
    }

    /**
     * @param HD the HD to set
     */
    public void setIsHD(boolean HD) {
        this.HD = HD;
    }

    /**
     * @return the Compilation
     */
    public boolean getIsCompilation() {
        return this.Compilation;
    }

    /**
     * @param Compilation the Compilation to set
     */
    public void setIsCompilation(boolean Compilation) {
        this.Compilation = Compilation;
    }

    /**
     * @return the Gapless
     */
    public boolean getIsGapless() {
        return this.Gapless;
    }

    /**
     * @param Gapless the Gapless to set
     */
    public void setIsGapless(boolean Gapless) {
        this.Gapless = Gapless;
    }

    /**
     * @return the podcast
     */
    public boolean getIsPodcast() {
        return this.Podcast;
    }

    /**
     * @param Podcast the podcast to set
     */
    public void setIsPodcast(boolean Podcast) {
        this.Podcast = Podcast;
    }

    /**
     * @return the CnID
     */
    public int getCnID() {
        return this.CnID;
    }

    /**
     * @param CnID the CnID to set
     */
    public void setCnID(int CnID) {
        this.CnID = CnID;
    }

    /**
     * @return the ApID
     */
    public String getApID() {
        return ApID;
    }

    /**
     * @param ApID the ApID to set
     */
    public void setApID(String ApID) {
        this.ApID = ApID;
    }
}
