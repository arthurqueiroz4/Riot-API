package org.Application.DTO;

public record ParticipantDTO(
        Integer assists,
        Integer baronKills,
        Integer bountyLevel,
        Integer champsExperience,
        Integer champLevel,
        Integer championId,
        String championName,
        Integer championTransform,
        Integer consumablesPurchased,
        Integer damageDealtToBuildings,
        Integer damageDealtToObjectives,
        Integer damageDealtToTurrets,
        Integer damageSelfMitigated,
        Integer deaths,
        Integer detectorWardsPlaced,
        Integer doubleKills,
        Integer dragonKills,
        boolean firstBloodAssist,
        boolean firstBloodKill,
        boolean firstTowerAssist,
        boolean firstTowerKill,
        boolean gameEndedInEarlySurrender,
        boolean gameEndedInSurrender,
        Integer goldEarned,
        Integer goldSpent,
        String individualPosition,
        Integer inhibitorKills,
        Integer inhibitorTakedowns,
        Integer inhibitorsLost,
        Integer item0,
        Integer item1,
        Integer item2,
        Integer item3,
        Integer item4,
        Integer item5,
        Integer item6,
        Integer itemsPurchased,
        Integer killingSprees,
        Integer kills,
        String lane,
        Integer largestCriticalStrike,
        Integer largestKillingSpree,
        Integer largestMultiKill,
        Integer longestTimeSpentLiving,
        Integer magicDamageDealt,
        Integer magicDamageDealtToChampions,
        Integer magicDamageTaken,
        Integer neutralMinionsKilled,
        Integer nexusKills,
        Integer nexusTakedowns,
        Integer nexusLost,
        Integer objectivesStolen,
        Integer objectivesStolenAssists,
        Integer participantId,
        Integer pentaKills,
        PerksDTO perks,
        Integer physicalDamageDealt,
        Integer physicalDamageDealtToChampions,
        Integer physicalDamageTaken,
        Integer profileIcon,
        String puuid,
        Integer quadraKills,
        String riotIdName,
        String riotIdTagline,
        String role,
        Integer sightWardsBoughtInGame,
        Integer spell1Casts,
        Integer spell2Casts,
        Integer spell3Casts,
        Integer spell4Casts,
        Integer summoner1Casts,
        Integer summoner1Id,
        Integer summoner2Casts,
        Integer summoner2Id,
        String summonerId,
        Integer summonerLevel,
        String summonerName,
        boolean teamEarlySurrendered,
        Integer teamId,
        String teamPosition,
        Integer timeCCingOthers,
        Integer timePlayed,
        Integer totalDamageDealt,
        Integer totalDamageDealtToChampions,
        Integer totalDamageShieldedOnTeammates,
        Integer totalDamageTaken,
        Integer totalHeal,
        Integer totalHealsOnTeammates,
        Integer totalMinionsKilled,
        Integer totalTimeCCDealt,
        Integer totalTimeSpentDead,
        Integer totalUnitsHealed,
        Integer tripleKills,
        Integer trueDamageDealt,
        Integer trueDamageDealtToChampions,
        Integer trueDamageTaken,
        Integer turretKills,
        Integer turretTakedowns,
        Integer turretsLost,
        Integer unrealKills,
        Integer visionScore,
        Integer visionWardsBoughtInGame,
        Integer wardsKilled,
        Integer wardsPlaced,
        boolean win
) {
}
