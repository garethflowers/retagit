package garethflowers.retagit;

/**
 * TagReader
 */
public class TagReader {

    private static String COPYRIGHT = "\u00a9";

    private TagReader() {
    }

    public static Tag read(String fileName) {
        Tag currentTag = new Tag(fileName);

        String cmd = Settings.getAtomicParsley() + " \""
                + currentTag.getFilename() + "\" -t +";

        ProcessExecuter c = new ProcessExecuter();
        c.ExecCommand(cmd);
        String[] result = c.GetResult();

        for (int i = 0; i < result.length; i++) {
            String value = result[i];

            if (value.startsWith("Atom \"")) {
                if (value.substring(10, 22).equals("\" contains: ")
                        || value.substring(11, 23).equals("\" contains: ")) {
                    String tag[] = value.split("\"");
                    String contents = value.substring(22, value.length())
                            .trim();

                    if (tag[1].endsWith(COPYRIGHT + "alb")) {
                        currentTag.setAlbum(contents);
                    } else if (tag[1].equals("aART")) {
                        currentTag.setAlbumArtist(contents);
                    } else if (tag[1].endsWith(COPYRIGHT + "ART")) {
                        currentTag.setArtist(contents);
                    } else if (tag[1].equals("tmpo")) {
                        try {
                            currentTag.setBPM(Integer.parseInt(contents));
                        } catch (NumberFormatException ex) {
                            System.out.println(ex.getStackTrace());
                        }
                    } else if (tag[1].endsWith(COPYRIGHT + "cmt")) {
                        currentTag.setComments(contents);
                    } else if (tag[1].endsWith(COPYRIGHT + "wrt")) {
                        currentTag.setComposer(contents);
                    } else if (tag[1].equals("trkn")) {
                        String tracks[] = contents.split(" of ");
                        if (tracks.length > 0) {
                            try {
                                currentTag
                                        .setTrack(Integer.parseInt(tracks[0]));
                            } catch (NumberFormatException ex) {
                                System.out.println(ex.getStackTrace());
                            }
                        }
                        if (tracks.length > 1) {
                            try {
                                currentTag.setTrackTotal(Integer
                                        .parseInt(tracks[1]));
                            } catch (NumberFormatException ex) {
                                System.out.println(ex.getStackTrace());
                            }
                        }
                    } else if (tag[1].endsWith(COPYRIGHT + "too")) {
                        currentTag.setEncodedBy(contents);
                    } else if (tag[1].endsWith(COPYRIGHT + "grp")) {
                        currentTag.setGrouping(contents);
                    } else if (tag[1].equals("hdvd")) {
                        currentTag.setIsHD(contents.contains("1"));
                    } else if (tag[1].endsWith(COPYRIGHT + "nam")) {
                        currentTag.setName(contents);
                    } else if (tag[1].equals("stik")) {
                        if (contents.equals("Movie")
                                || contents.equals("Short Film")) {
                            currentTag.setMediaType(1);
                        } else if (contents.equals("Music Video")) {
                            currentTag.setMediaType(2);
                        } else if (contents.equals("TV Shows")
                                || contents.equals("TV Show")) {
                            currentTag.setMediaType(3);
                        }
                    } else if (tag[1].equals("rtng")) {
                        if (contents.equals("clean")
                                || contents.equals("Clean Content")) {
                            currentTag.setAdvisory(1);
                        } else if (contents.equals("explicit")
                                || contents.equals("Explicit Content")) {
                            currentTag.setAdvisory(2);
                        }
                    } else if (tag[1].equals("cprt")) {
                        currentTag.setCopyright(contents);
                    } else if (tag[1].equals("tvsh")) {
                        currentTag.setTvShowName(contents);
                    } else if (tag[1].equals("tven")) {
                        currentTag.setTvEpisode(contents);
                    } else if (tag[1].equals("desc")) {
                        currentTag.setDescription(contents);
                    } else if (tag[1].equals("cnID")) {
                        try {
                            currentTag.setCnID(Integer.parseInt(contents));
                        } catch (NumberFormatException ex) {
                            System.out.println(ex.getStackTrace());
                        }
                    } else if (tag[1].equals("tvsn")) {
                        try {
                            currentTag.setTvSeasonNum(Integer
                                    .parseInt(contents));
                        } catch (NumberFormatException ex) {
                            System.out.println(ex.getStackTrace());
                        }
                    } else if (tag[1].equals("tves")) {
                        try {
                            currentTag.setTvEpisodeNum(Integer
                                    .parseInt(contents));
                        } catch (NumberFormatException ex) {
                            System.out.println(ex.getStackTrace());
                        }
                    } else if (tag[1].equals("cpil")) {
                        currentTag.setIsCompilation(contents.contains("true"));
                    } else if (tag[1].equals("pcst")) {
                        currentTag.setIsPodcast(contents.contains("true"));
                    } else if (tag[1].equals("pgap")) {
                        currentTag.setIsGapless(contents.contains("true"));
                    } else if (tag[1].endsWith(COPYRIGHT + "day")) {
                        try {
                            currentTag.setReleaseDate(Integer.parseInt(contents
                                    .substring(0, 4)));
                        } catch (NumberFormatException ex) {
                            System.out.println(ex.getStackTrace());
                        }
                    } else if (tag[1].endsWith(COPYRIGHT + "gen")
                            || tag[1].equals("gnre")) {
                        currentTag.setGenre(contents);
                    } else if (tag[1].equals("disk")) {
                        String discs[] = contents.split(" of ");
                        if (discs.length > 1) {
                            try {
                                currentTag.setDiscTotal(Integer
                                        .parseInt(discs[1]));
                            } catch (NumberFormatException ex) {
                                System.out.println(ex.getStackTrace());
                            }
                        } else if (discs.length > 0) {
                            try {
                                currentTag.setDisc(Integer.parseInt(discs[0]));
                            } catch (NumberFormatException ex) {
                                System.out.println(ex.getStackTrace());
                            }
                        }
                    }
                } else if (value
                        .startsWith("Atom \"----\" [com.apple.iTunes;iTunEXTC] contains: ")) {
                    String[] contents = value
                            .replace(
                                    "Atom \"----\" [com.apple.iTunes;iTunEXTC] contains: ",
                                    "").split("\\|");
                    if (contents.length > 1) {
                        if (contents[1].equals("U")) {
                            currentTag.setRating(1);
                        } else if (contents[1].equals("PG")) {
                            currentTag.setRating(2);
                        } else if (contents[1].equals("12")) {
                            currentTag.setRating(3);
                        } else if (contents[1].equals("12A")) {
                            currentTag.setRating(4);
                        } else if (contents[1].equals("15")) {
                            currentTag.setRating(5);
                        } else if (contents[1].equals("18")) {
                            currentTag.setRating(6);
                        }
                    }
                }
            }
        }

        return currentTag;
    }
}
