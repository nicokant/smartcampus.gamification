// Edit game modal
function EditGameModalInstanceCtrl($scope, $modalInstance, game, gamesFactory) {
  $scope.newGame = {};
  $scope.newGame.name = game.name;

  // Error alerts object
  $scope.alerts = {
    'editGameError': ''
  };

  $scope.closeAlert = function (alertName) {
    $scope.alerts[alertName] = '';
  }

  // OK button click event-handler
  $scope.ok = function () {
    // Edit game
    gamesFactory.editGame(game, $scope.newGame.name).then(
      function () {
        // Settings edited
        $modalInstance.close();
      },
      function (message) {
        // Show given error alert
        $scope.alerts.editGameError = message;
      }
    );
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Delete game modal
function DeleteGameConfirmModalInstanceCtrl($scope, $modalInstance, $window, game, gamesFactory) {
  $scope.argument = game.name;

  // DELETE button click event-handler
  $scope.delete = function () {
    // Delete game
    gamesFactory.deleteGame(game).then(function () {
      // Game has been deleted
      // Redirect to homepage
      $window.location.href = '#/home';
      $modalInstance.close();
    });
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  }
}

// Delete instance modal
function DeleteInstanceConfirmModalInstanceCtrl($scope, $modalInstance, $window, game, instance, instanceType, gamesFactory) {
  $scope.argument = instance.name;

  // DELETE button click event-handler
  $scope.delete = function () {
    gamesFactory.deleteInstance(game, instance, instanceType).then(function () {
      // Instance has been deleted
      // Redirect to homepage
      $window.location.href = '#/game/' + game.id;
      $modalInstance.close();
    });
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Edit points instance modal
function EditPointsInstanceModalInstanceCtrl($scope, $modalInstance, game, instance, gamesFactory) {
  $scope.points = {};
  $scope.points.name = instance.name;
  // $scope.points.typology = instance.typology || 'Skill points';

  // Error alerts object
  $scope.alerts = {
    'editInstanceError': ''
  };

  $scope.closeAlert = function (alertName) {
    $scope.alerts[alertName] = '';
  }

  // Functions to manage dropdown button

  $scope.dropdown = {
    isOpen: false
  };

  $scope.toggleDropdown = function ($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.dropdown.isOpen = !$scope.dropdown.isOpen;

  };

  $scope.setTypology = function (type, $event) {
    $scope.points.typology = type;
    $scope.toggleDropdown($event);
  };

  // SAVE button click event-handler
  $scope.save = function () {
    gamesFactory.editInstance(game, instance, 'points', $scope.points).then(function () {
      // Points instance edited
      $modalInstance.close();
    }, function (message) {
      // Show error alert
      $scope.alerts.editInstanceError = message;
    });
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Edit badges collection instance modal
function EditBadgesCollectionInstanceModalInstanceCtrl($scope, $modalInstance, game, instance, gamesFactory) {
  $scope.badges_collection = {};
  $scope.badges_collection.name = instance.name;

  // Error alerts object
  $scope.alerts = {
    'editInstanceError': ''
  };

  $scope.closeAlert = function (alertName) {
    $scope.alerts[alertName] = '';
  };

  // SAVE button click event-handler
  $scope.save = function () {
    gamesFactory.editInstance(game, instance, 'badges_collections', $scope.badges_collection).then(function () {
      // Badges collection instance edited
      $modalInstance.close();
    }, function (message) {
      // Show error alert
      $scope.alerts.editInstanceError = message;
    });
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Edit leaderboard instance modal
function EditLeaderboardInstanceModalInstanceCtrl($scope, $modalInstance, game, instance, gamesFactory) {
  $scope.leaderboard = {};
  $scope.leaderboard.name = instance.name;
  $scope.leaderboard.points_dependency = instance.points_dependency || game.instances.points[0].name;
  $scope.leaderboard.update_rate = instance.update_rate || 'Weekly';

  $scope.gamePoints = game.instances.points;

  // Error alerts object
  $scope.alerts = {
    'editInstanceError': ''
  };

  $scope.closeAlert = function (alertName) {
    $scope.alerts[alertName] = '';
  }

  // Functions to manage dropdown buttons

  $scope.dropdownPointsDependency = {
    isOpen: false
  };

  $scope.toggleDropdownPointsDependency = function ($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.dropdownPointsDependency.isOpen = !$scope.dropdownPointsDependency.isOpen;

  }

  $scope.setPointsDependency = function (pointsDependency, $event) {
    $scope.leaderboard.points_dependency = pointsDependency;
    $scope.toggleDropdownPointsDependency($event);
  };

  $scope.dropdownUpdateRate = {
    isOpen: false
  };

  $scope.toggleDropdownUpdateRate = function ($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.dropdownUpdateRate.isOpen = !$scope.dropdownUpdateRate.isOpen;

  }

  $scope.setUpdateRate = function (updateRate, $event) {
    $scope.leaderboard.update_rate = updateRate;
    $scope.toggleDropdownUpdateRate($event);
  };

  // SAVE button click event-handler
  $scope.save = function () {
    gamesFactory.editInstance(game, instance, 'leaderboards', $scope.leaderboard).then(function () {
      // Leaderboard instance edited
      $modalInstance.close();
    }, function (message) {
      // Show error alert
      $scope.alerts.editInstanceError = message;
    });
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Poins activation confirmation modal
function ActivatePointsConfirmModalInstanceCtrl($scope, $modalInstance, points) {
  $scope.argument = points.name;

  // ACTIVE button click event-handler
  $scope.active = function () {
    points.is_active = true;
    $modalInstance.close();
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Linked leaderboards deactivation confirmation modal
function DeactivateLeaderboardsConfirmModalInstanceCtrl($scope, $modalInstance, leaderboards, gamesFactory) {
  $scope.leaderboards = leaderboards;

  // DEACTIVE button click event-handler
  $scope.deactive = function () {
    // Call the function to deactive all the linked leaderboards
    gamesFactory.deactivateLeaderboards(leaderboards);
    $modalInstance.close();
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Linked leaderboards delete confirmation modal
function DeleteLeaderboardsConfirmModalInstanceCtrl($scope, $modalInstance, game, leaderboards, gamesFactory) {
  $scope.leaderboards = leaderboards;

  // DELETE button click event-handler
  $scope.delete = function () {
    // Call the function to delete all the linked leaderboards
    gamesFactory.deleteLeaderboards(game, leaderboards);
    $modalInstance.close();
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Edit badges modal
function EditBadgesModalInstanceCtrl($scope, $modalInstance, gamesFactory) {
  // TODO: complete add / edit badges operations!

  // SAVE button click event-handler
  $scope.save = function () {
    $modalInstance.close();
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Edit rule modal
function EditRuleModalInstanceCtrl($scope, $modalInstance, gamesFactory) {
  // TODO: complete add / edit rule operations!

  // DELETE button click event-handler
  $scope.save = function () {
    // TODO: edit rule!
    $modalInstance.close();
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

// Delete rule modal
function DeleteRuleConfirmModalInstanceCtrl($scope, $modalInstance, argument, gamesFactory) {
  $scope.argument = argument;

  // DELETE button click event-handler
  $scope.delete = function () {
    // TODO: delete rule!
    $modalInstance.close();
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}

function EditActionModalInstanceCtrl($scope, $modalInstance, gamesFactory, game,action) {
	$scope.input = {};
	$scope.ok = function() {
	
		if( !! $scope.input.actionName && $scope.input.actionName.length > 0){
				game.actions.push($scope.input.actionName);
			}
			
		gamesFactory.saveGame(game).then(
      function () {
        // Settings edited
	        $modalInstance.close();
	      },
	      function (message) {
	        // Show given error alert
	        // $scope.alerts.editGameError = message;
	    	 alert('error');
	      }
	    );
	};
	
	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
}

// Delete action modal
function DeleteActionConfirmModalInstanceCtrl($scope, $modalInstance, argument, game, gamesFactory) {
  $scope.argument = argument;

  // DELETE button click event-handler
  $scope.delete = function () {
	var idx = game.actions.indexOf(argument);
	if(idx !== -1) {
		game.actions.splice(idx,1);
	}
	
	 
	gamesFactory.saveGame(game).then(
		function () {
			$modalInstance.close();
	  	      },
	  	      function (message) {
	  	    
	  	      }
	  	    );
  };

  // CANCEL button click event-handler
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
}
