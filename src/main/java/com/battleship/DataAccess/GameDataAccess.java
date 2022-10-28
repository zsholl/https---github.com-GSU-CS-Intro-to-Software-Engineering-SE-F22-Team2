package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.GameDataObject;

public class GameDataAccess {

	private static ArrayList<GameDataObject> games;

	public GameDataAccess() {
		initialize();
	}

	private void initialize() {
		games = new ArrayList<GameDataObject>();
	
		//Default Data
		games.add( new GameDataObject (getNextId(), 1, 1, -1, "Play Game", 1, 2, 1, 2));
	}

	private static int getNextId() {
		return games.size()+1;
	}

	public static ArrayList<GameDataObject> getAllGames() {
		return games;
	}

	public static GameDataObject getGameById(int Id) {
		
		for (int i=0; i < games.size(); i++) {
			if (games.get(i).Id == Id) {
				return games.get(i);
			}
		}
		
		return null;
	}

	public static GameDataObject createGame(GameDataObject data) {
		//To Be Written
		return null;
	}

	public static GameDataObject SetBoardForPlayerAndGame(int gameId, int playerId, int boardId) {
		//To Be Written
		return null;
	}

}