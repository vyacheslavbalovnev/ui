angular.module('controller', [])
.controller('Controller', function($scope, $http) {

    $scope.color = {
        name: 'blue'
      };
    $http.get('/greeting').
        then(function(response) {
            $scope.greeting = response.data;

        });
});
