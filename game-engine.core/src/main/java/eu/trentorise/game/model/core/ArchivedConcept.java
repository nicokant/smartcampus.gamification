package eu.trentorise.game.model.core;

import java.util.Date;

import eu.trentorise.game.model.ChallengeConcept;

public class ArchivedConcept {
    private String id;
    private String gameId;
    private String playerId;
    private ChallengeConcept challenge;
    private Date archivingDate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public ChallengeConcept getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeConcept challenge) {
        this.challenge = challenge;
    }

    public Date getArchivingDate() {
        return archivingDate;
    }

    public void setArchivingDate(Date archivingDate) {
        this.archivingDate = archivingDate;
    }



}
