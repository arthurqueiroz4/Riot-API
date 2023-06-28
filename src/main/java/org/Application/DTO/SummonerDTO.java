package org.Application.DTO;

public record SummonerDTO(
        String accountId,
        Integer profileIconId,
        Long revisionDate,
        String name,
        String id,
        String puuid,
        Long summonerLevel
) {

}
