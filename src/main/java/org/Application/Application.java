package org.Application;

import org.Application.Connection.Connection;
import org.Application.DTO.ParticipantDTO;
import org.Application.DTO.SummonerDTO;
import org.Application.Handlers.HandlerEntries;
import org.Application.Handlers.HandlerMatches;
import org.Application.Handlers.HandlerSummoners;
import org.Application.Model.ParticipantInfo;
import org.Application.Requests.Match;
import org.Application.Requests.Summoner;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Application {
	private static Integer cont=1;
	public static void main(String[] args) throws Exception {
		var start = LocalDateTime.now();
		var handlerSummoner = new HandlerSummoners();
		var handlerEntries = new HandlerEntries();
		var handlerMatches = new HandlerMatches();
		var players = new ArrayList<String>();
		players.addAll(List.of(new String[]{
							"jonjonlindo",
							"javeiro",
							"4thoctober",
							"mbdoesa",
							"shadowkatboll",
							"gnarultouuzumaki",
							"chimpas",
							"jonjonsacanagem"
		}));
		var summoners = handlerSummoner.getSummonersAll(players);

		var arrayLeagueEntryDTO = handlerEntries.getEntriesAll(summoners);
//
		var response = handlerEntries.getOnlyRankedQueue(arrayLeagueEntryDTO);

		//response.forEach(System.out::println);

		var allPuuid = handlerSummoner.returnAllPuuid(summoners);

//		for (String s : allPuuid) {
//			System.out.println(Match.getAllMatchesForSummoner(s));
//		}

		var matches = handlerMatches.getMatches(allPuuid);
		var end = LocalDateTime.now();

		matches.forEach((name, matchesList) -> {
			System.out.println("-----------------------------------------------------------");
			System.out.println(name);
			cont = 1;
			matchesList.forEach(match -> {
				try {
					System.out.println("Partida "+cont);
					var	participantInfo = new ParticipantInfo();
					var responseMatch = Match.getMatchInfo(match);
					List<ParticipantInfo> participantsInfo = participantInfo.fromMatchDTOToParticipantInfo(responseMatch, players);
					participantsInfo.forEach(participant -> {
						arrayLeagueEntryDTO.forEach(summoner -> {
							if (participant.getSummonerName().equalsIgnoreCase(summoner.getSummonerName())){
								System.out.println(summoner.getLeaguePoints().getClass());
								System.out.println(summoner.getRank() == "");
								if (summoner.getLeaguePoints().describeConstable().isEmpty() || summoner.getRank().describeConstable().isEmpty()){
									participant.setLeaguePoints(-1);
									participant.setRank("sem rank");
									participant.setTier("sem tier");
								} else {
									participant.setLeaguePoints(summoner.getLeaguePoints());
									participant.setRank(summoner.getRank());
									participant.setTier(summoner.getTier());
							}	}
						});
						//System.out.println(participant);
						Connection.saveParticipantInfo(participant);
					});

//					participantInfo.setGameDuration(responseMatch.info().gameDuration());
//
//					List<ParticipantDTO> participants = responseMatch.info().participants();
//					var instant = Instant.ofEpochMilli(responseMatch.info().gameStartTimestamp());
//					var localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//					System.out.println(localDateTime);
//					for (int i=0;i<participants.size();i++){
//
//						try {
//							System.out.println(Summoner.getSummonerByPuuid(participants.get(i).puuid()).name() +" | "+participants.get(i).championName()+" -> "+participants.get(i).kills()+"/"+participants.get(i).deaths()+"/"+participants.get(i).assists());
//						} catch (Exception e) {
//							throw new RuntimeException(e);
//						}
//						if (i == 4){
//							System.out.println();
//						}
//					}
					cont++;
					System.out.println("-----------------------------------------------------------");
					System.out.println();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});


		//Connection.saveParticipantInfo(new ParticipantInfo(null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,false,null,null,null,null,null,null));
		//Connection.saveParticipantInfo(new ParticipantInfo(1L));

		System.out.println("-----------------------------------------------------------");
		});



		Duration duration = Duration.between(start, end);
		System.out.println("Duração: "+duration.getSeconds()+" segundos e "+duration.getNano()+" ms.");
	}
}

