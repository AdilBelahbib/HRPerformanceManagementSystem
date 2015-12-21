    'use strict';

    app
    .factory('Bap', function ($resource, $filter) {

        return $resource('/HRPerformanceManagementSystem/resources/baps/:id', {}, {
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
                        url: '/HRPerformanceManagementSystem/resources/baps/collaborateur/:id'
                    },
                    'bapByStatut' :
                    {
                     method: 'GET',
                     url: '/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/:statut'
                 },
                 'bapCourant' :
                 {
                     method: 'GET',
                     transformResponse: function (data) {
                        data = angular.fromJson(data);
                        data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                        return data;},
                        url: '/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/EN_COURS'
                    },
                    'valider' : {
                        method : 'POST',
                        isArray:false,
                        url :'/HRPerformanceManagementSystem/resources/baps/valider'
                    },
                    'rejeter' : {
                        method : 'POST',
                        isArray:false,
                        url :'/HRPerformanceManagementSystem/resources/baps/rejeter'
                    },
                    'update': { method:'PUT' },
                    'save': { method:'POST' }
                });
});
