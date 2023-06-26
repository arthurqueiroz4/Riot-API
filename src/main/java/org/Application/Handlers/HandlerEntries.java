package org.Application.Handlers;

import com.google.gson.Gson;
import org.Application.DTO.LeagueEntryDTO;
import org.Application.DTO.SummonerDTO;
import org.Application.Requests.Entry;

import java.util.ArrayList;
import java.util.List;

public class HandlerEntries {
    private Gson gson = new Gson();
    public List<LeagueEntryDTO> getEntriesAll(List<SummonerDTO> summoners) throws Exception {
        List<LeagueEntryDTO> arrayLeagueEntryDTO = new ArrayList<>();
        for (SummonerDTO summonerDTO : summoners) {
            arrayLeagueEntryDTO.addAll(Entry.getEntries(summonerDTO.id()));
        }
        return arrayLeagueEntryDTO;
    }

    public List<String> getOnlyRankedQueue(List<LeagueEntryDTO> arrayLeagueEntryDTO){
        List<String> jsonResponse = new ArrayList<>();
        arrayLeagueEntryDTO.forEach(entry -> {
            if (entry.getQueueType().equalsIgnoreCase("RANKED_SOLO_5X5")){
                jsonResponse.add(gson.toJson(entry));
            }
        });
        return jsonResponse;
    }
}
