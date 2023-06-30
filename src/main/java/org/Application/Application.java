package org.Application;

import org.Application.Connection.ConnectionDB;
import org.Application.Handlers.HandlerEntries;
import org.Application.Handlers.HandlerMatches;
import org.Application.Handlers.HandlerSummoners;
import org.Application.Model.ParticipantInfo;
import org.Application.Requests.Match;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.Application.Handlers.HandlerMatches.*;

public class Application {
	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando programa...");
		var start = System.currentTimeMillis();
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

		var response = handlerEntries.getOnlyRankedQueue(arrayLeagueEntryDTO);

		var allPuuid = handlerSummoner.returnAllPuuid(summoners);



		var matches = handlerMatches.getMatches(allPuuid);

		AtomicReference<Integer> cont = new AtomicReference<>(new Integer(1));
		matches.forEach((name, matchesList) -> {
			matchesList.forEach(match -> {
				try {
					var	participantInfo = new ParticipantInfo();
					var responseMatch = Match.getMatchInfo(match);
					List<ParticipantInfo> participantsInfo = participantInfo.fromMatchDTOToParticipantInfo(responseMatch, players);
					participantsInfo.forEach(participant -> {
						arrayLeagueEntryDTO.forEach(entries -> {
							if (playerIsInMatch(entries, participant) && matchIsRankedSoloDuo(entries)){
								setEntriesCampsInParticipant(participant, entries);
								System.out.println(LocalDateTime.now().toString() +" - "+cont+" salvo(s) no banco");
								ConnectionDB.saveParticipantInfo(participant);
								cont.getAndSet(cont.get() + 1);
							}
						});

					});
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
		});


		var end = System.currentTimeMillis();
		Long duration = end-start;
		System.out.println("Duração: "+duration/1000+" segundos.");
	}
}

