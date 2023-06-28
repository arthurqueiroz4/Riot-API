package org.Application.Requests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.Application.DTO.LeagueEntryDTO;
import org.Application.Util;

import java.util.List;

public class Entry {
    private static String urlToEntries = "https://br1.api.riotgames.com/lol/league/v4/entries/by-summoner/";
    private static Util util;
    private static Gson gson = new Gson();

    public static List<LeagueEntryDTO> getEntries(String summonerId) throws Exception {
        Thread.sleep(1000);
        String json = Connection.openConnection(urlToEntries+summonerId+util.API_KEY);
        TypeToken<List<LeagueEntryDTO>> typeToken = new TypeToken<List<LeagueEntryDTO>>() {};
        return gson.fromJson(json, typeToken.getType());
    }



}
