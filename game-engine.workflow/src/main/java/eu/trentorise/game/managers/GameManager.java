package eu.trentorise.game.managers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import eu.trentorise.game.core.AppContextProvider;
import eu.trentorise.game.core.GameContext;
import eu.trentorise.game.core.GameTask;
import eu.trentorise.game.core.TaskSchedule;
import eu.trentorise.game.model.Game;
import eu.trentorise.game.repo.GamePersistence;
import eu.trentorise.game.repo.GameRepo;
import eu.trentorise.game.services.GameService;
import eu.trentorise.game.services.TaskService;
import eu.trentorise.game.task.ClassificationTask;

@Component
public class GameManager implements GameService {

	private final Logger logger = LoggerFactory.getLogger(GameManager.class);

	private static Map<String, String> repo;

	@Autowired
	@Qualifier("quartzTaskManager")
	// @Qualifier("taskManager")
	TaskService taskManager;

	@Autowired
	AppContextProvider provider;

	@Autowired
	GameRepo gameRepo;

	@PostConstruct
	@SuppressWarnings("unused")
	private void initRepo() {
		repo = new HashMap<String, String>();
		repo.put("save_itinerary", "game1");
		repo.put("classification", "game1");

		String gameId = "game1";
		// init game1 for dev purpose
		if (loadGameDefinitionById(gameId) == null) {
			Game game = new Game();
			game.setId(gameId);
			game.setName("rovereto explorer");

			game.setActions(new HashSet<String>());
			game.getActions().add("save_itinerary");
			game.getActions().add("classification");

			game.setTasks(new HashSet<GameTask>());

			// final classifications
			TaskSchedule schedule = new TaskSchedule();
			schedule.setCronExpression("0 5 * * * *");
			ClassificationTask task1 = new ClassificationTask(schedule, 3,
					"green leaves", "final classification green");
			game.getTasks().add(task1);

			ClassificationTask task2 = new ClassificationTask(schedule, 3,
					"health", "final classification health");
			game.getTasks().add(task2);

			ClassificationTask task3 = new ClassificationTask(schedule, 3,
					"p+r", "final classification p+r");
			game.getTasks().add(task3);

			// week classifications
			schedule = new TaskSchedule();
			schedule.setCronExpression("0 0 * * * *");
			ClassificationTask task4 = new ClassificationTask(schedule, 1,
					"green leaves", "week classification green");
			game.getTasks().add(task4);

			ClassificationTask task5 = new ClassificationTask(schedule, 1,
					"health", "week classification health");
			game.getTasks().add(task5);

			ClassificationTask task6 = new ClassificationTask(schedule, 1,
					"p+r", "week classification p+r");
			game.getTasks().add(task6);

			saveGameDefinition(game);
			logger.debug("created game {}", gameId);
		} else {
			logger.debug("found game {}", gameId);
		}
	}

	public String getGameIdByAction(String actionId) {
		return repo.get(actionId);
	}

	public void startupTasks(String gameId) {
		Game game = loadGameDefinitionById(gameId);
		if (game != null) {
			for (GameTask task : game.getTasks()) {
				taskManager.createTask(task, (GameContext) provider
						.getApplicationContext().getBean("gameCtx", gameId));
			}
		}

	}

	public void saveGameDefinition(Game game) {
		gameRepo.save(new GamePersistence(game));
	}

	public Game loadGameDefinitionById(String gameId) {
		GamePersistence gp = gameRepo.findOne(gameId);
		return gp == null ? null : gp.toGame();
	}
}
