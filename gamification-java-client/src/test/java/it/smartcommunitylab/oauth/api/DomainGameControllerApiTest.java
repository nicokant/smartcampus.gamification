/**
 * Copyright 2018-2019 SmartCommunity Lab(FBK-ICT).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
 * Gamification Engine API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.smartcommunitylab.oauth.api;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import it.smartcommunitylab.ApiException;
import it.smartcommunitylab.model.GameDTO;
import it.smartcommunitylab.model.LevelDTO;

/**
 * API tests for DomainGameControllerApi
 */
@Ignore
public class DomainGameControllerApiTest {

    private final DomainGameControllerApi api = new DomainGameControllerApi();

    
    /**
     * Add action
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addActionUsingPOSTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        api.addActionUsingPOST(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Delete action
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteActionUsingDELETETest() throws ApiException {
        String domain = null;
        String gameId = null;
        String actionId = null;
        api.deleteActionUsingDELETE(domain, gameId, actionId);

        // TODO: test validations
    }
    
    /**
     * Delete game
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteGameUsingDELETE1Test() throws ApiException {
        String domain = null;
        String gameId = null;
        api.deleteGameUsingDELETE1(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Delete a level
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteLevelUsingDELETETest() throws ApiException {
        String gameId = null;
        String levelName = null;
        Boolean response = api.deleteLevelUsingDELETE(gameId, levelName);

        // TODO: test validations
    }
    
    /**
     * Edit action
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void editActionUsingPUTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        api.editActionUsingPUT(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Get action
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readActionUsingGETTest() throws ApiException {
        String domain = null;
        String gameId = null;
        api.readActionUsingGET(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Get actions
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readAllActionUsingGETTest() throws ApiException {
        String domain = null;
        String gameId = null;
        List<String> response = api.readAllActionUsingGET(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Read game definition
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readGameUsingGET1Test() throws ApiException {
        String domain = null;
        String gameId = null;
        GameDTO response = api.readGameUsingGET1(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Get games
     *
     * Get all the game definitions of a user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readGamesUsingGET1Test() throws ApiException {
        String domain = null;
        List<GameDTO> response = api.readGamesUsingGET1(domain);

        // TODO: test validations
    }
    
    /**
     * Save a game
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void saveGameUsingPOST2Test() throws ApiException {
        String domain = null;
        GameDTO game = null;
        GameDTO response = api.saveGameUsingPOST2(domain, game);

        // TODO: test validations
    }
    
    /**
     * Save a level
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void saveLevelUsingPOSTTest() throws ApiException {
        String gameId = null;
        LevelDTO level = null;
        LevelDTO response = api.saveLevelUsingPOST(gameId, level);

        // TODO: test validations
    }
    
    /**
     * Start game
     *
     * The game is able to accept action executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void startGameUsingPUTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        api.startGameUsingPUT(domain, gameId);

        // TODO: test validations
    }
    
    /**
     * Stop a game
     *
     * The game will not accept action execution anymore
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void stopGameUsingPUTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        api.stopGameUsingPUT(domain, gameId);

        // TODO: test validations
    }
    
}