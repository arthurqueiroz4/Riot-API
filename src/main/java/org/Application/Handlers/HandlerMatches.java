package org.Application.Handlers;

import org.Application.DTO.LeagueEntryDTO;
import org.Application.Model.ParticipantInfo;
import org.Application.Requests.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerMatches {
    private HandlerSummoners handlerSummoners = new HandlerSummoners();

    public Map<String, List<String>> getMatches(List<String> puuids) throws Exception {
        Map<String, List<String>> matches = new HashMap<>();
        List<String> summonersName = new ArrayList<>();
        for (String puuid : puuids) {
            summonersName.add(handlerSummoners.getSummoner(puuid).name());
        }
        if (summonersName.size() == puuids.size()){
            for (int i=0; i < summonersName.size(); i++){
                matches.put(summonersName.get(i), Match.getAllMatchesForSummoner(puuids.get(i),100));
            }
        } else {
            System.out.println("aqui fodeu");
        }
        return matches;
    }

    public static boolean playerIsInMatch(LeagueEntryDTO entries, ParticipantInfo participant) {
        return participant.getSummonerName().equalsIgnoreCase(entries.getSummonerName());
    }

    public static void setEntriesCampsInParticipant(ParticipantInfo participant, LeagueEntryDTO entries){
        participant.setLeaguePoints(entries.getLeaguePoints());
        participant.setRank(entries.getRank());
        participant.setTier(entries.getTier());
    }

    public static boolean matchIsRankedSoloDuo(LeagueEntryDTO entries){
        return entries.getQueueType().equalsIgnoreCase("RANKED_SOLO_5x5");
    }

}
