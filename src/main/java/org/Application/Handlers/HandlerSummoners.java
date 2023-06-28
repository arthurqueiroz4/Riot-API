package org.Application.Handlers;

import org.Application.DTO.SummonerDTO;
import org.Application.Requests.Summoner;

import java.util.ArrayList;
import java.util.List;

public class HandlerSummoners {

    public List<SummonerDTO> getSummonersAll(ArrayList<String> nicknames) throws Exception {
        List<SummonerDTO> summoners = new ArrayList<>();
        for (String nick : nicknames) {
            summoners.add(Summoner.getSummonersByName(nick));
        }
        return summoners;
    }

    public SummonerDTO getSummoner(String puuid) throws Exception {
        return Summoner.getSummonerByPuuid(puuid);
    }

    public SummonerDTO getSummonerByName(List<SummonerDTO> summoners, String name){
        String puuid = "";
        for (SummonerDTO summoner : summoners) {
            if (summoner.name().equalsIgnoreCase(name)){
                return summoner;
            }
        }
        return  new SummonerDTO(null,null,null,null,null,null,null);
    }


    public List<String> returnAllPuuid(List<SummonerDTO> summoners){
        return summoners.stream().map(summoner -> summoner.puuid()).toList();
    }
}
