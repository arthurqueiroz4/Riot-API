package org.Application.DTO;

import java.util.List;

public record InfoDTO(
        Long gameCreation,
        Long gameDuration,
        Long gameEndTimestamp,
        Long gameId,
        String gameMode,
        String gameName,
        Long gameStartTimestamp,
        String gameType,
        String gameVersion,
        Integer mapId,
        List<ParticipantDTO> participants,
        String platformId,
        Integer queueId,
        List<TeamDTO> teams,
        String tournamentCode
) {
}
