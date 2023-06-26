package org.Application.Requests;

import com.google.gson.Gson;
import org.Application.DTO.SummonerDTO;
import org.Application.Util;

public class Summoner {
	private static String urlToGetSummonerByName = "https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    private static String urlToGetSummonerByPuuid = "https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
    private static Util util;
    private static Gson gson = new Gson();
    
    public static SummonerDTO getSummonersByName(String name) throws Exception{
        try{
            String json = Connection.openConnection(urlToGetSummonerByName+name+util.API_KEY);
            return gson.fromJson(json, SummonerDTO.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println();
        }
        return  new SummonerDTO(null,null,null,null,null,null,null);
    }

    public static SummonerDTO getSummonerByPuuid(String puuid) throws Exception {
        try {
            String json = Connection.openConnection(urlToGetSummonerByPuuid + puuid + util.API_KEY);
            return gson.fromJson(json, SummonerDTO.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println();
        }
        return  new SummonerDTO(null,null,null,null,null,null,null);
    }

}
