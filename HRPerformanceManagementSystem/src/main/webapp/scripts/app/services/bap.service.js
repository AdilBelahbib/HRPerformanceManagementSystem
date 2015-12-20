    'use strict';

    app
    .factory('Bap', function ($resource, $filter) {

        return $resource('/resources/baps/:id', {}, {
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
                        url: '/resources/baps/collaborateur/:id'
                    },
                    'bapByStatut' :
                    {
                     method: 'GET',
                     url: '/resources/baps/collaborateur/statut/:id/:statut'
                 },
                 'bapCourant' :
                 {
                     method: 'GET',
                     transformResponse: function (data) {
                        data = angular.fromJson(data);
                        data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                        return data;},
                        url: '/resources/baps/collaborateur/statut/:id/EN_COURS'
                    },
                    'valider' : {
                        method : 'POST',
                        isArray:false,
                        url :'/resources/baps/valider'
                    },
                    'rejeter' : {
                        method : 'POST',
                        isArray:false,
                        url :'/resources/baps/rejeter'
                    },
                    'update': { method:'PUT' },
                    'save': { method:'POST' }
                });
});
