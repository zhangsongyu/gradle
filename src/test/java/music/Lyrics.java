package music;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by zsy on 2019/8/6 14:59
 */
public class Lyrics {
    public static void main(String[] args) throws IOException {
        //http://music.163.com/api/song/lyric?id=27566765&lv=1&kv=1&tv=-1

        OkHttpClient client = new OkHttpClient();

        Request songsList = new Request.Builder()
                .url("http://music.163.com/api/playlist/detail?id=12121241&offset=0&total=true&limit=1001")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "8b48bdac-ba43-e926-d56f-3a722892374c")
                .build();

        Response songListResp = client.newCall(songsList).execute();

        JSON.songListResp.body().string()

        Request lyric = new Request.Builder()
                .url("http://music.163.com/api/song/lyric?id=27566765&lv=1&kv=1&tv=-1")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "b3a432e9-ff84-73cc-a34c-d40fc30c4c86")
                .build();

        Response lyricResp = client.newCall(lyric).execute();
    }
}
