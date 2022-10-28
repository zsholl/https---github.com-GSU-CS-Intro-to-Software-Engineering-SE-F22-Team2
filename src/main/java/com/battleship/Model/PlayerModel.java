package com.battleship.Model;
import java.util.ArrayList;

import com.battleship.DataAccess.PlayerDataAccess;
import com.battleship.DataObject.PlayerDataObject;
import com.battleship.DomainObject.PlayerDomainObject;
import com.battleship.restService.Message;


public class PlayerModel {
	
	public static PlayerDomainObject GetPlayerById(Message message, int id) {
		PlayerDataObject playerData = PlayerDataAccess.getPlayerById(id);
		PlayerDomainObject playerDomain = new PlayerDomainObject(playerData);
		return playerDomain;
	}

	public static ArrayList<PlayerDomainObject> GetAllPlayers(Message messasge) {
		ArrayList<PlayerDataObject> playerDataList = PlayerDataAccess.getAllPlayers();
		ArrayList<PlayerDomainObject> playerDomainList = PlayerDomainObject.MapList(playerDataList);
		return playerDomainList;
	}

	public static PlayerDomainObject RegisterPlayer(Message message, PlayerDomainObject domainPlayerToCreate) {
		//To Be Written

		return null;	
	}


}