package garethflowers.retagit;

/**
 * TagWriter
 */
public class TagWriter {

    private Tag currentTag;

    public TagWriter(Tag current) {
        this.currentTag = current;
    }

    public boolean write() {
        garethflowers.retagit.process.Executer executer = new garethflowers.retagit.process.Executer();

        try {
            executer.ExecCommand(this.Generate());
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            return false;
        }

        return true;
    }

    private String Generate() {
        String cmd = Settings.getAtomicParsley() + " \"" + this.currentTag.getFilename() + "\"";
        cmd += " --artist \"" + this.currentTag.getArtist() + "\"";
        cmd += " --albumArtist \"" + this.currentTag.getAlbumArtist() + "\"";
        cmd += " --title \"" + this.currentTag.getName() + "\"";
        cmd += " --album \"" + this.currentTag.getAlbum() + "\"";
        cmd += " --genre \"" + this.currentTag.getGenre() + "\"";
        cmd += " --year \"" + Integer.toString(this.currentTag.getReleaseDate()) + "\"";
        cmd += " --comment \"" + this.currentTag.getComments() + "\"";
        cmd += " --grouping \"" + this.currentTag.getGrouping() + "\"";
        cmd += " --tracknum " + this.currentTag.getTrackInfo();
        cmd += " --disk " + this.currentTag.getDiscInfo();
        cmd += " --composer \"" + this.currentTag.getComposer() + "\"";
        cmd += " --bpm " + Integer.toString(this.currentTag.getBPM());
        cmd += " --copyright \"" + this.currentTag.getCopyright() + "\"";
        cmd += " --encodingTool \"" + this.currentTag.getEncodedBy() + "\"";
        cmd += " --compilation " + Boolean.toString(this.currentTag.getIsCompilation());
        cmd += " --podcastFlag " + Boolean.toString(this.currentTag.getIsPodcast());
        cmd += " --gapless " + Boolean.toString(this.currentTag.getIsGapless());
        cmd += " --TVShowName \"" + this.currentTag.getTvShowName() + "\"";
        cmd += " --TVEpisode \"" + this.currentTag.getTvEpisode() + "\"";
        cmd += " --TVSeasonNum \"" + Integer.toString(this.currentTag.getTvSeasonNum()) + "\"";
        cmd += " --TVEpisodeNum \"" + Integer.toString(this.currentTag.getTvEpisodeNum()) + "\"";
        cmd += " --description \"" + this.currentTag.getDescription() + "\"";
        cmd += " --contentRating \"\"";



        switch (this.currentTag.getRating()) {
            case 1:
                cmd += " --rDNSatom \"uk-movie|U|100|\" name=iTunEXTC domain=com.apple.iTunes";
                break;
            case 2:
                cmd += " --rDNSatom \"uk-movie|PG|200|\" name=iTunEXTC domain=com.apple.iTunes";
                break;
            case 3:
                cmd += " --rDNSatom \"uk-movie|12|300|\" name=iTunEXTC domain=com.apple.iTunes";
                break;
            case 4:
                cmd += " --rDNSatom \"uk-movie|12A|325|\" name=iTunEXTC domain=com.apple.iTunes";
                break;
            case 5:
                cmd += " --rDNSatom \"uk-movie|15|350|\" name=iTunEXTC domain=com.apple.iTunes";
                break;
            case 6:
                cmd += " --rDNSatom \"uk-movie|18|400|\" name=iTunEXTC domain=com.apple.iTunes";
                break;
            default:
                cmd += " --contentRating \"\"";
                break;
        }

        switch (this.currentTag.getAdvisory()) {
            case 1:
                cmd += " --advisory \"clean\"";
                break;
            case 2:
                cmd += " --advisory \"explicit\"";
                break;
            default:
                cmd += " --advisory \"remove\"";
                break;
        }

        cmd += " --overWrite";
        return cmd;
    }
}
