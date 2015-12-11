app.directive('navbar', function () {
return {
	restrict: 'A',
        scope: {
            navbar: '='
        },
    templateUrl: function(elem, attr){
    	 

      return 'scripts/app/partials/navbar-'+"c"+'.partial.html';
    
      
    }
  };
})