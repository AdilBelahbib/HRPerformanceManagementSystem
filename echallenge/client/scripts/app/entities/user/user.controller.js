'use strict';

app
    .controller('UserController', function ($scope, $stateParams, User) {
        console.log("Testing the rest API");
        
        $scope.users = User.query();

        console.log($scope.users);

        $scope.loadAll=function  () {
        	$scope.users = User.query();

        }

        $scope.addUser=function() {
        
                $('#addModal').modal('show');
        }

        $scope.showEditUser = function(user) {
        	console.log("edit modal...");
        	User.get({id:user.id}, function(result) {
                $scope.currentUser = result;
                
                $('#editModal').modal('show');
            });
        };

        $scope.EditUser = function() {
        	console.log("edit modal2...");
        	
        	 User.update({id: $scope.currentUser.id},$scope.currentUser , function(){
        	 $scope.loadAll();
        	$('#editModal').modal('hide'); 	
        	 });
        	
            
        };

        $scope.deleteUser=function  (user) {
        	  User.delete({id: user.id},
                function () {
                    $scope.loadAll();
                });
        }
        
        
         
    });
