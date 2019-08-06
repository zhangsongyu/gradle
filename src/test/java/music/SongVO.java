package music;

import java.util.List;

/**
 * Created by zsy on 2019/8/6 15:21
 */
public class SongVO {
    public static class SongListResp {
        private SongListVO result;
        private Integer code;

        public SongListVO getResult() {
            return result;
        }

        public void setResult(SongListVO result) {
            this.result = result;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    public static class LrcResp {
        private Lrc lrc;

        public Lrc getLrc() {
            return lrc;
        }

        public void setLrc(Lrc lrc) {
            this.lrc = lrc;
        }
    }

    public static class SongListVO {
        private List<Track> tracks;
        private String name;

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(List<Track> tracks) {
            this.tracks = tracks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

    public static class Lyric {
        private String lyric;

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }

    public static class Lrc {
        private Integer version;
        private Lyric lyric;

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public Lyric getLyric() {
            return lyric;
        }

        public void setLyric(Lyric lyric) {
            this.lyric = lyric;
        }
    }

}
