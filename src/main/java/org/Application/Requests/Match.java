package org.Application.Requests;

import com.google.gson.Gson;
import org.Application.DTO.MatchDTO;
import org.Application.Util;

import java.util.List;

public class Match {
    private static String urlToRequest = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
    private static String urlToGetMatchInfo = "https://americas.api.riotgames.com/lol/match/v5/matches/";
    private static String endRequest = "/ids";
    private static Gson gson = new Gson();

    private static Util util;

    @SuppressWarnings("rawtypes")
    public static List getAllMatchesForSummoner(String puuid, Integer count) throws Exception {
        Thread.sleep(1000);
        var response = Connection.openConnection(urlToRequest+puuid+endRequest+util.API_KEY+"&count="+count);
        return gson.fromJson(response, List.class);
    }
    public static List getAllMatchesForSummoner(String puuid) throws Exception {
        Thread.sleep(1000);
        var response = Connection.openConnection(urlToRequest+puuid+endRequest+util.API_KEY);
        return gson.fromJson(response, List.class);
    }

    public static MatchDTO getMatchInfo(String matchId) throws Exception {
        Thread.sleep(1000);
        var response = Connection.openConnection(urlToGetMatchInfo+matchId+util.API_KEY);
        return gson.fromJson(response, MatchDTO.class);
    }


}
