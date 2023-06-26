package org.Application;

import org.Application.DTO.SummonerDTO;
import org.Application.Handlers.HandlerEntries;
import org.Application.Handlers.HandlerMatches;
import org.Application.Handlers.HandlerSummoners;
import org.Application.Requests.Match;

import java.time.Duration;
import java.time.LocalDateTime;

public class Application {
	public static void main(String[] args) throws Exception {
		var start = LocalDateTime.now();
		var handlerSummoner = new HandlerSummoners();
		var handlerEntries = new HandlerEntries();
		var handlerMatches = new HandlerMatches();

		var summoners = handlerSummoner.getSummonersAll(new String[]{"jonjonlindo",
														"javeiro",
														"4thoctober",
														"mbdoesa",
														"shadowkatboll",
														"gnarultouuzumaki",
														"chimpas",
														"jonjonsacanagem",
														"mularodrigues",
														"pronect"});


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



			System.out.println("-----------------------------------------------------------");
		});

		String puuid = "";
		for (SummonerDTO summoner : summoners) {
			if (summoner.name().equalsIgnoreCase("jonjon lindo")){
				puuid = summoner.puuid();
			}
		}

		System.out.println(puuid);

		Duration duration = Duration.between(start, end);
		System.out.println("Duração: "+duration.getSeconds()+" segundos e "+duration.getNano()+" ms.");
	}
}

