package eu.trentorise.game.controller;

import eu.trentorise.game.profile.service.IGameProfileManager;
import eu.trentorise.game.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Luca Piras
 */
@Controller("gameProfileController")
@RequestMapping(IGameConstants.SERVICE_GAME_PROFILE)
public class GameProfileController {

    @RequestMapping(method = RequestMethod.GET, value = "/activateDeactivatePlugin" + IGameConstants.SERVICE_SEPARATOR_PLUS_EXTENSION)
    public @ResponseBody SuccessResponse activateDeactivatePlugin(@RequestParam(value = "gameProfileId", required = true) Integer gameProfileId,
                                                                  @RequestParam(value = "gamificationPluginId", required = true) Integer gamificationPluginId,
                                                                  @RequestParam(value = "active", required = true) boolean active) {
        
        return manager.activateDeactivatePlugin(null);
    }
    
    @Qualifier("mockGameProfileManager")
    @Autowired
    protected IGameProfileManager manager;
}