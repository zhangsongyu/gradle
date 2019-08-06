package music;

import java.util.List;

/**
 * Created by zsy on 2019/8/6 15:21
 */
public class SongVO {

    public static class SongListVO {
        private List<Track> tracks;

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(List<Track> tracks) {
            this.tracks = tracks;
        }
    }

    public static class Track {
        private Integer id;
        private String name;
        private Artist artists;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Artist getArtists() {
            return artists;
        }

        public void setArtists(Artist artists) {
            this.artists = artists;
        }
    }

    public static class Artist {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
