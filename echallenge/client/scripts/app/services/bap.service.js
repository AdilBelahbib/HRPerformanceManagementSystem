    'use strict';

    app
    .factory('Bap', function ($resource, $filter) {

        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/baps/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false,
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                    return data;  }  
                },
                'collaborateur' : { 
                    method: 'GET',
                    isArray : true,
                    transformResponse: function (data) {
                        data = angular.fromJson(data);
                        data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                        return data;},
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/:id'
                    },
                    'bapByStatut' :
                    {
                     method: 'GET',
                     url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/:statut'
                 },
                 'bapCourant' :
                 {
                     method: 'GET',
                     transformResponse: function (data) {
                        data = angular.fromJson(data);
                        data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                        return data;},
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/EN_COURS'
                    },
                    'valider' : {
                        method : 'POST',
                        isArray:false,
                        url :'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/valider'
                    },
                    'update': { method:'PUT' },
                    'save': { method:'POST' }
                });
});
