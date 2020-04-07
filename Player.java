package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String userName;
    private int password;

    @OneToMany(mappedBy="playerPlay", fetch=FetchType.EAGER)

    @Fetch(value = FetchMode.SUBSELECT)
    private List<GamePlayer> gamePlayers = new ArrayList<>();

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)

    public long getId() {
        return id;
    }

    @JsonIgnore
    public List<GamePlayer> getGamePlayers() {
       return gamePlayers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player (String email, int password) {
        this.userName = email;
        this.password = password;
    }

    public void setGamePlayers(List<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public Player() {}

    public String toString() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    public void addGamePlay(GamePlayer gamePlayer) {
        gamePlayer.setPlayer(this);
        gamePlayers.add(gamePlayer);
    }

    public Map<String, Object> toDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", this.getId());
        dto.put("email", this.getUserName());
        return dto;
    }
}