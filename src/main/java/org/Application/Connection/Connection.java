package org.Application.Connection;

import org.Application.Model.ParticipantInfo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connection {
    private static String url = "jdbc:postgresql://localhost:5432/riot-api";
    private static String user = "postgres";
    private static String password = "admin";
    private static java.sql.Connection connection = null;
    static {
        conectar();
    }

    public Connection() {
        conectar();
    }

    private static void conectar() {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static java.sql.Connection getConnection() {
        return connection;
    }

    public static void saveParticipantInfo(ParticipantInfo participantInfo){
        String sql = "INSERT INTO game_stats (gameDuration, summonerLevel, kills, assists, " +
                "deaths, win, champLevel, championName, lane, role, doubleKills, tripleKills," +
                " pentaKills, dragonKills, firstBloodKill, trueDamageDealtToChampions," +
                " gameEndedInSurrender, wardsPlaced, visionScore, goldEarned," +
                " neutralMinionsKilled, leaguePoints, rank, summonerName) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,participantInfo.getGameDuration());
            statement.setInt(2,participantInfo.getSummonerLevel());
            statement.setInt(3,participantInfo.getKills());
            statement.setInt(4,participantInfo.getAssists());
            statement.setInt(5,participantInfo.getDeaths());
            statement.setBoolean(6, participantInfo.isWin());
            statement.setInt(7,participantInfo.getChampLevel());
            statement.setString(8,participantInfo.getChampionName());
            statement.setString(9,participantInfo.getLane());
            statement.setString(10, participantInfo.getRole());
            statement.setInt(11,participantInfo.getDragonKills());
            statement.setInt(12,participantInfo.getTripleKills());
            statement.setInt(13,participantInfo.getPentaKills());
            statement.setInt(14,participantInfo.getDragonKills());
            statement.setBoolean(15, participantInfo.isFirstBloodKill());
            statement.setInt(16,participantInfo.getTrueDamageDealtToChampions());
            statement.setBoolean(17, participantInfo.isGameEndedInSurrender());
            statement.setInt(18,participantInfo.getWardsPlaced());
            statement.setInt(19,participantInfo.getVisionScore());
            statement.setInt(20,participantInfo.getGoldEarned());
            statement.setInt(21,participantInfo.getNeutralMinionsKilled());
            statement.setInt(22,participantInfo.getLeaguePoints());
            statement.setString(23, participantInfo.getRank());
            statement.setString(24, participantInfo.getSummonerName());
            statement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

