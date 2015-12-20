'use strict';

app
    .factory('Bip', function ($resource, $filter) {
        
        return $resource('/resources/bips/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false,
                transformResponse: function (data) {
                data = angular.fromJson(data);
                data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                return data;}
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/resources/bips/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
