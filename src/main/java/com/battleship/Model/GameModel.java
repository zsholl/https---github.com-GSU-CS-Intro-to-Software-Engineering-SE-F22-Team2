package com.battleship.Model;
import java.util.ArrayList;

import com.battleship.DataAccess.BoardDataAccess;
import com.battleship.DataAccess.GameDataAccess;
import com.battleship.DataAccess.ShipDataAccess;
import com.battleship.DataAccess.SpaceDataAccess;
import com.battleship.DataObject.BoardDataObject;
import com.battleship.DataObject.GameDataObject;
import com.battleship.DataObject.ShipDataObject;
import com.battleship.DataObject.SpaceDataObject;
import com.battleship.DomainObject.BoardDomainObject;
import com.battleship.DomainObject.GameDomainObject;
import com.battleship.DomainObject.GameTypeDomainObject;
import com.battleship.DomainObject.ShipDomainObject;
import com.battleship.DomainObject.SpaceDomainObject;
import com.battleship.restService.Message;


public class GameModel {
	

	public static ArrayList<GameDomainObject> GetAllGameSummaries(Message message) {
		ArrayList<GameDataObject> gameDataList = GameDataAccess.getAllGames();
		ArrayList<GameDomainObject> gameDomainList = GameDomainObject.MapList(gameDataList);
		return gameDomainList;
	}

	public static GameDomainObject GetGameDetailsByGameIdandPlayerId(Message message, int gameId, int playerId) throws Exception {
		//Get the Game Details
		GameDataObject gameData = GameDataAccess.getGameById(gameId);
		GameDomainObject gameDomain = new GameDomainObject(gameData);

		boolean isPlayer1 = false;
		boolean isPlayer2 = false;

		if (playerId == gameDomain.Player1Id)
			isPlayer1 = true;
		else if (playerId == gameDomain.Player2Id)
			isPlayer2 = true;
		else {
			throw new Exception("Player " + playerId + " is not part of this game");
		}
		//Get the Board Details for Player 1 
		if (gameDomain.Board1Id > 0){
			BoardDomainObject board1Data = BoardModel.GetBoardDetailsById(message, gameDomain.Board1Id);
			gameDomain.Board1 = board1Data;
			if (isPlayer2) {
				gameDomain.Board1.ships = null;
			}
		}
		//Get the Board Details for Player 2 
		if (gameDomain.Board2Id > 0){
			BoardDomainObject board2Data = BoardModel.GetBoardDetailsById(message, gameDomain.Board2Id);
			gameDomain.Board2 = board2Data;
			if (isPlayer1) {
				gameDomain.Board2.ships = null;
			}
		}

		return gameDomain;
	}


	public static GameDomainObject GetGameById(Message message, int id) {
		GameDataObject gameData = GameDataAccess.getGameById(id);
		GameDomainObject gameDomain = new GameDomainObject(gameData);
		return gameDomain;
	}


	public static GameDomainObject CreateGame(Message message, GameDomainObject domainGameToCreate) {
		//To Be Written
		return null;
	}

	public static GameDomainObject SetShips(Message message, int gameId, int playerId, ArrayList<ShipDomainObject> ships) {
		//To Be Written
		return null;
	}
	
	public static GameDomainObject TakeTurn(Message message, int gameId, int playerId, int column, int row) throws Exception {
		//To Be Written
		return null;
	}

}