package music;

import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by zsy on 2019/8/6 14:59
 */
public class Lyrics {
    public static void main(String[] args) throws IOException {

        String FILE_PATH = "C:\\Users\\zsy\\Documents\\lyric\\";
        OkHttpClient client = new OkHttpClient();

        Request songsList = new Request.Builder()
                .url("http://music.163.com/api/playlist/detail?id=12121241&offset=0&total=true&limit=1001")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "8b48bdac-ba43-e926-d56f-3a722892374c")
                .build();

        Response songListResp = client.newCall(songsList).execute();
        String songListStr = songListResp.body().string();
        Map<String, Object> songMap = JSON.parseObject(songListStr);
        Map resultMap = JSON.parseObject(songMap.get("result").toString());
        String listname = resultMap.get("name").toString();

        List<Map> tracks = JSON.parseObject(resultMap.get("tracks").toString(), List.class);


        tracks.forEach(track -> {
            Request lyric = new Request.Builder()
                    .url("http://music.163.com/api/song/lyric?id=" + track.get("id") + "&lv=1&kv=1&tv=-1")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b3a432e9-ff84-73cc-a34c-d40fc30c4c86")
                    .build();

            try {
                Response lyricResp = client.newCall(lyric).execute();
                String lrcStr = lyricResp.body().string();
                Map lrcMap = JSON.parseObject(lrcStr);
                String lyricStr = JSON.parseObject(lrcMap.get("lrc").toString()).get("lyric").toString();
                FileUtils.writeStringToFile(new File(FILE_PATH + listname+"\\"+track.get("name").toString()),
                        lyricStr, "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
