angular.module('logClient', ['ngAnimate', 'ui.bootstrap']);
angular.module('logClient').controller('ctrl', function ($scope, $http) {
    $scope.messages = 'Hello World!!!';



    $scope.send = function(){
        var rand = Math.floor( Math.random()*10000 );
        $scope.log = {
            logDate : new Date(),
            logType: 'INFO',
            logRegister: 'Register1',
            atr1 : rand%20,
            atr2:'atr2 '+ rand%100,
            atr3:'atr3 '+ rand%50
        };
        $http.post("/ZST/rest/log", $scope.log)
            .success(function (response) {
                $scope.messages = response;
                $scope.getLogs();
            }).error(function (response) {
                console.log( response );
                $scope.messages = response;
            });
    };

    $scope.getLogs = function(){
        $http.get("/ZST/rest/log/all")
            .success(function(response){
                $scope.logs = response;
            }).error(function(error){
                console.log( error);
            });
    };
    $scope.getLogs();

    $scope.sortType     = 'id'; // set the default sort type
    $scope.sortReverse  = false;  // set the default sort order
    $scope.searchLog = '';     // set the default search/filter term

});