package org.Application;

import org.Application.DTO.ParticipantDTO;
import org.Application.DTO.SummonerDTO;
import org.Application.Handlers.HandlerEntries;
import org.Application.Handlers.HandlerMatches;
import org.Application.Handlers.HandlerSummoners;
import org.Application.Requests.Match;
import org.Application.Requests.Summoner;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class Application {
	private static Integer cont=1;
	public static void main(String[] args) throws Exception {
		var start = LocalDateTime.now();
		var handlerSummoner = new HandlerSummoners();
		var handlerEntries = new HandlerEntries();
		var handlerMatches = new HandlerMatches();

		var summoners = handlerSummoner.getSummonersAll(new String[]{"jonjonlindo"
//														"javeiro",
//														"4thoctober",
//														"mbdoesa",
//														"shadowkatboll",
//														"gnarultouuzumaki",
//														"chimpas",
//														"jonjonsacanagem",
//														"mularodrigues",
//														"pronect"
														});

		String puuid = "";
		for (SummonerDTO summoner : summoners) {
			if (summoner.name().equalsIgnoreCase("jonjon lindo")){
				puuid = summoner.puuid();
			}
		}

		System.out.println(puuid);
		var arrayLeagueEntryDTO = handlerEntries.getEntriesAll(summoners);

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
					var responseMatch = Match.getMatchInfo(match);
					List<ParticipantDTO> participants = responseMatch.info().participants();
					var instant = Instant.ofEpochMilli(responseMatch.info().gameStartTimestamp());
					var localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
					System.out.println(localDateTime);
					for (int i=0;i<participants.size();i++){
						try {
							System.out.println(Summoner.getSummonerByPuuid(participants.get(i).puuid()).name() +" | "+participants.get(i).championName()+" -> "+participants.get(i).kills()+"/"+participants.get(i).deaths()+"/"+participants.get(i).assists());
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
						if (i == 4){
							System.out.println();
						}
					}
					cont++;
					System.out.println("-----------------------------------------------------------");
					System.out.println();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});



			System.out.println("-----------------------------------------------------------");
		});



		Duration duration = Duration.between(start, end);
		System.out.println("Duração: "+duration.getSeconds()+" segundos e "+duration.getNano()+" ms.");
	}
}

