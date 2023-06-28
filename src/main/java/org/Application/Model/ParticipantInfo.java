package org.Application.Model;

import lombok.*;
import org.Application.DTO.MatchDTO;
import org.Application.DTO.ParticipantDTO;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
public class ParticipantInfo {
    private Long gameDuration;
    private Integer summonerLevel;
    private Integer kills;
    private Integer assists;
    private Integer deaths;
    private boolean win;
    private Integer champLevel;
    private String championName;
    private String lane;
    private String role;
    private Integer doubleKills;
    private Integer tripleKills;
    private Integer pentaKills;
    private Integer dragonKills;
    private boolean firstBloodKill;
    private Integer trueDamageDealtToChampions;
    private boolean gameEndedInSurrender;
    private Integer wardsPlaced;
    private Integer visionScore;
    private Integer goldEarned;
    private Integer neutralMinionsKilled;
    //private Integer dragon;
    private Integer leaguePoints;
    private String rank;
    private String summonerName;
    private String tier;

    public List<ParticipantInfo> fromMatchDTOToParticipantInfo(MatchDTO matchDTO, List<String> players){
        List<ParticipantDTO> participants = new ArrayList<>(matchDTO.info().participants().size());
        participants.addAll(matchDTO.info().participants());
        List<ParticipantInfo> response = new ArrayList<>();

        var info = matchDTO.info();
        for (ParticipantDTO participantDTO : participants) {
            if (players.contains(participantDTO.summonerName().toLowerCase().replace(" ",""))) {
                var participant = new ParticipantInfo();

                participant.setGameDuration(info.gameDuration());
                participant.setSummonerLevel(participantDTO.summonerLevel());
                participant.setKills(participantDTO.kills());
                participant.setAssists(participantDTO.assists());
                participant.setDeaths(participantDTO.deaths());
                participant.setWin(participantDTO.win());
                participant.setChampLevel(participantDTO.champLevel());
                participant.setChampionName(participantDTO.championName());
                participant.setLane(participantDTO.lane());
                participant.setRole(participantDTO.role());
                participant.setDoubleKills(participantDTO.doubleKills());
                participant.setTripleKills(participantDTO.tripleKills());
                participant.setPentaKills(participantDTO.pentaKills());
                participant.setDragonKills(participantDTO.dragonKills());
                participant.setFirstBloodKill(participantDTO.firstBloodKill());
                participant.setTrueDamageDealtToChampions(participantDTO.trueDamageDealtToChampions());
                participant.setGameEndedInSurrender(participantDTO.gameEndedInSurrender());
                participant.setWardsPlaced(participantDTO.wardsPlaced());
                participant.setVisionScore(participantDTO.visionScore());
                participant.setGoldEarned(participantDTO.goldEarned());
                participant.setNeutralMinionsKilled(participantDTO.neutralMinionsKilled());
                //participant.setDragon(info.teams().);
                participant.setSummonerName(participantDTO.summonerName());

                response.add(participant);
            } else {
                continue;
            }
        }

        return response;
    }
}
